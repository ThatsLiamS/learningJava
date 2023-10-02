import java.util.Scanner;

public class ExceptionTasks {

    Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExceptionTasks myClass = new ExceptionTasks();

        myClass.throwAnError(); // Challenge 1
        myClass.vowelChecker(); // Challenge 7
    };


    /*
     * Challenge 1:
     * Write a Java program that throws an exception and catch it using a
     * try / catch block.
     */
    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide a number by zero!");
        };

        return (numerator / denominator);
    };
    public void throwAnError() {
        System.out.println("\n\n\nChallenge 1: Denominator Zero Error");

        try {
            int solution = divide(5, 0);
            System.out.println("The solution to 5 / 0 is: " + solution);
        } catch (Exception exc) {
            System.out.println("Woah, an error was caught: " + exc.getMessage());
        };
    };

    /*
     * Challenge 7:
     * Write a Java program to create a method that takes a string as input and
     * throws an exception if the string does not contain vowels
     */
    public boolean vowelChecker() {
        System.out.println("\n\n\nChallenge 7: Vowel Checking");

        System.out.print("Enter a string: ");
        String stringValue = inputScanner.nextLine();

        try {
            boolean flag = false;
            String vowels = "AEIOUaeiou";

            for (int index = 0; index < stringValue.length(); index++) {
                if (vowels.contains( String.valueOf( stringValue.charAt(index) ) )) {
                    flag = true;
                };
            };

            if (flag == false) {
                throw new Exception("String does not contain a vowel...");
            };

            System.out.println("The string does contain a vowel.");
            return true;
        } catch (Exception Exc) {
            System.out.println("An error has occurred: " + Exc.getMessage());
            return false;
        }
    };
};