/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

/**
 *
 * @author andre
 */
public class Plateau {

    private final int height;
    private final int width;

    public Plateau(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Invalid plateau dimensions");
        }
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
