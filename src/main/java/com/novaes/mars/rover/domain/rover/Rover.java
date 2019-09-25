/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import com.novaes.mars.rover.domain.plateau.Plateau;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Rover {

    private final String name;
    private Coordinate coordinate;
    private final Plateau plateau;

    public Rover(String name, Coordinate coordinate, Plateau plateau) {
        validateRover(name, coordinate, plateau);
        this.name = name;
        this.coordinate = coordinate;
        this.plateau = plateau;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    private void validateRover(String name, Coordinate coordinate, Plateau plateau) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Rover needs a name");
        }
        if (coordinate == null) {
            throw new IllegalArgumentException("Rover needs a coordinate");
        }
        if (plateau == null) {
            throw new IllegalArgumentException("Rover needs a plateau to land");
        }
        plateau.validateCoordinate(coordinate);
        
    }

    public void processInstruction(String instructions) {
        instructions.chars().forEach(instruction -> {
            switch (instruction) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + getName() + " -> " + instruction);
            }
        });
    }

    private void turnLeft() {
        this.coordinate.updateHeading(getCoordinate().getHeading().turnLeft());
    }

    private void turnRight() {
        this.coordinate.updateHeading(getCoordinate().getHeading().turnRight());
    }

    private void moveForward() {
        Coordinate newCoordinate = getCoordinate().moveForward();
        plateau.validateCoordinate(newCoordinate);
        this.updateCoordinate(newCoordinate);
    }

    private void updateCoordinate(Coordinate newCoordinate) {
        this.coordinate = newCoordinate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rover other = (Rover) obj;
        return Objects.equals(this.name, other.name);
    }

}
