/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 10.2 - Abstract Division Classes
 * Date: August 13, 2026
 *
 * Description:
 * This abstract class represents a general company division. It stores the
 * division name and account number shared by all division types and requires
 * each subclass to provide its own implementation of the display() method.
 */

public abstract class Division {

    // Stores the information shared by every company division.
    private final String divisionName;
    private final int accountNumber;

    /**
     * Constructs a Division with its required identifying information.
     *
     * @param divisionName the name of the company division
     * @param accountNumber the account number assigned to the division
     */
    public Division(String divisionName, int accountNumber) {
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the name of the division.
     *
     * @return the division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Returns the account number assigned to the division.
     *
     * @return the division account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Displays the information for a specific type of division.
     * Each concrete subclass must provide its own implementation.
     */
    public abstract void display();
}