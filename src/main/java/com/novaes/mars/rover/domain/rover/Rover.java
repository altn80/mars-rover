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
    private Position position;
    private final Plateau plateau;

    public Rover(String name, Position position, Plateau plateau) {
        validateRover(name, position, plateau);
        this.name = name;
        this.position = position;
        this.plateau = plateau;
    }

    private void validateRover(String name, Position position, Plateau plateau) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Rover needs a name");
        }
        if (position == null) {
            throw new IllegalArgumentException("Rover needs a posision");
        }
        if (plateau == null) {
            throw new IllegalArgumentException("Rover needs a plateau to land");
        }
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

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    private void turnLeft() {
        this.position.updateHeading(getPosition().getHeading().turnLeft());
    }

    private void turnRight() {
        this.position.updateHeading(getPosition().getHeading().turnRight());
    }

    private void moveForward() {
        Position newPosition = getPosition().moveForward();
        plateau.validatePosition(position);
        this.updatePosition(newPosition);
    }
    
    private void updatePosition(Position newPosition) {
        this.position = newPosition;
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
