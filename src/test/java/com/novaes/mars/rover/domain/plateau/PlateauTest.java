/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Heading;
import com.novaes.mars.rover.domain.rover.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class PlateauTest {

    @Test
    public void testValidPlateau() {
        Plateau plateau = new Plateau(5, 5);
        Assert.assertEquals(5, plateau.getHeight());
        Assert.assertEquals(5, plateau.getWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlateau() {
        Plateau plateau = new Plateau(0, -1);
    }

    @Test
    public void testValidatePosition() {
        Plateau plateau = new Plateau(5, 6);
        Position position = new Position(0, 0, Heading.EAST);
        try {
            plateau.validatePosition(position);
        } catch (IllegalStateException e) {
            Assert.fail("Valid Position");
        }

    }

    @Test(expected = IllegalStateException.class)
    public void testValidatePosition2() {
        Plateau plateau = new Plateau(5, 6);
        Position position = new Position(0, 7, Heading.EAST);
        plateau.validatePosition(position);

    }
    
    @Test(expected = IllegalStateException.class)
    public void testValidatePosition3() {
        Plateau plateau = new Plateau(5, 6);
        Position position = new Position(5, 6, Heading.EAST);
        plateau.validatePosition(position);

    }

}
