/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 10.2 - Abstract Division Classes
 * Date: August 13, 2026
 *
 * Description:
 * This class represents an international company division. It extends the
 * abstract Division class by adding the country where the division is located
 * and the primary language spoken within that division.
 */

public class InternationalDivision extends Division {

    // Stores information specific to an international division.
    private final String country;
    private final String language;

    /**
     * Constructs an InternationalDivision with all required division information.
     *
     * @param divisionName the name of the company division
     * @param accountNumber the account number assigned to the division
     * @param country the country where the division is located
     * @param language the primary language spoken within the division
     */
    public InternationalDivision(String divisionName, int accountNumber, String country, String language) {

        // Passes the shared division information to the superclass constructor.
        super(divisionName, accountNumber);

        this.country = country;
        this.language = language;
    }

    /**
     * Returns the country where the division is located.
     *
     * @return the division's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the primary language spoken within the division.
     *
     * @return the division's primary language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Displays the international division's information in a clean,
     * consistently formatted section.
     * The formatting uses printf() to align the labels and values in a tabular format.
     * Each label is left-aligned in a 20-character wide column, followed by its corresponding value.
     */
    @Override
    public void display() {
        System.out.println("INTERNATIONAL DIVISION");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s%s%n", "Division Name:", getDivisionName());
        System.out.printf("%-20s%d%n", "Account Number:", getAccountNumber());
        System.out.printf("%-20s%s%n", "Country:", country);
        System.out.printf("%-20s%s%n", "Language:", language);
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }
}