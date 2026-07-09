/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 5.2 - Multi-Dimensional Arrays
 * Date: July 08, 2026
 *
 * Description:
 * This program generates random two-dimensional integer and double arrays,
 * then locates the largest and smallest elements within each array. The
 * program returns and displays the row and column location of each value
 * along with the value itself.
 *
 * If duplicate largest or smallest values exist, the first occurrence
 * encountered during the search (top-to-bottom, left-to-right) is returned.
 */

public class MultiDimensionalArray {

    //==================================================
    // Main Method
    //==================================================

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("              Multi-Dimensional Array Locator");
        System.out.println("============================================================");
        System.out.println("This program generates random integer and double");
        System.out.println("two-dimensional arrays and locates the largest");
        System.out.println("and smallest elements within each array.");
        System.out.println();
        System.out.println("If multiple elements share the same largest or");
        System.out.println("smallest value, the first occurrence encountered");
        System.out.println("during the search will be displayed.");
        System.out.println("============================================================\n");

        // Randomly determine the dimensions for each array (1–5 rows and columns).
        int doubleRows = 1 + (int) (Math.random() * 5);
        int doubleCols = 1 + (int) (Math.random() * 5);

        int intRows = 1 + (int) (Math.random() * 5);
        int intCols = 1 + (int) (Math.random() * 5);

        // Create the two-dimensional arrays with the randomly determined dimensions.
        double[][] doubleArray = new double[doubleRows][doubleCols];
        int[][] intArray = new int[intRows][intCols];

        // Populate the double array with random values between 1.00 and 100.00.
        for (int row = 0; row < doubleRows; row++) {
            for (int column = 0; column < doubleCols; column++) {
                doubleArray[row][column] = 1 + (Math.random() * 99);
            }
        }

        // Populate the integer array with random values between 1 and 100.
        for (int row = 0; row < intRows; row++) {
            for (int column = 0; column < intCols; column++) {
                intArray[row][column] = 1 + (int) (Math.random() * 100);
            }
        }

        // Locate the largest and smallest values within each array.
        int[] largestDouble = locateLargest(doubleArray);
        int[] smallestDouble = locateSmallest(doubleArray);

        int[] largestInt = locateLargest(intArray);
        int[] smallestInt = locateSmallest(intArray);

        // Display the double array and its results.
        displayArray(doubleArray);

        // Use printf to format the output for the largest and smallest double values with two decimal places.
        System.out.printf("%nLargest double value: %.2f located at [%d][%d]%n",
                doubleArray[largestDouble[0]][largestDouble[1]],
                largestDouble[0],
                largestDouble[1]);

        // Use printf to format the output for the smallest double value with two decimal places.
        System.out.printf("Smallest double value: %.2f located at [%d][%d]%n",
                doubleArray[smallestDouble[0]][smallestDouble[1]],
                smallestDouble[0],
                smallestDouble[1]);

        System.out.println("\n------------------------------------------------------------\n");

        // Display the integer array and its results.
        displayArray(intArray);

        // Use printf to format the output for the largest integer value.
        System.out.printf("%nLargest integer value: %d located at [%d][%d]%n",
                intArray[largestInt[0]][largestInt[1]],
                largestInt[0],
                largestInt[1]);

        // Use printf to format the output for the smallest integer value.
        System.out.printf("Smallest integer value: %d located at [%d][%d]%n",
                intArray[smallestInt[0]][smallestInt[1]],
                smallestInt[0],
                smallestInt[1]);

        System.out.println("\n============================================================");
        System.out.println("                  Program Complete");
        System.out.println("============================================================");
    }

    //==================================================
    // Largest Element Methods
    //==================================================

    // Returns the location of the largest element within a double array.
    // Stores the row and column indices of the largest value in a two-element array and returns it.
    public static int[] locateLargest(double[][] arrayParam) {

        // Initialize an array to hold the row and column indices of the largest value.
        int[] location = {0, 0};

        // Begin searching using the first element in the array.
        double largest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int column = 0; column < arrayParam[row].length; column++) {

                if (arrayParam[row][column] > largest) {
                    largest = arrayParam[row][column];   // Update the largest value.
                    location[0] = row;                   // Store the row index.
                    location[1] = column;                // Store the column index.
                }
            }
        }

        return location;
    }

    // Returns the location of the largest element within an integer array.
    // Stores the row and column indices of the largest value in a two-element array and returns it.
    public static int[] locateLargest(int[][] arrayParam) {

        int[] location = {0, 0};

        int largest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int column = 0; column < arrayParam[row].length; column++) {

                if (arrayParam[row][column] > largest) {
                    largest = arrayParam[row][column];
                    location[0] = row;
                    location[1] = column;
                }
            }
        }

        return location;
    }

    //==================================================
    // Smallest Element Methods
    //==================================================

    // Returns the location of the smallest element within a double array.
    // Stores the row and column indices of the smallest value in a two-element array and returns it.
    public static int[] locateSmallest(double[][] arrayParam) {

        int[] location = {0, 0};

        double smallest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int column = 0; column < arrayParam[row].length; column++) {

                if (arrayParam[row][column] < smallest) {
                    smallest = arrayParam[row][column];
                    location[0] = row;
                    location[1] = column;
                }
            }
        }

        return location;
    }

    // Returns the location of the smallest element within an integer array.
    // Stores the row and column indices of the smallest value in a two-element array and returns it.
    public static int[] locateSmallest(int[][] arrayParam) {

        int[] location = {0, 0};

        int smallest = arrayParam[0][0];

        for (int row = 0; row < arrayParam.length; row++) {
            for (int column = 0; column < arrayParam[row].length; column++) {

                if (arrayParam[row][column] < smallest) {
                    smallest = arrayParam[row][column];
                    location[0] = row;
                    location[1] = column;
                }
            }
        }

        return location;
    }

    //==================================================
    // Display Methods
    //==================================================

    // Displays a formatted two-dimensional double array for better readability.
    public static void displayArray(double[][] array) {

        System.out.println("Double Array:");
        System.out.println("{");

        // Use an enhanced for loop to iterate through each row of the two-dimensional array.
        for (double[] row : array) {
            System.out.print("    { ");

            // Use an enhanced for loop to iterate through each element in the current row.
            // Use printf to format the output for each double value with two decimal places and a width of 7 characters for alignment.
            for (double value : row) {
                System.out.printf("%7.2f ", value);
            }

            System.out.println("}");
        }

        System.out.println("}");
    }

    // Displays a formatted two-dimensional integer array for better readability.
    public static void displayArray(int[][] array) {

        System.out.println("Integer Array:");
        System.out.println("{");

        // Use an enhanced for loop to iterate through each row of the two-dimensional array.
        for (int[] row : array) {
            System.out.print("    { ");

            // Use an enhanced for loop to iterate through each element in the current row and print each integer value with a width of 4 characters for alignment.
            for (int value : row) {
                System.out.printf("%4d ", value);
            }

            System.out.println("}");
        }

        System.out.println("}");
    }
}