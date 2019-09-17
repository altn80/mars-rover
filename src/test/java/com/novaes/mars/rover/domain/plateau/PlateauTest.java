/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class PlateauTest {
    
    @Test
    public void testValidPlateau() {
        Plateau plateau = new Plateau(5,5);
        Assert.assertEquals(5, plateau.getHeight());
        Assert.assertEquals(5, plateau.getWidth());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValidPlateau() {
        Plateau plateau = new Plateau(0,-1);
    }
    
}
