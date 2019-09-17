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
public class Rover {

    private int x;
    private int y;
    private String heading;

    public Rover(int x, int y, String heading) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid rover landing");
        }
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getHeading() {
        return heading;
    }

}
