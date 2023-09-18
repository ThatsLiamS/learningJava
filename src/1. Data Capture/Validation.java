import java.util.Scanner;
import java.util.Random;

public class Validation {

    /*
     * Validation is an essential tool for checking that the user input is sensible and 
     * will not damage the system. An age stored as ‘Fred’ would cause errors when
     * calculated. In a system which splits strings by comma, would have problems if an
     * extra comma were used in the input. Detecting and correcting such data is known
     * as Input Sanitization. 
     * 
     * 
     * A programmer could choose from 2 approaches:
     *
     * 1. Loop: Flag up unacceptable data on entry and ask for another entry
     * 2. Selection: Keep track and inform the user of required changes at the end.
     */

    public static void main(String[] args) {

        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* Enrolment.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Scanner inputScanner = new Scanner(System.in);
        
        /* Gather and validate user input */
        String name = "";
        while (name.length() < 2) {
            System.out.print("Enter name (min 2 chars): ");
            name = inputScanner.nextLine().trim();
        };

        int year = -1;
        while (year == -1) {
            try {
                System.out.print("Please enter your birth year: ");
                year = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { System.out.println("That isn't a valid year!"); };
        };

        int mathsGrade = 0;
        while (mathsGrade < 1 || mathsGrade > 9) {
            System.out.print("Enter name your GCSE Maths Grade: ");
            mathsGrade = inputScanner.nextInt();
        };

        /* Display the validated data */
        System.out.println("\nYour name is " + name + "\nYour birth year is " + year + "\nYour GCSE Maths grade was a " + mathsGrade);


        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* Enrolment.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        String email = "";
        while (email.matches(".+@.+\\..+") == false) {
            System.out.print("Enter a valid email: ");
            email = inputScanner.nextLine();
        };

        String yearGroup = "";
        while (yearGroup.equalsIgnoreCase("L6") == false && yearGroup.equalsIgnoreCase("U6") == false) {
            System.out.print("Enter your year group: ");
            yearGroup = inputScanner.nextLine();
        };

        /* Generate 'E'  && 4 random numbers */
        Random r = new Random();
        String studentID = "E" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);

        /* Output the user's information */
        System.out.println("Email: " + email);
        System.out.println("Your id for " + yearGroup.toUpperCase() + " is " + studentID);

        /* Close input stream */
        inputScanner.close();
    };
};