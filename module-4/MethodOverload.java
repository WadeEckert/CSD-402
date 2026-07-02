/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 4.2 - Method Overload
 * Date: July 01, 2026
 *
 * Description:
 * This program demonstrates method overloading by calculating the average
 * of four different array types: short, int, long, and double. Each overloaded
 * method accepts a different array type and returns the average value using
 * the same data type. The main method tests each overloaded method using
 * arrays of different sizes and displays both the array contents and the
 * calculated average.
 */

public class MethodOverload {
    
    public static void main(String[] args) {

        System.out.println("Method Overload Average Calculator");
        System.out.println("------------------------------------------------------");
        System.out.println("Note: The short, int, and long average methods return");
        System.out.println("their respective data types, so any fractional portion");
        System.out.println("of the average will be truncated. The double method");
        System.out.println("returns the full decimal average.\n");

        // Arrays of different sizes to test the overloaded average methods with various data types and sizes
        short[] shortArray = {10, 20, 30};
        int[] intArray = {50000, 100000, 150000, 200000};
        long[] longArray = {3000000000L, 4000000000L, 5000000000L, 6000000000L, 7000000000L};
        double[] doubleArray = {2.5, 3.5, 4.5, 5.5, 6.5, 7.5};
        
        // Methods to display the contents of each array and the calculated average using the overloaded methods
        displayArray(shortArray);
        System.out.println("Average: " + average(shortArray));
        System.out.println();

        displayArray(intArray);
        System.out.println("Average: " + average(intArray));
        System.out.println();

        displayArray(longArray);
        System.out.println("Average: " + average(longArray));
        System.out.println();

        displayArray(doubleArray);
        System.out.println("Average: " + average(doubleArray));
    }

    // Calculates the average of a short array.
    // Uses an enhanced for loop to iterate through the array and sum the values, then divides by the array length to get the average.
    public static short average(short[] array) {

        // Use an int accumulator to avoid overflow while summing short values.
        int sum = 0;

        for (short value : array) {
            sum += value;
        }

        return (short) (sum / array.length);
    }

    // Calculates the average of an int array.
    // Uses an enhanced for loop to iterate through the array and sum the values, then divides by the array length to get the average.
    public static int average(int[] array) {

        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    // Calculates the average of a long array.
    // Uses an enhanced for loop to iterate through the array and sum the values, then divides by the array length to get the average.
    public static long average(long[] array) {

        // Use a long accumulator to avoid overflow while summing long values.
        long sum = 0; //

        for (long value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    // Calculates the average of a double array.
    // Uses an enhanced for loop to iterate through the array and sum the values, then divides by the array length to get the average. 
    public static double average(double[] array) {
        
        double sum = 0;

        for (double value : array) {
            sum += value;
        }

        return sum / array.length;
    }

     // Displays the contents of a short array.
     // Uses a for loop to iterate through the array and print each element, separated by commas.
    public static void displayArray(short[] array) {

        System.out.print("Short Array: {");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }

    // Displays the contents of a integer array.
    // Uses a for loop to iterate through the array and print each element, separated by commas.
    public static void displayArray(int[] array) {

        System.out.print("Int Array: {");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }

    // Displays the contents of a long array.
    // Uses a for loop to iterate through the array and print each element, separated by commas.
    public static void displayArray(long[] array) {

        System.out.print("Long Array: {");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }

    // Displays the contents of a double array.
    // Uses a for loop to iterate through the array and print each element, separated by commas.
    public static void displayArray(double[] array) {

        System.out.print("Double Array: {");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }
}