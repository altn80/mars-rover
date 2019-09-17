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
public class PositionTest {

    @Test
    public void testValidPosition() {
        Position position = new Position(2, 5, Heading.EAST);
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(5, position.getY());
        Assert.assertEquals(Heading.EAST, position.getHeading());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosition1() {
        Position position = new Position(-2, 5, Heading.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosition2() {
        Position position = new Position(2, -5, Heading.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosition3() {
        Position position = new Position(2, 5, null);
    }

    @Test
    public void testMovingNorth() {
        Position position = new Position(2, 5, Heading.NORTH);
        position.move();
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(6, position.getY());
        Assert.assertEquals(Heading.NORTH, position.getHeading());
    }

    @Test
    public void testMovingSouth() {
        Position position = new Position(2, 5, Heading.SOUTH);
        position.move();
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(4, position.getY());
        Assert.assertEquals(Heading.SOUTH, position.getHeading());
    }

    @Test
    public void testMovingEast() {
        Position position = new Position(2, 5, Heading.EAST);
        position.move();
        Assert.assertEquals(3, position.getX());
        Assert.assertEquals(5, position.getY());
        Assert.assertEquals(Heading.EAST, position.getHeading());
    }

    @Test
    public void testMovingWest() {
        Position position = new Position(2, 5, Heading.WEST);
        position.move();
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(5, position.getY());
        Assert.assertEquals(Heading.WEST, position.getHeading());
    }

}
