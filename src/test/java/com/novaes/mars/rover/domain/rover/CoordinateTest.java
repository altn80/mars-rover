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
public class CoordinateTest {

    @Test
    public void testValidCoordinate() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Assert.assertEquals(2, coordinate.getX());
        Assert.assertEquals(5, coordinate.getY());
        Assert.assertEquals(Heading.EAST, coordinate.getHeading());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCoordinate1() {
        Coordinate coordinate = new Coordinate(-2, 5, Heading.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCoordinate2() {
        Coordinate coordinate = new Coordinate(2, -5, Heading.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCoordinate3() {
        Coordinate coordinate = new Coordinate(2, 5, null);
    }

    @Test
    public void testMovingNorth() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.NORTH);
        Coordinate newCoordinate = coordinate.moveForward();
        Assert.assertEquals(2, newCoordinate.getX());
        Assert.assertEquals(6, newCoordinate.getY());
        Assert.assertEquals(Heading.NORTH, newCoordinate.getHeading());
    }

    @Test
    public void testMovingSouth() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.SOUTH);
        Coordinate newCoordinate = coordinate.moveForward();
        Assert.assertEquals(2, newCoordinate.getX());
        Assert.assertEquals(4, newCoordinate.getY());
        Assert.assertEquals(Heading.SOUTH, newCoordinate.getHeading());
    }

    @Test
    public void testMovingEast() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.EAST);
        Coordinate newCoordinate = coordinate.moveForward();
        Assert.assertEquals(3, newCoordinate.getX());
        Assert.assertEquals(5, newCoordinate.getY());
        Assert.assertEquals(Heading.EAST, newCoordinate.getHeading());
    }

    @Test
    public void testMovingWest() {
        Coordinate coordinate = new Coordinate(2, 5, Heading.WEST);
        Coordinate newCoordinate = coordinate.moveForward();
        Assert.assertEquals(1, newCoordinate.getX());
        Assert.assertEquals(5, newCoordinate.getY());
        Assert.assertEquals(Heading.WEST, newCoordinate.getHeading());
    }

}
