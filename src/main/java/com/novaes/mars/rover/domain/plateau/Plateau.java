/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Coordinate;
import com.novaes.mars.rover.domain.rover.Rover;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Plateau {

    private final PlateauDimension dimension;
    private final List<Rover> rovers;

    public Plateau(PlateauDimension dimension) {
        this.dimension = dimension;
        this.rovers = new ArrayList<>();
    }

    public int getHeight() {
        return this.dimension.getHeight();
    }

    public int getWidth() {
        return this.dimension.getWidth();
    }

    public List<Rover> getRovers() {
        return rovers;
    }
    
    public void validateCoordinate(Coordinate coordinate) {
        if (coordinate.getY() > getHeight() || coordinate.getY() < 0
                || coordinate.getX() > getWidth() || coordinate.getX() < 0) {
            throw new IllegalStateException("Out of plateau bounds");
        }
        if(rovers.stream().anyMatch(rover -> rover.getCoordinate().equals(coordinate))) {
            throw new IllegalStateException("Rover collision ");
        }
    }

    public void addRover(Rover rover) {
        if (rovers.contains(rover)) {
            throw new IllegalArgumentException("Rover's already landed: " + rover.getName());
        }
        rovers.add(rover);
    }

    public Rover getRover(String name) {
        Rover rover = this.rovers.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        if (rover == null) {
            throw new IllegalArgumentException("Rover has not landed on this Plateau: " + name);
        }
        return rover;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.dimension);
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
        final Plateau other = (Plateau) obj;
        return Objects.equals(this.dimension, other.dimension);
    }

}
