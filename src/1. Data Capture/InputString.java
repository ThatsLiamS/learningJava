import java.util.*;

public class InputString {

    public static void examples(String[] args) {
        // declare a scanner
        Scanner inputScanner = new Scanner(System.in);

        // assign a keyboard value immediately display it
        System.out.print("Whats your name? ");
        System.out.println("Hi " + inputScanner.nextLine());
        
        // close the scanner
        inputScanner.close();
    }

    public static void main(String[] args) {
        
        /* Conversation.java task */
        Scanner inputScanner = new Scanner(System.in);

        String name;
        System.out.print("What's your name: ");
        name = inputScanner.nextLine();

        System.out.print("\nHello " + name + ", How are you? ");
        String response = inputScanner.nextLine();

        System.out.println("I think I'll call you.... " + name.substring(0,3) + "gsy");
        inputScanner.close();

        /* MixedRainbow.java task */
        Scanner inputScanner2 = new Scanner(System.in);
        System.out.println("Enter the colors of the rainbow:");
        
        String color1 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color2 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();

        String color3 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color4 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();

        String color5 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        String color6 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toUpperCase();
        
        String color7 = inputScanner2.nextLine()
            .trim().replaceAll("e", "a").toLowerCase();

        System.out.println(color1 + " " + color2 + " " + color3 + " " + color4 + " " + color5 + " " + color6 + " " + color7);

        inputScanner2.close();
    }
}