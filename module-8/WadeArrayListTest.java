/* 
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 8.2 - ArrayList Test
 * Date: July 29, 2026
 *
 * Description: This program collects integers from the user and stores them
 * in an ArrayList until the user enters 0. It validates each entry, passes
 * the completed ArrayList to a separate max() method, and displays the
 * largest stored value.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WadeArrayListTest {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            // Creates an ArrayList to store the integers entered by the user and a variable to hold the current integer.
            ArrayList<Integer> numbers = new ArrayList<>();
            int number;
            
            System.out.println("\n------------ArrayList Maximum Value Test------------");
            System.out.println("  This program collects integers from the user and ");
            System.out.println("  displays the largest value entered.");
            System.out.println("----------------------------------------------------\n");
            
            /*
             * A do-while loop ensures that at least one integer is collected.
             * The loop terminates when the user enters 0, which is also added to the ArrayList as required.
             * The inner while loop validates the user input, ensuring that only integers are accepted.
             */
            do {
                while (true) {
                    System.out.print("Enter an integer one at a time, or enter 0 to finish: ");
                    String userInput = input.nextLine().trim();
                    
                    if (userInput.isEmpty()) {
                        System.out.println("\nInput cannot be empty. Please enter an integer.\n");
                        continue;
                    }
                    
                    try {
                        number = Integer.parseInt(userInput);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid input. Please enter an integer.\n");
                    }
                }
                
                // The terminating value of 0 is also added to the ArrayList as required.
                numbers.add(number);

            } while (number != 0);
            
            // Passes the populated ArrayList to the max() method and displays the result.
            Integer largestValue = max(numbers);
            
            System.out.println("\nEntered values: " + numbers);
            System.out.println("Largest value: " + largestValue);
        }
    }

    /**
     * Finds and returns the largest Integer stored in an ArrayList.
     *
     * @param list the ArrayList containing the Integer values to compare
     * @return the largest stored value, or 0 if the ArrayList is empty
     */
    public static Integer max(ArrayList<Integer> list) {

        // An empty ArrayList has no value to compare, so the method returns 0.
        if (list.isEmpty()) {
            return 0;
        }

        // Initializes the largest value to the first element in the ArrayList.
        Integer largestValue = list.get(0);

        // Compares each remaining value with the largest value found so far.
        for (int index = 1; index < list.size(); index++) {
            Integer currentValue = list.get(index);

            // Updates the largest value if the current value is greater.
            if (currentValue > largestValue) {
                largestValue = currentValue;
            }
        }

        return largestValue;
    }
}