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
public class Position {

    private int x;
    private int y;
    private Heading heading;

    public Position(int x, int y, Heading heading) {
        validatePosition(x, y, heading);
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    private void validatePosition(int x, int y, Heading heading) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid X position rover landing");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Invalid Y position rover landing");
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

    Position moveForward() {
        switch (this.heading) {
            case NORTH:
                return new Position(x, y+1, heading);
            case EAST:
                return new Position(x+1, y, heading);
            case SOUTH:
                return new Position(x, y-1, heading);
            case WEST:
                return new Position(x-1, y, heading);
            default:
                throw new IllegalArgumentException("Invalid Heading: " + heading);
        }
    }

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getHeading().getHeading();
    }

}
