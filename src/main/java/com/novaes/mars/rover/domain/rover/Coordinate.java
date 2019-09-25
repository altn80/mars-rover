/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

/**
 *
 * @author andre
 */
public class Coordinate {

    private int x;
    private int y;
    private Heading heading;

    public Coordinate(int x, int y, Heading heading) {
        validateCoordinate(x, y, heading);
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    private void validateCoordinate(int x, int y, Heading heading) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid X coordinate rover landing");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Invalid Y coordinate rover landing");
        }
        if (heading == null) {
            throw new IllegalArgumentException("Invalid rover Heading landing");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Heading getHeading() {
        return heading;
    }

    void updateHeading(Heading newHeading) {
        this.heading = newHeading;
    }

    Coordinate moveForward() {
        switch (this.heading) {
            case NORTH:
                return new Coordinate(x, y+1, heading);
            case EAST:
                return new Coordinate(x+1, y, heading);
            case SOUTH:
                return new Coordinate(x, y-1, heading);
            case WEST:
                return new Coordinate(x-1, y, heading);
            default:
                throw new IllegalArgumentException("Invalid Heading: " + heading);
        }
    }

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getHeading().getHeading();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
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
        final Coordinate other = (Coordinate) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }
    
    

}
