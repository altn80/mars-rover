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
public class PlateauDimension {

    private final int width;
    private final int height;

    public PlateauDimension(int width, int height) {
        validateDimension(width, height);
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    private void validateDimension(int width, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Invalid plateau height");
        }

        if (width <= 0) {
            throw new IllegalArgumentException("Invalid plateau width");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.width;
        hash = 11 * hash + this.height;
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
        final PlateauDimension other = (PlateauDimension) obj;
        if (this.width != other.width) {
            return false;
        }
        return this.height == other.height;
    }
    
    
}
