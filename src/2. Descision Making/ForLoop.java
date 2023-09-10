import java.util.Scanner; 

public class ForLoop {

    public static void examples(String[] args) {
        // declare variable to stop the loop
        String language ="Java";
        int max = language.length();

        // i is the count
        // i<max is the condition
        // i++ after each loop
        for(int i=0; i<max; i++) // i--would decrement
        {
            // code to repeat
            
            if (i == 5) {
                //Used to terminate a loop immediately
                break; 
            };
        };
    };


    public static void main(String[] args) {

        /* NameChecker.java task */
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = inputScanner.nextLine().trim();

        for (int x = 0; x < name.length(); x++) {
            if(Character.isLetter(name.charAt(x)) == true) {
                System.out.println(name.charAt(x));
            }
        };
        inputScanner.close();

        /* TenGreenBottles.java task */
        for(int x = 99; x > 0; x--) {

            if (x != 1) {
                System.out.println(x + " bottles of beer on the wall, " + x + " bottles of beer.");
                System.out.println("Take one down and pass it around, " + (x-1) + " bottles of beer on the wall.\n");
            }
            else {
                System.out.println("1 bottle of beer on the wall, 1 bottle of beer.");
                System.out.println("Take one down and pass it around, no more bottles of beer on the wall.\n");

                System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
                System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
            };

            try { Thread.sleep(1000); } catch (Exception exc) {
                System.out.println("\n\nSleep Errors\n\n");
            };

        }
    };
}