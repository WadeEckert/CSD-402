/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 9.2 - Program 2: Random Number File
 * Date: August 9, 2026
 * Description: This program creates a file named data.file if it does not exist and writes or
 * appends 10 randomly generated integers. It then closes the file, reopens it, and displays
 * all integers currently stored in the file.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class WadeRandomNumberFile {

    public static void main(String[] args) {

        // Constants for the number of random integers to generate and the upper limit for the random numbers.
        final int NUMBERS_TO_GENERATE = 10;
        final int RANDOM_NUMBER_LIMIT = 100;

        // Define the path to the file where random numbers will be stored.
        Path filePath = Path.of("data.file");

        // Create a Random object to generate random integers and an array to hold the generated numbers.
        Random random = new Random();
        int[] generatedNumbers = new int[NUMBERS_TO_GENERATE];

        System.out.println("========================================");
        System.out.println("       Random Number File Manager");
        System.out.println("========================================");

        try {
            // Check if the file already exists and if it contains any data.
            // Store the results in boolean variables for later use.
            boolean fileAlreadyExists = Files.exists(filePath);
            boolean fileContainsData = fileAlreadyExists && Files.size(filePath) > 0;

            // Generate 10 random integers from 1 through 100 for this program run.
            for (int index = 0; index < generatedNumbers.length; index++) {
                generatedNumbers[index] = random.nextInt(RANDOM_NUMBER_LIMIT) + 1;
            }

            // CREATE makes the file when necessary, and APPEND preserves any previous numbers.
            try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

                for (int index = 0; index < generatedNumbers.length; index++) {
                    // Add a separator before the first new number only when the file already contains data.
                    if (fileContainsData || index > 0) {
                        writer.write(" ");
                    }

                    // Write the generated number to the file as a String.
                    writer.write(Integer.toString(generatedNumbers[index]));
                }
            }

            if (fileAlreadyExists) {
                System.out.println("\nFile status: Existing data.file opened successfully.");
                System.out.println("Write action: 10 random integers were appended to the file.");

            } else {
                System.out.println("\nFile status: A new data.file was created successfully.");
                System.out.println("Write action: 10 random integers were written to the file.");
            }

            // Display the numbers added during this run in a formatted manner.
            System.out.println("\nNumbers added during this run:");
            System.out.print("  ");

            // Use a for-each loop to display the generated numbers with a format specifier for alignment.
            for (int number : generatedNumbers) {
                System.out.printf("%4d", number);
            }

            System.out.println("\n\nThe file was closed after writing and reopened for reading.");
            System.out.println("Complete contents of data.file:");

            // Reopen the file and read all integers currently stored in it.
            try (Scanner fileReader = new Scanner(Files.newBufferedReader(filePath))) {
                
                // Initialize a counter to keep track of the number of integers read from the file.
                int numberCount = 0;

                // Use a while loop to read integers from the file until there are no more integers to read.
                while (fileReader.hasNextInt()) {

                    // Indent the first number on each console line for consistent formatting.
                    if (numberCount % NUMBERS_TO_GENERATE == 0) {
                        System.out.print("  ");
                    }

                    // Read the next integer from the file and display it with a format specifier for alignment.
                    System.out.printf("%4d", fileReader.nextInt());
                    numberCount++;

                    // After every 10 numbers, print a newline to start a new line for the next set of numbers.
                    if (numberCount % NUMBERS_TO_GENERATE == 0) {
                        System.out.println();
                    }
                }

                // If the total number of integers read is not a multiple of 10, print a newline to ensure proper formatting.
                if (numberCount % NUMBERS_TO_GENERATE != 0) {
                    System.out.println();
                }

                System.out.println("\nTotal integers stored: " + numberCount);
            }

            System.out.println("File location: " + filePath.toAbsolutePath());

        } catch (IOException exception) {
            System.out.println("\nA file operation could not be completed.");
            System.out.println("Exception message: " + exception.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("      File processing is complete.");
        System.out.println("========================================");
    }
}
