/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 7.2 - Collections of Object Instances
 * Date: July 24, 2026
 *
 * Description:
 * This program tests the Fan and UseFans classes by creating multiple Fan instances,
 * storing them in an ArrayList, and displaying their properties without using the
 * Fan class's toString method. It tests methods that receive a single Fan instance
 * and an ArrayList of Fan instances.
 */

import java.util.ArrayList;

public class FanTest {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("           Collections of Fan Instances");
        System.out.println("This program creates a collection of Fan objects");
        System.out.println("and displays their properties using methods that");
        System.out.println("receive one Fan or an ArrayList of Fan instances.");
        System.out.println("---------------------------------------------------\n");

        // Create an ArrayList that stores Fan instances.
        ArrayList<Fan> fans = new ArrayList<>();

        // Create four Fan objects that demonstrate the available speed settings and constructors.
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.SLOW, true, 8.0, "blue");
        Fan fan3 = new Fan(Fan.MEDIUM, true, 10.0, "yellow");
        Fan fan4 = new Fan(Fan.FAST, true, 12.0, "black");

        // Add each Fan instance to the ArrayList.
        fans.add(fan1);
        fans.add(fan2);
        fans.add(fan3);
        fans.add(fan4);

        // Test the method that receives and displays one Fan instance.
        System.out.println("Displaying a single Fan instance:");
        UseFans.displayFan(fan3);

        // Test the method that receives and displays an ArrayList of Fan instances.
        System.out.println("\nDisplaying all Fan instances in the ArrayList:");
        UseFans.displayFans(fans);

        // Modify fan1 with setter methods to demonstrate that the collection stores the same object instance.
        fan1.setSpeed(Fan.SLOW);
        fan1.setOn(true);
        fan1.setRadius(7.5);
        fan1.setColor("green");

        // Display the collection again to show the updated properties of fan1.
        System.out.println("\nDisplaying all Fan instances after updating Fan 1:");
        UseFans.displayFans(fans);
    }
}