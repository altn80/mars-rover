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

    private final String name;
    private final Position position;

    public Rover(String name, Position position) {
        validateRover(name, position);
        this.name = name;
        this.position = position;
    }

    private void validateRover(String name, Position position) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Rover needs a name");
        }
        if (position == null) {
            throw new IllegalArgumentException("Rover needs a posision");
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
