import java.util.Scanner;

public class WhileLoop {

    public static void examples(String[] args) {

        // declare variable to use in the loop
        int count = 0;
    
        // a boolean value or ‘flag’ can control a loop
        boolean stopFlag = false;

        // 1 or more conditions to make the loop continue
        while(count < 100 && stopFlag == false) {
            count++;

            // Used to terminate a loop immediately
            break;
        }

    };

    public static void main(String[] args) {

        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* FizzBuzz.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Scanner inputScanner = new Scanner(System.in);

        /* Gather user input */
        System.out.print("Enter the max number: ");
        int max = inputScanner.nextInt();

        System.out.print("Enter the FIZZ number: ");
        int fizz = inputScanner.nextInt();

        System.out.print("Enter the BUZZ number: ");
        int buzz = inputScanner.nextInt();
        
        /* Close the input stream */
        inputScanner.close();

        int fizzNum = 0; int buzzNum = 0; int fizzBuzzNum = 0;

        /* Loop until the max number is reached */
        for (int x = 1; x <= max; x++) {
            String result = "";
        
            if (x % fizz == 0) { result += ("Fizz"); };
            if (x % buzz == 0) { result += ("Buzz"); };
        
            /* FizzBuzz or display the number */
            if (result.isEmpty() == true) { result = "" + x; };
            System.out.println(result);

            /* Update the counts */
            fizzNum += (result.equals("Fizz") ? 1 : 0);
            buzzNum += (result.equals("Buzz") ? 1 : 0);
            fizzBuzzNum += (result.equals("FizzBuzz") ? 1 : 0);
        }

        /* Display the counts */
        System.out.println("\nFizz: " + fizzNum);
        System.out.println("Buzz: " + buzzNum);
        System.out.println("FizzBuzz: " + fizzBuzzNum);
    };
};