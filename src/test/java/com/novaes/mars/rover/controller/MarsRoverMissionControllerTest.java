/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.controller;

import com.novaes.mars.rover.domain.plateau.Plateau;
import com.novaes.mars.rover.domain.plateau.PlateauDimension;
import com.novaes.mars.rover.domain.rover.Coordinate;
import com.novaes.mars.rover.domain.rover.Heading;
import com.novaes.mars.rover.domain.rover.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class MarsRoverMissionControllerTest {

    @Test
    public void testBuildPlateau() {
        Assert.assertEquals(new Plateau(new PlateauDimension(5, 6)), new MarsRoverMissionController().buildPlateau("Plateau:5 6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildPlateauInvalidCommand() {
        Assert.assertEquals(new Plateau(new PlateauDimension(5, 6)), new MarsRoverMissionController().buildPlateau("XXXXX:5 6"));
    }

    @Test
    public void testLandRover() {
        Plateau plateau = new Plateau(new PlateauDimension(5, 6));
        Assert.assertEquals(new Rover("Rover1", new Coordinate(1, 2, Heading.from("N")), plateau),
                new MarsRoverMissionController().landRover("Rover1 Landing:1 2 N", plateau));
    }

    @Test
    public void testProcessRoverInstruction() {
        Plateau plateau = new Plateau(new PlateauDimension(5, 6));
        plateau.addRover(new Rover("Rover1", new Coordinate(1, 2, Heading.from("N")), plateau));
        new MarsRoverMissionController().processRoverInstruction("Rover1 Instructions:LMLMLMLMM", plateau);
        Assert.assertEquals("1 3 N", plateau.getRover("Rover1").getCoordinate().toString());
    }

    @Test
    public void testLaunch() {
        String[] commands = new String[]{"Plateau:5 5",
            "Rover1 Landing:1 2 N",
            "Rover1 Instructions:LMLMLMLMM",
            "Rover2 Landing:3 3 E",
            "Rover2 Instructions:MMRMMRMRRM"};
        String result = "Rover1:1 3 N\n"
                + "Rover2:5 1 E";
        Assert.assertEquals(result, new MarsRoverMissionController().launch(commands));
    }

}
