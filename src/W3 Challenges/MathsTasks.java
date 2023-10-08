import java.util.Scanner;

public class MathsTasks {
    
    public static void main(String[] args) {
        MathsTasks myClass = new MathsTasks();

        myClass.fractions(); // Challenge 2
        myClass.reserveANumber(); // Challenge 6
        myClass.displayPrimes(); // Challenge 20
    };

    Scanner inputScanner = new Scanner(System.in);


    /*
     * Challenge 2:
     * Write a Java program to get whole and fractional parts from a double value.
     */
    public void fractions() {
        System.out.println("\n\n\nChallenge 2: Integer & Decimals from a double");
        
        /* Enter a validated double value */
        double number = -1.00;
        while (number < 0.00) {
            try {
                System.out.print("Enter a double valid: ");
                number = Double.parseDouble(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* Get the separate parts */
        double fraction = number % 1;
        double integer = number - fraction;

        /* Display the answer */
        System.out.println("The Integer is: " + integer);
        System.out.println("The Fraction is: " + fraction);
    };

    /*
     * Challenge 6:
     * Write a Java program to reverse an integer number.
     */
    public void reserveANumber() {
        System.out.println("\n\n\nChallenge 6: Reserve the numbers in a given Integer");

        /* Enter a validated Integer */
        int number = -1; 
        while (number < 0) {
            try {
                System.out.print("Enter an Integer: ");
                number = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        String numberStr = Integer.toString(number);
        int[] intArray = new int[numberStr.length()];

        /* Loop through String and swap index points*/
        for (int index = 0; index < numberStr.length(); index++) {
            int integerVal = (int)numberStr.charAt(index) - 48;
            intArray[numberStr.length() - index - 1] = integerVal;
        };

        /* Display the values within the array */
        for (int index = 0; index < intArray.length; index++) {
          System.out.print(intArray[index]);
        };
    };

    /*
     * Challenge 20:
     * In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers
     * up to any given limit. Write a Java program to print all primes smaller than or equal to any given number.
     */
    public boolean isPrime(int num) {
        /* Determines if a number is prime */
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        };

        /* It is True!! */
        return true;
    };
    public void displayPrimes() {
        System.out.println("\n\n\nChallenge 20: Display all Primes");

        /* Enter a validated Integer */
        int maxNum = 0;
        while (maxNum <= 0) {
            try {
                System.out.print("Enter the max number: ");
                maxNum = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        for (int number = 1; number < maxNum; number++) {
            if (isPrime(number) == true) {
                System.out.print(number + " ");
            };
        };
    };
};
