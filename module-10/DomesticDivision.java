/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 10.2 - Abstract Division Classes
 * Date: August 13, 2026
 *
 * Description:
 * This class represents a domestic company division. It extends the abstract
 * Division class by adding the state where the division is located and provides
 * an implementation of the required display() method.
 */

public class DomesticDivision extends Division {

    // Stores the state where the domestic division is located.
    private final String state;

    /**
     * Constructs a DomesticDivision with all required division information.
     *
     * @param divisionName the name of the company division
     * @param accountNumber the account number assigned to the division
     * @param state the state where the division is located
     */
    public DomesticDivision(String divisionName, int accountNumber, String state) {
        
        // Passes the shared division information to the superclass constructor.
        super(divisionName, accountNumber);

        this.state = state;
    }

    /**
     * Returns the state where the division is located.
     *
     * @return the division's state
     */
    public String getState() {
        return state;
    }

    /**
     * Displays the domestic division's information in a clean,
     * consistently formatted section.
     */
    @Override
    public void display() {
        System.out.println("DOMESTIC DIVISION");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s%s%n", "Division Name:", getDivisionName());
        System.out.printf("%-20s%d%n", "Account Number:", getAccountNumber());
        System.out.printf("%-20s%s%n", "State:", state);
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }
}