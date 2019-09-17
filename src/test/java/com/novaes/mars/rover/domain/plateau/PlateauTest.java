/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

import com.novaes.mars.rover.domain.rover.Heading;
import com.novaes.mars.rover.domain.rover.Coordinate;
import com.novaes.mars.rover.domain.rover.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class PlateauTest {

    @Test
    public void testValidPlateau() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Plateau plateau = new Plateau(dimension);
        Assert.assertEquals(5, plateau.getHeight());
        Assert.assertEquals(5, plateau.getWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlateau() {
        PlateauDimension dimension = new PlateauDimension(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlateau2() {
        PlateauDimension dimension = new PlateauDimension(-1, 1);
    }

    @Test
    public void testValidateCoordinate() {
        PlateauDimension dimension = new PlateauDimension(5, 6);
        Plateau plateau = new Plateau(dimension);
        Coordinate coordinate = new Coordinate(0, 0, Heading.EAST);
        try {
            plateau.validateCoordinate(coordinate);
        } catch (IllegalStateException e) {
            Assert.fail("Valid Coordinate");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testValidateCoordinate2() {
        PlateauDimension dimension = new PlateauDimension(5, 6);
        Plateau plateau = new Plateau(dimension);
        Coordinate coordinate = new Coordinate(0, 7, Heading.EAST);
        plateau.validateCoordinate(coordinate);

    }

    @Test(expected = IllegalStateException.class)
    public void testValidateCoordinate3() {
        PlateauDimension dimension = new PlateauDimension(5, 6);
        Plateau plateau = new Plateau(dimension);
        Coordinate coordinate = new Coordinate(6, 7, Heading.EAST);
        plateau.validateCoordinate(coordinate);

    }

    @Test
    public void testPlateauAddRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Plateau plateau = new Plateau(dimension);
        Rover rover = new Rover("Rover1", new Coordinate(1, 2, Heading.EAST), plateau);
        plateau.addRover(rover);
        Assert.assertArrayEquals(new Rover[]{rover}, plateau.getRovers().toArray(new Rover[]{}));
    }

    @Test
    public void testPlateauGetRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Plateau plateau = new Plateau(dimension);
        Rover rover = new Rover("Rover1", new Coordinate(1, 2, Heading.EAST), plateau);
        plateau.addRover(rover);
        Assert.assertEquals(rover, plateau.getRover("Rover1"));
    }
}
