/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Rover;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Plateau {

    private final int height;
    private final int width;
    private final List<Rover> rovers;

    public Plateau(int height, int width) {
        validatePlateau(height, width);
        this.height = height;
        this.width = width;
        this.rovers = new ArrayList<>();
    }

    private void validatePlateau(int height, int width) {
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

}
