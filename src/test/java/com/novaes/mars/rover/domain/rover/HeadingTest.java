/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.domain.rover;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class HeadingTest {
    
    @Test
    public void testValidHeading() {
        Heading heading = Heading.from("N");
        Assert.assertEquals(Heading.NORTH, heading);
        heading = Heading.from("E");
        Assert.assertEquals(Heading.EAST, heading);
        heading = Heading.from("W");
        Assert.assertEquals(Heading.WEST, heading);
        heading = Heading.from("S");
        Assert.assertEquals(Heading.SOUTH, heading);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHeading() {
        Heading heading = Heading.from(null);
    }
    
}
