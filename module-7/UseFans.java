/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 7.2 - Collections of Object Instances
 * Date: July 24, 2026
 *
 * Description:
 * This class provides methods for displaying the properties of a single Fan instance
 * or an ArrayList of Fan instances without using the Fan class's toString method.
 */

import java.util.ArrayList;

public class UseFans {

    /*
     * Displays the properties of a single Fan instance by using its getter methods.
     * The fan's speed is displayed as a descriptive constant name when the fan is on.
     */
    public static void displayFan(Fan fan) {
        if (fan.isOn()) {
            System.out.println("The " + fan.getColor() + " fan is on. Speed is " + getSpeedName(fan.getSpeed()) + ". Radius is " + fan.getRadius() + ".");
        } else {
            System.out.println("The " + fan.getColor() + " fan is off. Radius is " + fan.getRadius() + ".");
        }
    }

    /*
     * Displays each Fan instance in the ArrayList by passing it to the displayFan method.
     * This keeps the display logic in one method and avoids repeating the same code.
     */
    public static void displayFans(ArrayList<Fan> fans) {
        for (Fan fan : fans) {
            displayFan(fan);
        }
    }

    // Converts the numeric speed constant into a descriptive speed name for display.
    private static String getSpeedName(int speed) {
        return switch (speed) {
            case Fan.SLOW -> "SLOW";
            case Fan.MEDIUM -> "MEDIUM";
            case Fan.FAST -> "FAST";
            default -> "STOPPED";
        };
    }
}