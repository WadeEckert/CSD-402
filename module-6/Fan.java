/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 6.2 - Object Oriented Programming Exercise
 * Date: July 15, 2026
 *
 * Description:
 * This program defines a Fan class with constants, private fields, constructors,
 * getters, setters, and a toString method.
 */

/*
 * Class definition for Fan, which includes constants for speed settings, private fields for fan properties,
 * constructors for creating Fan objects, getter and setter methods for accessing and modifying the properties.
 * This class represents a fan with different properties such as speed, on/off state, radius, and color.
 */
public class Fan {
    // Constants to represent the different speed settings of the fan, including STOPPED, SLOW, MEDIUM, and FAST.
    // These constants are 0, 1, 2, and 3 respectively, and are used to set the speed of the fan object.
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Instance variables to hold the state of the fan object, including speed, on/off state, radius, and color.
    private int speed = STOPPED;
    private boolean on = false;
    private double radius = 6.0;
    private String color = "white";

    // Default no argument constructor to initialize the fan object with default values.
    public Fan() {
    }

    // Constructor with parameters to initialize the fan object with specified values for speed, on/off state, radius, and color.
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Fan(int speed, boolean on, double radius, String color) {
        setSpeed(speed);
        setOn(on);
        setRadius(radius);
        setColor(color);
    }

    
    /*
     * Getter and setter methods for the instance variables of the Fan class. 
     * These methods allow access to the private instance variables from outside the class, 
     * while also providing a way to modify their values.
     */
    public int getSpeed() {
        return speed;
    }

    // The setSpeed method checks if the provided speed value is within the valid range (STOPPED (0) to FAST (3)).
    // If the value is invalid, it displays an error message and does not change the speed value.
    public void setSpeed(int speed) {
        if (speed < STOPPED || speed > FAST) {
            System.out.println("Invalid speed value. Please set the speed to STOPPED (0), SLOW (1), MEDIUM (2), or FAST (3).\n");
        } else {
            this.speed = speed;

            if (speed == STOPPED) {
                this.on = false;
            }
        }
    }

    public boolean isOn() {
        return on;
    }

    // The setOn method checks if the fan is currently stopped (speed is STOPPED or 0).
    // If the fan is stopped, it prevents turning the fan on and displays a message to the user.
    public void setOn(boolean on) {
        if (on && speed == STOPPED) {
            this.on = false;
            System.out.println("Fan is off. Cannot set to \"on\" when speed is STOPPED.");
            System.out.println("Please set the speed to SLOW (1), MEDIUM (2), or FAST (3) before turning the fan on.\n");
        } else {
            this.on = on;
        }
    }

    public double getRadius() {
        return radius;
    }

    // The setRadius method checks if the provided radius value is less than or equal to 0.
    // If it is, the method displays an error message and does not change the radius value.
    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("Invalid radius value. Please set the radius to a positive number greater than 0.\n");
        } else {
            this.radius = radius;
        }
    }

    public String getColor() {
        return color;
    }

    // The setColor method checks if the provided color value is null or blank.
    // If it is, the method displays an error message and does not change the color value.
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            System.out.println("Invalid color. Please enter a nonempty color.\n");
        } else {
            this.color = color;
        }
    }   

    
    /*
     * toString method to provide a string representation of the Fan object.
     * This method returns a string that describes the state of the fan, including its speed,
     * on/off state, radius, and color. It checks the speed and on/off state to determine the 
     * appropriate message to return. @Override annotation indicates that this method overrides 
     * the default toString method from the Object class.
     */
    @Override
    public String toString() {
        if (on && speed == SLOW) {
            return "The " + color + " fan is on. Speed is SLOW. Radius is " + radius + ".\n";
        } else if (on && speed == MEDIUM) {
            return "The " + color + " fan is on. Speed is MEDIUM. Radius is " + radius + ".\n";
        } else if (on && speed == FAST) {
            return "The " + color + " fan is on. Speed is FAST. Radius is " + radius + ".\n";
        } else {
            return "The " + color + " fan is off. Radius is " + radius + ".\n";
        }
    }
} 
    

