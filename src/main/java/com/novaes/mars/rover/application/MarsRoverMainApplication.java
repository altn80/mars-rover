/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.mars.rover.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class MarsRoverMainApplication {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            String line = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                commands.add(line);
            }
        }
        System.out.println(commands);

    }

}
