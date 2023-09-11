import java.util.Scanner;
 
public class Arrays {
    
    public static void examples(String[] args) {
        // a blank array declared with a length of 5
        int theMax=5;
        String[] weekDays = new String[theMax];
        int numberOfItems=0; //GLOBAL - Initial declaration
        
        weekDays[numberOfItems] = "Monday"; //Add Item
        numberOfItems++; //Increment count
        weekDays[numberOfItems] = "Tuesday"; //Add Item
        numberOfItems++; //Increment count
        
        // ALTERNATIVE DECLARATION
        String[] studentsInClass; //Start declaration
        studentsInClass = new String[5]; //Finish
        
        // HARDCODED array – values are declared
        // size is fixed and can’t be changed later
        String[] weekendDays = {"Saturday","Sunday"};
        
        // output a position within an array
        System.out.println(weekendDays[0] + studentsInClass[0]); 
        
        // get the length of an array
        // NOTE – No brackets on length
        int maxLength = weekDays.length;
        System.out.println("Array length: " + maxLength);
    };
    
    public static void main(String[] args) {
        
        /* ElfNameArray.java */
        System.out.println("__The Elf Name Calculator__");
        System.out.println("Simply follow the instructions below and generate your custom elf name!\n");
        
        String[] alphabetValues = {"Sparkle", "Jingle", "Happy", "Snowy", "Tinsel", "Jolly", "Bumble", "Cosmo", "Twizzle",
        "JoJo", "Pinky", "Twirly", "Zippy", "Noel", "Swirly", "Dizzy", "Minty", "Cranberry", "Crinkle", "Poppy","Tookie",
        "Merry", "Tinker", "Pepper", "Glitter", "Wiggles"};
        
        String[] months = {"SugarBerry", "McGiggles", "MuffinTin", "PicklePants", "PlumBottom", "SnickerDoodle",
        "Cinnabuns", "SnazzyHead", "MonkeyBerry", "TwinkleToes", "GingerPants", "BrightButtons"};
        
        Scanner inputScanner = new Scanner(System.in);
        
        int letterNum = -1;
        while (letterNum == -1 || letterNum < 0 || letterNum > 25) {
            try {
                System.out.print("Enter the first letter of your name: ");
                char letter = inputScanner.nextLine().toUpperCase().charAt(0);
                letterNum = letter - 65;
            } catch (Exception exc) { };
        };
        
        int monthNum = -1;
        while (monthNum == -1 || monthNum < 0 || monthNum > 11) {
            try {
                System.out.print("Enter the month you were born (as a digit): ");
                monthNum = Integer.parseInt(inputScanner.nextLine().trim()) - 1;
            } catch (Exception exc) { };
        };
        
        System.out.println("\nYour elf name is: " + alphabetValues[letterNum] + " " + months[monthNum]);
 
        inputScanner.close();
    };
}