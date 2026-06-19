/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 2.2 - Rock, Paper, Scissors
 * Date: June 18, 2026
 *
 * Description: This program demonstrates a Rock-Paper-Scissors game that generates a random choice for
 * the computer, accepts and validates user input, displays both selections, and determines the winner.
 */

// Import the Scanner class to read input from the user
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        // Create Scanner object to read user input from the keyboard with try-with-resources to ensure it is closed properly
        try (Scanner input = new Scanner(System.in)) {

            // Generate computer choice (1-3)
            int computerChoice = (int)(Math.random() * 3) + 1;
            
            // Display instructions to the console for the user to read
            System.out.println("Welcome to Rock-Paper-Scissors!\n");
            
            System.out.println("Please choose one of the following:");
            System.out.println("1 = Rock");
            System.out.println("2 = Paper");
            System.out.println("3 = Scissors\n");
            
            // Validate integer input to check if it is an integer and in the appropriate range
            // Allows user to reenter input after displaying error message
            int userChoice;

            while (true) {

                System.out.print("Enter your choice: ");

                if (!input.hasNextInt()) {
                    System.out.println("\nError: Please enter a whole number (1, 2, or 3).\n");
                    input.next(); // Clear invalid input
                    continue;
                }

                userChoice = input.nextInt();

                if (userChoice >= 1 && userChoice <= 3) {
                    break;
                }

                System.out.println("\nError: Please enter a whole number (1, 2, or 3).\n");
            }
            
            // Convert computer choice to text for displaying to the console
            String computerSelection = switch (computerChoice) {
                case 1 -> "Rock";
                case 2 -> "Paper";
                case 3 -> "Scissors";
                default -> "";
            };
            
            // Convert user choice to text for displaying to the console
            String userSelection = switch (userChoice) {
                case 1 -> "Rock";
                case 2 -> "Paper";
                case 3 -> "Scissors";
                default -> "";
            };
            
            // Display selections to the console
            System.out.println("\nComputer chose: " + computerSelection + " (" + computerChoice + ")");
            System.out.println("You chose: " + userSelection + " (" + userChoice + ")\n");
            
            // Determine winner and display the result to the console
            if (computerChoice == userChoice) {
                System.out.println("Result: It's a tie!");
                
            } else if ((userChoice == 1 && computerChoice == 3)
                    || (userChoice == 2 && computerChoice == 1)
                    || (userChoice == 3 && computerChoice == 2)) {
                System.out.println("Result: You win!");
                
            } else {
                System.out.println("Result: Computer wins!");
            }
        }
    }
}
