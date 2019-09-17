/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import com.novaes.mars.rover.domain.plateau.Plateau;
import com.novaes.mars.rover.domain.rover.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class RoverTest {

    @Test
    public void testValidRover() {
        Position position = new Position(2, 5, Heading.EAST);
        Rover rover = new Rover("Rover1", position, new Plateau(5, 5));
        Assert.assertEquals("Rover1", rover.getName());
        Assert.assertEquals(2, rover.getPosition().getX());
        Assert.assertEquals(5, rover.getPosition().getY());
        Assert.assertEquals(Heading.EAST, rover.getPosition().getHeading());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover() {
        Position position = new Position(2, 5, Heading.EAST);
        Rover rover = new Rover(null, position, new Plateau(5, 5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTurnRightRover() {
        Position position = new Position(2, 5, Heading.EAST);
        Rover rover = new Rover("Rover1", position, new Plateau(5, 5));
        rover.processInstruction("L");
    }

}
