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

};