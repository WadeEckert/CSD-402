/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 6.2 - Object Oriented Programming Exercise
 * Date: July 15, 2026
 *
 * Description:
 * This program defines a FanTest class that demonstrates the use of the Fan class 
 * by creating two Fan objects with different properties and displaying their details.
 * It uses the toString method of the Fan class to print the properties of each fan object and
 * also demonstrates the use of setter methods to modify the properties of one of the fan objects.
 */

public class FanTest {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("        Object Oriented Programming Exercise");
        System.out.println("This program demonstrates the use of classes and");
        System.out.println("objects in Java by creating two Fan objects with");
        System.out.println("different properties and displaying their details.");
        System.out.println("---------------------------------------------------\n");

        // Create two Fan objects with different properties. One using the parameterized constructor
        // and the other using the default constructor and setter methods.
        Fan fan1 = new Fan(Fan.FAST, true, 10.4, "yellow");
        Fan fan2 = new Fan();
        
        // Call the toString method to display the details of fan1 and fan2.
        System.out.println("Fan 1:");
        System.out.println(fan1);

        System.out.println("Fan 2 using default values:");
        System.out.println(fan2);

        // Set properties for fan2 using setter methods.
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setOn(true);
        fan2.setRadius(5.3);
        fan2.setColor("blue");

        // Call the toString method again to display the updated details of fan2.
        System.out.println("Fan 2 after using setter methods:");
        System.out.println(fan2);

        System.out.println("Testing invalid speed validation:");
        fan2.setSpeed(5);

        System.out.println("Fan 2 remains unchanged:");
        System.out.println(fan2);
    }
}

