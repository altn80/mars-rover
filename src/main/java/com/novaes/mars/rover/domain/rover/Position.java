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

    private final int x;
    private final int y;
    private final Heading heading;

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

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getHeading().getHeading();
    }

}
