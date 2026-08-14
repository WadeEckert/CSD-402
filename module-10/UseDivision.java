/*
 * Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 10.2 - Abstract Division Classes
 * Date: August 13, 2026
 *
 * Description:
 * This program creates two InternationalDivision objects and two
 * DomesticDivision objects. It stores the objects in a Division array and
 * uses polymorphism to call the appropriate display() method for each object.
 */

public class UseDivision {

    public static void main(String[] args) {

        // Creates two objects of each concrete Division subclass.
        Division[] divisions = {
            new InternationalDivision("European Operations", 1001, "Germany", "German"),
            new InternationalDivision("Asia-Pacific Operations", 1002, "Japan", "Japanese"),
            new DomesticDivision("Western Operations", 2001, "Colorado"),
            new DomesticDivision("Eastern Operations", 2002, "New York")
        };

        // Displays a professional heading before listing the division records.
        System.out.println("============================================================");
        System.out.println("                 COMPANY DIVISION DIRECTORY");
        System.out.println("============================================================");
        System.out.println();

        /*
         * Polymorphism allows each Division reference to call the display()
         * implementation belonging to its actual subclass.
         */
        for (Division division : divisions) {
            division.display();
        }

        System.out.println("End of division directory.");
    }
}