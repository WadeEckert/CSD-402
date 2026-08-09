/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 9.2 - Program 1: ArrayList Exception Handling
 * Date: August 9, 2026
 * Description: This program stores and displays a collection of strings, then allows the user
 * to select an element by its index. It demonstrates exception handling along with autoboxing
 * and auto-unboxing while allowing the user to retry or quit the program.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WadeArrayListException {

    public static void main(String[] args) {

        ArrayList<String> programmingLanguages = new ArrayList<>();

        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("C#");
        programmingLanguages.add("C++");
        programmingLanguages.add("PHP");
        programmingLanguages.add("Swift");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Ruby");
        programmingLanguages.add("Go");

        // Use try-with-resources to ensure the Scanner is closed automatically.
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("========================================");
            System.out.println("      Programming Language Lookup");
            System.out.println("========================================");
            System.out.println("\n      Available ArrayList elements:\n");

            int index = 0;

            // Display the elements of the ArrayList with their corresponding indices with a for-each loop and format specifier.
            for (String language : programmingLanguages) {
                System.out.printf("  [%d] %s%n", index, language);
                index++;
            }

            while (true) {
                System.out.print("\nEnter an index (0 - " + (programmingLanguages.size() - 1) + ") to view that element again, or Q to quit: ");

                // Read the user input and trim any leading or trailing whitespace.
                String userInput = scanner.nextLine().trim();

                // Allow a way for the user to exit the loop and end the program by entering "Q" or "q".
                if (userInput.equalsIgnoreCase("Q")) {
                    break;
                }

                try {
                    // Convert the user's String input into a primitive int.
                    int parsedIndex = Integer.parseInt(userInput);

                    // Autobox the primitive int into an Integer object.
                    Integer selectedIndex = parsedIndex;

                    // Auto-unbox the Integer object into the int required by get().
                    String selectedLanguage = programmingLanguages.get(selectedIndex);

                    System.out.println("\n----------------------------------------");
                    System.out.printf("Element at index %d: %s%n", selectedIndex, selectedLanguage);
                    System.out.println("----------------------------------------");

                } catch (NumberFormatException exception) {
                    System.out.println("\nException thrown: Invalid number format.");
                    System.out.println("Please enter a whole-number index from 0 to " + (programmingLanguages.size() - 1) + ", or Q to quit.");

                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("\nException thrown: Out of Bounds.");
                    System.out.println("Please enter an index from 0 to " + (programmingLanguages.size() - 1) + ", or Q to quit.");

                } catch (Exception exception) {
                    System.out.println("\nAn unexpected exception was thrown: " + exception.getMessage());
                    System.out.println("Please try again, or enter Q to quit.");
                }
            }

            System.out.println("\n========================================");
            System.out.println("      Program ended. Thank you!");
            System.out.println("========================================");
        }
    }
}
