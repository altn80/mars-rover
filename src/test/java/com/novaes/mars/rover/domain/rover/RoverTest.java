/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import com.novaes.mars.rover.domain.plateau.Plateau;
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
        Rover rover = new Rover("Rover1", coordinate, new Plateau(5, 5));
        Assert.assertEquals("Rover1", rover.getName());
        Assert.assertEquals(2, rover.getCoordinate().getX());
        Assert.assertEquals(4, rover.getCoordinate().getY());
        Assert.assertEquals(Heading.EAST, rover.getCoordinate().getHeading());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover(null, coordinate, new Plateau(5, 5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover2() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover("", coordinate, new Plateau(5, 5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover3() {
        Rover rover = new Rover("Rover1", null, new Plateau(5, 5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover4() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, null);
    }
    
    @Test
    public void testTurnRightRover() {
        Coordinate coordinate = new Coordinate(2, 4, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(5, 5));
        rover.processInstruction("R");
        Assert.assertEquals(Heading.SOUTH,rover.getCoordinate().getHeading());
    }
    
    @Test
    public void testTurnLeftRover() {
        Coordinate coordinate = new Coordinate(2, 4, Heading.EAST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(5, 5));
        rover.processInstruction("L");
        Assert.assertEquals(Heading.NORTH,rover.getCoordinate().getHeading());
    }
    
    @Test
    public void testMoveForwardRover() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.WEST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(5, 5));
        rover.processInstruction("M");
        Assert.assertEquals(1,rover.getCoordinate().getX());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInstruction() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.WEST);
        Rover rover = new Rover("Rover1", coordinate, new Plateau(5, 5));
        rover.processInstruction("X");
        
    }

}
