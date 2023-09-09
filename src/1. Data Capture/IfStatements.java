import java.util.*;

public class IfStatements {

    public static void examples(String[] args) {
        String name = "Pete";

        if (name.equalsIgnoreCase("pete") == true) {
            // string matches
        }
        else if (name.contains("ete") || name.contains("Pet")) {
            // join conditions using || for OR
            // join conditions using && for AND
            // close to Pete - we will accept
        }
        else { 
            // optional - do you need an else?
            // name doesn't have pete in it
        }
    };

    public static void main(String[] args) {

        /* Password.java task */
        String username = "ThatsLiamS";
        String password = "Liam090923";

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String userEntry = inputScanner.nextLine();

        System.out.print("Enter password: ");
        String passEntry = inputScanner.nextLine();

        if (username.equalsIgnoreCase(userEntry) == false) {
            System.out.println("\nUsername is incorrect.");
        }
        else if (password.equals(passEntry) == false) {
            System.out.println("\nPassword is incorrect.");
        }
        else {
            System.out.println("\nSuccessfully logged in.");
        }


        /* ChooseMonth.java */
        System.out.print("\n\nPlease enter the month number: ");

        int month = Integer.parseInt(inputScanner.nextLine().trim().replace("\n", ""));

        String monthName; String seasonName; int days;

        if (month == 1) { monthName = "January"; seasonName = "Winter"; days = 31; }
        else if (month == 2) { monthName = "February"; seasonName = "Winter"; days = 28; }
        else if (month == 3) { monthName = "March"; seasonName = "Spring"; days = 31; }
        else if (month == 4) { monthName = "April"; seasonName = "Spring"; days = 30; }
        else if (month == 5) { monthName = "May"; seasonName = "Spring"; days = 31; }
        else if (month == 6) { monthName = "June"; seasonName = "Summer"; days = 30; }
        else if (month == 7) { monthName = "July"; seasonName = "Summer"; days = 31; }
        else if (month == 8) { monthName = "August"; seasonName = "Summer"; days = 31; }
        else if (month == 9) { monthName = "September"; seasonName = "Autumn"; days = 30; }
        else if (month == 10) { monthName = "October"; seasonName = "Autumn"; days = 31; }
        else if (month == 11) { monthName = "November"; seasonName = "Autumn"; days = 30; }
        else { monthName = "December"; seasonName = "Winter"; days = 31; }

        System.out.println("That month is " + monthName + " and has " + days + " days." + "\nThe season is: " + seasonName);

        if (monthName.toLowerCase().contains("e")) {
            System.out.println("** Fun Fact, " + monthName + ", contains the letter 'E' **");
        }

        System.out.print("\nLeap Year Checker: ");
        int yearEntry = Integer.parseInt(inputScanner.nextLine());
        System.out.print((yearEntry % 4 == 0 && yearEntry % 100 != 0) || yearEntry % 400 == 0);

        inputScanner.close();
    };
}