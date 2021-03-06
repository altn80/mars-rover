/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author kbos
 */
public enum Heading {

    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    private final String heading;

    private Heading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return heading;
    }
    
    public Heading turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid Heading");
        }
    }
    public Heading turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid Heading");
        }
    }
    

    public static Heading from(String heading) {
        if (heading == null || heading.trim().isEmpty()) {
            throw new IllegalArgumentException("Heading must be informed");
        }
        Heading result = Arrays.
                stream(Heading.values()).
                filter(h -> h.getHeading().equals(heading)).
                findFirst().
                orElse(null);
        if (Objects.isNull(result)) {
            throw new IllegalArgumentException("Invalid Heading: " + heading);
        }
        return result;
    }

}
