/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.plateau;

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
        Rover rover = new Rover(2, 3, "N");
        Assert.assertEquals(2, rover.getX());
        Assert.assertEquals(3, rover.getY());
        Assert.assertEquals("N", rover.getHeading());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRover() {
        Rover rover = new Rover(-2, 3, "N");
    }
    
}
