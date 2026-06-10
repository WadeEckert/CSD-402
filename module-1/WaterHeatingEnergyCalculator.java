/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 1.3 - Programming Assignment
 * Date: June 9, 2026
 *
 * Description:
 * This program calculates the amount of energy required to heat water
 * from an initial temperature to a final temperature. The user enters
 * the mass of the water in kilograms and the starting and ending
 * temperatures in Celsius. The program then calculates the energy
 * required in Joules using the provided formula: 
 * Q = waterMass × (finalTemperature - initialTemperature) × 4184
 */

import java.util.Scanner;

public class WaterHeatingEnergyCalculator {

    public static void main(String[] args) {

        // Create Scanner object to read user input from the keyboard with try-with-resources to ensure it is closed properly
        try (Scanner input = new Scanner(System.in)) {

            // Prompt user for the mass of water in kilograms
            System.out.print("Enter the amount of water in kilograms: ");
            double waterMass = input.nextDouble();

            // Prompt user for the initial temperature in Celsius
            System.out.print("Enter the initial water temperature in degrees Celsius: ");
            double initialTemperature = input.nextDouble();

            // Prompt user for the final temperature in Celsius
            System.out.print("Enter the final water temperature in degrees Celsius: ");
            double finalTemperature = input.nextDouble();

            // Calculate the energy needed using the formula:
            // Q = waterMass × (finalTemperature - initialTemperature) × 4184
            double energy = waterMass * (finalTemperature - initialTemperature) * 4184;

            // Display the result to the user
            System.out.println("\nThe energy needed to heat this amount of water from " 
            + initialTemperature + "°C to " + finalTemperature + "°C is " + energy + " Joules.");
        }
    }
}