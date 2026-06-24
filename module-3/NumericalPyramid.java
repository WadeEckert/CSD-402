/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 3.2 - Numerical Pyramid
 * Date: June 24, 2026
 *
 * Description: This program uses nested for loops to display a numerical pyramid.
 * Each row prints powers of 2 in ascending order, then descending order,
 * followed by the @ symbol at the end of the line.
 */

public class NumericalPyramid {
    public static void main(String[] args) {

        // The pyramid has 7 rows, ending with 2^6, which is 64
        final int TOTAL_ROWS = 7;

        // Outer loop controls each row of the pyramid and iterates 7 times, one for each row
        for (int row = 0; row < TOTAL_ROWS; row++) {

            // Prints leading spaces before the numbers to create the pyramid shape
            for (int space = 0; space < TOTAL_ROWS - row - 1; space++) {
                System.out.print("    ");
            }

            // Prints powers of 2 in ascending order until the print out reaches 2^row
            for (int exponent = 0; exponent <= row; exponent++) {
                int value = (int) Math.pow(2, exponent);
                System.out.printf("%4d", value);
            }

            // Prints powers of 2 in descending order until the print out reaches 2^0
            for (int exponent = row - 1; exponent >= 0; exponent--) {
                int value = (int) Math.pow(2, exponent);
                System.out.printf("%4d", value);
            }

            // Prints spacing between the pyramid numbers and the @ symbol for readability
            for (int space = 0; space < TOTAL_ROWS - row; space++) {
                System.out.print("    ");
            }

            // Prints the @ symbol at the end of each line
            System.out.println("@");
        }
    }
}