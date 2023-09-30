import java.io.File;
import java.util.Scanner;

public class BasicTasks {

    /* Create input stream */
    Scanner inputScanner = new Scanner(System.in);

    public static void main (String[] args) {
        BasicTasks myClass = new BasicTasks();

        myClass.fileSize(); // Challenge 45
        myClass.arrayMultiplication(); // Challenge 83
        myClass.stringRepetition(); // Challenge 84
        myClass.threeNPlusOne(); // Challenge 86
        myClass.arrayLenCounter(); // Challenge 132
        myClass.primeMultiplication(); // Challenge 232
        myClass.hammeringWeight(); // Challenge 249
    };


    /*
     * Challenge 45:
     * Write a Java program to find the size of a specified file
     */
    public void fileSize() {
        System.out.println("\n\n\nChallenge 43: File Sizes");

        File directory = new File("src/W3 Challenges/");
        File[] file = directory.listFiles();

        for (int x = 0; x < file.length; x++) {
            System.out.println(file[x] + ": " + new File("src/W3 Challenges/" + file[x]).length() + " bytes");
        };
    };

    /*
     * Challenge 83:
     * Write a Java program to multiply the corresponding elements of two integer arrays.
     */
    public void arrayMultiplication() {
        System.out.println("\n\n\nChallenge 83: Array Multiplication");

        int[] listOne = {1, 3, -5, 4};
        int[] listTwo = {1, 4, -5, -2};

        for (int index = 0; index < listOne.length; index++) {
            System.out.print(listOne[index] * listTwo[index] + " ");
        };
    };

    /*
     * Challenge 84:
     * Write a Java program to take the last three characters from a given string. It will add the three
     * characters at both the front and back of the string. String length must be greater than three and more.
     */
    public void stringRepetition() {
        System.out.println("\n\n\nChallenge 84: String Repetition");

        String phrase = "";
        while (phrase.isEmpty() || phrase.length() < 3) {
            System.out.print("Enter a string: ");
            phrase = inputScanner.nextLine();
        };

        String subString = phrase.substring(phrase.length() -3);
        System.out.println(subString + phrase + subString);
    };
   
    /*
     * Challenge 86:
     * Write a Java program starting with an integer n, divide it by 2 if is
     * even, or multiply it by 3 and add 1 if it is odd. Repeat the process until n = 1.
     */
    public void threeNPlusOne() {
        System.out.println("\n\n\nChallenge 86: 3n+1 Maths");

        int number = -1;
        while (number < 0) {
            try {
                System.out.print("Enter the starting number: ");
                number = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        /* while number is not 1 DO */
        while (number != 1) {
            System.out.println(number);

            /* if the number is even, divide by two */
            if (number % 2 == 0) {
                number = number / 2;
            }
            /* else do "3n + 1" */
            else {
                number = (number * 3) + 1;
            };
        };

        /* Proof for that starting number confirmed */
        System.out.println("The program has resulted in: " + number);

    };

    /*
     * Challenge 132:
     * Write a Java program to find the updated length of a sorted
     * array where each element appears only once (remove duplicates).
     */
    public void arrayLenCounter() {
        System.out.println("\n\n\nChallenge 132: Remove Array Duplicates");

        int[] originalData = {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7};

        int count = 0;
        int lastValue = -1;

        for (int index = 0; index < originalData.length; index++) {
           
            if (originalData[index] != lastValue) {
                count++;
                lastValue = originalData[index];
            };
        };

        System.out.println("The original length was: " + originalData.length);
        System.out.println("The new length is: " + count);
    };

    /*
     * Challenge 232:
     * Write a Java program to compute the sum of the first n prime numbers
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
    public void primeMultiplication() {
        System.out.println("\n\n\nChallenge 232: Prime Multiplication");

        /* Input a validated integer */
        int num = -1;
        while (num == -1 || num > 10_000) {
            try {
                System.out.print("Enter a number (<= 10_000): ");
                num = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) { };
        };

        int count = 0;
        int sum = 0;
        for (int x = 1; count < num; x++) {
            /* Loops through all the numbers between 1 and inputted */
            if (isPrime(x) == true) { sum += x; count++; };
        };

        System.out.println("The sum is: " + sum);
    };

    /* 
     * Challenge 249:
     * The Hamming weight of a string is the number of symbols that are different from the
     * zero-symbol of the alphabet used. It is thus equivalent to the Hamming distance from
     * the all-zero string of the same length. For the most typical case, a string of bits,
     * this is the number of 1's in the string, or the digit sum of the binary representation
     * of a given number and the ℓ₁ norm of a bit vector.
     */
    public void hammeringWeight() {
        System.out.println("\n\n\nChallenge 249: Hammering Weight");
        int popCount = 0;

        /* Input an Integer Value */
        int intInput = -1;
        while (intInput < 0) {
            try {
                System.out.print("Enter an Integer: ");
                intInput = Integer.parseInt(inputScanner.nextLine());
            } catch (Exception exc) {};
        };

        /* Convert to a Binary String */
        String binary = Integer.toBinaryString(intInput);
        for (int index = 0; index < binary.length(); index++) {
            if (binary.charAt(index) == '1') {
                popCount = popCount + 1;
            };
        };

        System.out.println("The hammering weight is: " + popCount);
    };
};