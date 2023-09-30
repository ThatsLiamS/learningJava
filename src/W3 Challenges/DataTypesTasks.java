import java.util.Scanner;

public class DataTypesTasks {

    /* Creates input stream */
    Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataTypesTasks myClass = new DataTypesTasks();

        myClass.digitAddition(); // Challenge 3
        myClass.timeConverter(); // Challenge 4
        myClass.speedCalc(); // Challenge 7
        myClass.enumDays(); // Challenge 16
    };

    /*
     * Challenge 3:
     * Write a Java program that reads an integer and adds all the digits in the integer.
     */
    public void digitAddition() {
        System.out.println("\n\n\nChallenge 3: Integer Digit Addition");

        /* Enter a validated Integer */
        int number = -1;
        while (number < 0 || number >= 1000) {
            try {
                System.out.print("Enter a 3 digit number: ");
                number = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* Add digits together */
        int sum = 0;
        for (int index = 0; index < 3; index++) {
            /* Add the least significant number first */
            sum = sum + (number % 10);
            /* Remove the least significant number */
            number = number / 10;
        };

        System.out.println("The sum of the digits is: " + sum);
    };

    /*
     * Challenge 4:
     * Write a Java program to convert minutes into years and days.
     */
    public void timeConverter() {
        System.out.println("\n\n\nChallenge 4: Time Converter");

        /* Enter a validated number */
        int minutes = 0;
        while (minutes <= 0) {
            try {
                System.out.print("Enter the minutes: ");
                minutes = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* Calculate TOTAL days */
        int days = minutes / (60 * 24);

        /* Calculate years and the MOD are remaining days */
        int years = days / 365;
        days = days % 365;

        System.out.println("That has been calculated as: " + years + " years, and " + days + " days");
    };

    /*
     * Challenge 7:
     * Write a Java program to take the user for a distance (in meters) and
     * the time taken (as three numbers: hours, minutes, seconds), and display
     * the speed, in meters per second, kilometers per hour and miles per hour.
     */
    public void speedCalc() {
        System.out.println("\n\n\nChallenge 7: Speed Calculator");

        /* Enter a validated distance */
        int distance = 0;
        while (distance < 1) {
            try {
                System.out.print("Enter the distance (m): ");
                distance = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* Enter a validated time */
        float hours = -1;
        while (hours < 0) {
            try {
                System.out.print("Enter the hours (h): ");
                hours = Float.parseFloat(inputScanner.nextLine());
            } catch (Exception exc) { };
        };
        float minutes = -1;
        while (minutes < 0) {
            try {
                System.out.print("Enter the minutes (m): ");
                minutes = Float.parseFloat(inputScanner.nextLine());
            } catch (Exception exc) { };
        };
        float seconds = -1;
        while (seconds < 0) {
            try {
                System.out.print("Enter the seconds (s): ");
                seconds = Float.parseFloat(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* Total Time Values */
        float totalSeconds = seconds + (minutes * 60.0f) + (hours * 60.0f * 60.0f);
        float totalHours = totalSeconds / 3600.0f;

        /* Total Distance Values */
        float metres = distance;
        float kiloMetres = metres / 1000.0f;
        float miles = metres / 1609.34f;

        /* Display the output */
        System.out.println("Speed: " + (metres / totalSeconds) + " m/s");
        System.out.println("Speed: " + (kiloMetres / totalHours) + " km/h");
        System.out.println("Speed: " + (miles / totalHours) + " miles/h");
    };

    /*
     * Challenge 16:
     * Write a Java program to create an enum called "DaysOfWeek"
     * representing the days of the week.
     */
    public enum DaysOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY, SUNDAY,
    }
    public void enumDays() {
        System.out.println("\n\n\nChallenge 16: ENUM Days of the Week");

        /* *correct as of when I made this* */
        DaysOfWeek today = DaysOfWeek.SATURDAY;
        System.out.println("Today is " + today);
    };
};