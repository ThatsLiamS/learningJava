import java.util.Scanner;

public class InputString {

    public static void examples(String[] args) {
        // declare a scanner
        Scanner inputScanner = new Scanner(System.in);

        // assign a keyboard value immediately display it
        System.out.print("Whats your name? ");
        System.out.println("Hi " + inputScanner.nextLine());
        
        // close the scanner
        inputScanner.close();
    };

    public static void main(String[] args) {
        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* Conversation.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Scanner inputScanner = new Scanner(System.in);

        /* Gather user inputs */
        System.out.print("What's your name: ");
        String name = inputScanner.nextLine();

        System.out.print("\nHello " + name + ", How are you? ");
        String response = inputScanner.nextLine();
        if (response.isEmpty()) { System.out.println("Wow, no reply?..\n"); };
    
        /* Create a fun nickname for the user */
        System.out.println("I think I'll call you.... " + name.substring(0,3) + "gsy");


        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* MixedRainbow.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        System.out.println("Enter the colors of the rainbow:");
        
        /* Replace the letter E with A in all the colours (and alternate case) */
        String color1 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color2 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();

        String color3 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color4 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();

        String color5 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color6 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();
        
        String color7 = inputScanner.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        /* Display all the new colours*/
        System.out.println(color1 + " " + color2 + " " + color3 + " " + color4 + " " + color5 + " " + color6 + " " + color7);

        /* Close the input stream */
        inputScanner.close();
    };
};