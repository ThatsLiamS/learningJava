import java.util.Scanner;
import java.util.Random;

public class IfStatement {

    public static void examples(String[] args) {

        int age = 18;
        boolean birthday = false;

        if (age > 18) {
            //action
        } else if (age < 18) {
            //action
        } else if (age == 18 && birthday == true) {
            //action
        }
    };

    public static void main(String[] args) {

       
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
       /* ExamGrade.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Scanner inputScanner = new Scanner(System.in);

       /* Input User Scores */
        int scoreOne = -1;
        while (scoreOne == -1 || scoreOne < 0 || scoreOne > 100) {
            try {
                System.out.print("Enter test 1's score: ");
                scoreOne = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
        };

        int scoreTwo = -1;
        while (scoreTwo == -1 || scoreTwo < 0 || scoreTwo > 100) {
            try {
                System.out.print("Enter test 2's score: ");
                scoreTwo = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
        };

        int scoreThree = -1;
        while (scoreThree == -1 || scoreThree < 0 || scoreThree > 100) {
            try {
                System.out.print("Enter test 3's score: ");
                scoreThree = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
        };

        /* Identify best score */
        int highest = (scoreOne > scoreTwo && scoreOne > scoreThree) ? scoreOne : (scoreTwo > scoreThree ? scoreTwo : scoreThree);
        
        if (highest > 84) {
            System.out.println("\nYou earned a Distinction, being " + highest % 85 + " marks over.");
        } else if (highest > 59) {
            System.out.println("\nYou earned a Merit, being " + highest % 60 + " marks over.");
        } else if (highest > 49) {
            System.out.println("\nYou earned a Pass, being " + highest % 50 + " marks over.");
        } else {
            System.out.println("\nYou failed...");
        };

        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* RockPaperScissors.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        while (true) {
            String[] outcomes = {"Rock", "Paper", "Scissors"};

            int selection = -1;
            while (selection == -1 || selection < 0 || selection > 2) {
                try {
                    System.out.print("\n\n\n\n\n\n__Rock, Paper, Scissors__\n\n1. Rock\n2. Paper\n3. Scissors\n\nEnter option: ");
                    selection = Integer.parseInt(inputScanner.nextLine().trim()) - 1;
                } catch (Exception exc) { };
            };

            /* Change to String Values */
            Random rand = new Random();

            String user = outcomes[selection];
            String computer = outcomes[rand.nextInt(3)];

            /* Select the Winner */
            String result = "";

            if (user.equals(computer)) result = "Draw!";
            else if (user.equals("Rock")) result = computer.equals("Paper") ? "You Lost!" : "You Won!";
            else if (user.equals("Paper")) result = computer.equals("Scissors") ? "You Lost!" : "You Won!";
            else if (user.equals("Scissors")) result = computer.equals("Rock") ? "You Lost!" : "You Won!";

            System.out.print(result + " The computer picked " + computer + "\nDo you want to quit (type exit): ");
            String exitCode = inputScanner.nextLine().trim().toLowerCase();

            if (exitCode.equals("exit")) break;
        };

        /* Close the input stream */
        inputScanner.close();
    };
};