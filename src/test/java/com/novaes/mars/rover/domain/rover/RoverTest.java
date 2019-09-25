/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import com.novaes.mars.rover.domain.plateau.Plateau;
import com.novaes.mars.rover.domain.plateau.PlateauDimension;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class RoverTest {

    @Test
    public void testValidRover() {
        Coordinate coordinate = new Coordinate(2, 4, Heading.EAST);
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(dimension));
        Assert.assertEquals("Rover1", rover.getName());
        Assert.assertEquals(2, rover.getCoordinate().getX());
        Assert.assertEquals(4, rover.getCoordinate().getY());
        Assert.assertEquals(Heading.EAST, rover.getCoordinate().getHeading());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover(null, coordinate, new Plateau(dimension));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover2() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover("", coordinate, new Plateau(dimension));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover3() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Rover rover = new Rover("Rover1", null, new Plateau(dimension));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover4() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, null);
    }
    
    @Test
    public void testTurnRightRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 4, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(dimension));
        rover.processInstruction("R");
        Assert.assertEquals(Heading.SOUTH,rover.getCoordinate().getHeading());
    }
    
    @Test
    public void testTurnLeftRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 4, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(dimension));
        rover.processInstruction("L");
        Assert.assertEquals(Heading.NORTH,rover.getCoordinate().getHeading());
    }
    
    @Test
    public void testMoveForwardRover() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 5, Heading.WEST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(dimension));
        rover.processInstruction("M");
        Assert.assertEquals(1,rover.getCoordinate().getX());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInstruction() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Coordinate coordinate = new Coordinate(2, 5, Heading.WEST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(dimension));
        rover.processInstruction("X");
    }
    
    @Test(expected = IllegalStateException.class)
    public void testTwoRoversLandingSameCoordinate() {
        PlateauDimension dimension = new PlateauDimension(5, 5);
        Plateau plateau = new Plateau(dimension);
        Coordinate coordinate = new Coordinate(0, 2, Heading.NORTH);
        Rover rover = new Rover("Rover1", coordinate, plateau);
        Rover rover2 = new Rover("Rover2", coordinate, plateau);
        plateau.addRover(rover);
        plateau.addRover(rover2);
        rover.processInstruction("M");
        rover2.processInstruction("M");
        
    }

}
