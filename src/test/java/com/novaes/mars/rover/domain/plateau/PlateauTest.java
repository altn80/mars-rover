/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Heading;
import com.novaes.mars.rover.domain.rover.Coordinate;
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
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlateau2() {
        Plateau plateau = new Plateau(-1, 1);
    }

    @Test
    public void testValidateCoordinate() {
        Plateau plateau = new Plateau(5, 6);
        Coordinate coordinate = new Coordinate(0, 0, Heading.EAST);
        try {
            plateau.validateCoordinate(coordinate);
        } catch (IllegalStateException e) {
            Assert.fail("Valid Coordinate");
        }

    }

    @Test(expected = IllegalStateException.class)
    public void testValidateCoordinate2() {
        Plateau plateau = new Plateau(5, 6);
        Coordinate coordinate = new Coordinate(0, 7, Heading.EAST);
        plateau.validateCoordinate(coordinate);

    }
    
    @Test(expected = IllegalStateException.class)
    public void testValidateCoordinate3() {
        Plateau plateau = new Plateau(5, 6);
        Coordinate coordinate = new Coordinate(6, 7, Heading.EAST);
        plateau.validateCoordinate(coordinate);

    }
}
