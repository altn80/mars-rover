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
        Position newPosition = position.moveForward();
        Assert.assertEquals(2, newPosition.getX());
        Assert.assertEquals(6, newPosition.getY());
        Assert.assertEquals(Heading.NORTH, newPosition.getHeading());
    }

    @Test
    public void testMovingSouth() {
        Position position = new Position(2, 5, Heading.SOUTH);
        Position newPosition = position.moveForward();
        Assert.assertEquals(2, newPosition.getX());
        Assert.assertEquals(4, newPosition.getY());
        Assert.assertEquals(Heading.SOUTH, newPosition.getHeading());
    }

    @Test
    public void testMovingEast() {
        Position position = new Position(2, 5, Heading.EAST);
        Position newPosition = position.moveForward();
        Assert.assertEquals(3, newPosition.getX());
        Assert.assertEquals(5, newPosition.getY());
        Assert.assertEquals(Heading.EAST, newPosition.getHeading());
    }

    @Test
    public void testMovingWest() {
        Position position = new Position(2, 5, Heading.WEST);
        Position newPosition = position.moveForward();
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(5, newPosition.getY());
        Assert.assertEquals(Heading.WEST, newPosition.getHeading());
    }

}
