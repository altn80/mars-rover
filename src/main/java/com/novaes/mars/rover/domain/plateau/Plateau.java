/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Position;
import com.novaes.mars.rover.domain.rover.Rover;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Plateau {

    private final int width;
    private final int height;
    private final List<Rover> rovers;

    public Plateau(int width, int height) {
        validatePlateau(width, height);
        this.width = width;
        this.height = height;
        this.rovers = new ArrayList<>();
    }

    private void validatePlateau(int width, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Invalid plateau height");
        }

        if (width <= 0) {
            throw new IllegalArgumentException("Invalid plateau width");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public void validatePosition(Position position) {
        if(position.getY() > this.height - 1  || position.getY() < 0 ||
                position.getX() > this.width - 1 || position.getX() < 0) {
            throw new IllegalStateException("Out of plateau bounds");
        }
    }

}
