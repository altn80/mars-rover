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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class MarsRoverMissionController {

    static String REGEX_PLATEAU_COMMAND = "^Plateau:([1-9][0-9]*) ([1-9][0-9]*)$";
    static String REGEX_PLATEAU_DIMENSIONS = "([1-9][0-9]*) ([1-9][0-9]*)$";
    static String REGEX_ROVER_LANDING_COMMAND = "^Rover([1-9][0-9]*) Landing:([0-9]*) ([0-9]*) [N|S|W|E]$";
    static String REGEX_ROVER_IDENTIFIER = "^Rover([1-9][0-9]*)";
    static String REGEX_ROVER_LANDING_POSITION = "([0-9]*) ([0-9]*) [N|S|W|E]$";
    static String REGEX_ROVER_INSTRUCTIONS_COMMAND = "^Rover([1-9][0-9]*) Instructions:[L|R|M]*$";
    static String REGEX_ROVER_INSTRUCTIONS = "[L|R|M]*$";

    public String launch(String[] commands) {
        Plateau plateau = buildPlateau(commands[0]);
        for (int i = 1; i < commands.length; i++) {
            processRoversCommand(commands[i], plateau);
        }
        return plateau.getRovers().
                stream().
                map(rover -> (rover.getName() + ":" + rover.getCoordinate().toString())).
                collect(Collectors.joining("\n"));
    }

    Plateau buildPlateau(String plateauCommand) {
        if (!plateauCommand.matches(REGEX_PLATEAU_COMMAND)) {
            throw new IllegalArgumentException("Invalid Plateau creation command.");
        }
        return new Plateau(getPlateauDimension(plateauCommand));
    }

    private PlateauDimension getPlateauDimension(String plateauCommand) {
        Pattern pattern = Pattern.compile(REGEX_PLATEAU_DIMENSIONS);
        Matcher matcher = pattern.matcher(plateauCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Plateau creation command.");
        }
        String[] dimensions = matcher.group().split(" ");
        int width = Integer.valueOf(dimensions[0]);
        int height = Integer.valueOf(dimensions[1]);
        return new PlateauDimension(width, height);
    }

    Rover landRover(String roverCommand, Plateau plateau) {
        Pattern pattern = Pattern.compile(REGEX_ROVER_LANDING_COMMAND);
        Matcher matcher = pattern.matcher(roverCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Rover landing command.");
        }
        String name = identifyRover(roverCommand);
        Coordinate coordinate = getRoverCoordinate(roverCommand);
        Rover rover = new Rover(name, coordinate, plateau);
        plateau.addRover(rover);
        return rover;
    }

    private String identifyRover(String roverCommand) {
        Pattern pattern = Pattern.compile(REGEX_ROVER_IDENTIFIER);
        Matcher matcher = pattern.matcher(roverCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Rover command.");
        }
        return matcher.group();
    }

    private Coordinate getRoverCoordinate(String roverCommand) {
        Pattern pattern = Pattern.compile(REGEX_ROVER_LANDING_POSITION);
        Matcher matcher = pattern.matcher(roverCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Rover command.");
        }
        String[] coordinates = matcher.group().split(" ");
        int x = Integer.valueOf(coordinates[0]);
        int y = Integer.valueOf(coordinates[1]);
        Heading heading = Heading.from(coordinates[2]);
        return new Coordinate(x, y, heading);
    }

    private void processRoversCommand(String command, Plateau plateau) {
        if (!(command.matches(REGEX_ROVER_LANDING_COMMAND) || command.matches(REGEX_ROVER_INSTRUCTIONS_COMMAND))) {
            throw new IllegalArgumentException("Invalid Rover command.");
        }
        if (command.matches(REGEX_ROVER_LANDING_COMMAND)) {
            landRover(command, plateau);
        }
        if (command.matches(REGEX_ROVER_INSTRUCTIONS_COMMAND)) {
            processRoverInstruction(command, plateau);
        }
    }

    void processRoverInstruction(String command, Plateau plateau) {
        Pattern pattern = Pattern.compile(REGEX_ROVER_INSTRUCTIONS_COMMAND);
        Matcher matcher = pattern.matcher(command);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Rover instructions command.");
        }
        pattern = Pattern.compile(REGEX_ROVER_INSTRUCTIONS);
        matcher = pattern.matcher(command);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Rover instructions command.");
        }
        String roverName = identifyRover(command);
        Rover rover = plateau.getRover(roverName);
        rover.processInstruction(matcher.group());
    }

}
