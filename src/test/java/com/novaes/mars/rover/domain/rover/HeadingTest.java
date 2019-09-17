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

    @Test
    public void testTurnLeftHeading() {
        Heading heading = Heading.from("N");
        Assert.assertEquals(Heading.WEST, heading.turnLeft());
        Assert.assertEquals(Heading.SOUTH, heading.turnLeft().turnLeft());
        Assert.assertEquals(Heading.EAST, heading.turnLeft().turnLeft().turnLeft());
        Assert.assertEquals(Heading.NORTH, heading.turnLeft().turnLeft().turnLeft().turnLeft());

    }

    @Test
    public void testTurnRightHeading() {
        Heading heading = Heading.from("N");
        Assert.assertEquals(Heading.EAST, heading.turnRight());
        Assert.assertEquals(Heading.SOUTH, heading.turnRight().turnRight());
        Assert.assertEquals(Heading.WEST, heading.turnRight().turnRight().turnRight());
        Assert.assertEquals(Heading.NORTH, heading.turnRight().turnRight().turnRight().turnRight());
    }

}
