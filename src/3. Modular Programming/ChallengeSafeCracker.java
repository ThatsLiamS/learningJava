import java.util.Scanner;
import java.util.Random;

public class ChallengeSafeCracker {
    
    /* Global Variables */
    Scanner inputScanner = new Scanner(System.in);
    
    int[] safeCode = new int[3];
    int maxGuesses = -2;
    boolean hints = false;
    
    /* Call the main methods */
    public static void main(String[] args) {
        /* Run a procedure */
        ChallengeSafeCracker myClass = new ChallengeSafeCracker();
        myClass.generateCode();
        
        /* Repeat the menu() until otherwise stated */
        while (true) {
            if (myClass.menu() == true) { break; };
        };
    };


    public boolean menu() {
        
        /* Enter and validate option int input */
        int option = -1;
        while (option < 1 || option > 5) {
            /* Display menu options */
            System.out.println("\n1. Randomly generate a 3-digit safe code\n2. Set max number of guesses");
            System.out.println("3. Turn hints on/off \n4. Guess the code \n5. Exit\n\n");
            /* Has the user entered a valid int? */
            try {
                System.out.print("Enter menu option: ");
                option = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
        };

        /* Run the selected method */
        if (option == 1) { generateCode(); }
        else if (option == 2) { setGuesses(); }
        else if (option == 3) { setHints(); }
        else if (option == 4) {
    
            boolean failed = true;
            if (maxGuesses < 0) {
                /* User is allowed unlimited guesses */
                while (guessCode() == false) { };
            } else {
                /* Allow guesses up to the max */
                for (int x = 0; x < maxGuesses; x++) {
                    if (guessCode() == true) { failed = false; break; };
                }
            };
            
            System.out.println("\n\n" + (failed == true ?
                "You didn't manage to guess the code in time..." :
                "Congrats, you cracked the safe!!"
                ) + "\n\n");
        }

        /* User has requested the stop */
        else if (option == 5) {
            inputScanner.close();
            return true;
        };

        /* Add a small delay between methods and the next menu */
        try { Thread.sleep(1000); } catch (Exception exc) { };
        return false;
    };


    public void generateCode() {
        /* Generate 'random' int[3] */
        safeCode = new Random().ints(0, 10).limit(3).toArray();
        System.out.println("Code has been generated!");
    };
    public void setGuesses() {
        
        /* UserInput: int number of guesses */
        while (maxGuesses < -1) {
            System.out.print("Enter max number of guesses (-1 for unlimited): ");
            /* Is the input an Integer */
            try {
                maxGuesses = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
            /* Inform the user of the changes */
            System.out.println("Max Guess set to: " + maxGuesses);
        };
    };
    public void setHints() {
        
        /* UserInput: boolean string y/n */
        String response = "";
        while (response.isEmpty() == true || (response.equals("y") == false && response.equals("n") == false)) {
            System.out.print("Do you wish to have hints (y/n): ");
            response = inputScanner.nextLine().trim();
        };
        
        /* Inform the user of the changes */
        hints = (response.equalsIgnoreCase("y")) ? true : false;
        System.out.println("Hints sets to: " + hints);
    };


    public boolean guessCode() {
        /* input a 3 digit number */
        int tempNum = -1;
        while (tempNum < 0 || tempNum > 999) {
            try {
                System.out.print("Enter a 3 digit number: ");
                tempNum = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };
        
        /* Ensure there are 3 digits - auto-filled suffix 0's */
        String numStr = Integer.toString(tempNum);
        while (numStr.length() < 3) { numStr = numStr + "0"; };
        
        String[] guessed = numStr.split("");
        
        /* How many did they guess right */
        int numCorrect = 0;
        for (int index = 0; index < 3; index++) {
            
            if (Integer.parseInt(guessed[index]) == safeCode[index]) {
                numCorrect += 1;
            };
        };
        
        /* are hints enabled? */
        if (hints == true) {
            /* Informs the user how many they got right */
            System.out.println("You guessed " + numCorrect + " correctly\n");
        };

        /* Ternary, did they get all three */
        return (numCorrect == 3) ? true : false;
    };
};