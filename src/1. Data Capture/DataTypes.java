import java.util.Scanner;

public class DataTypes {

    public static void examples(String[] args) {

        boolean paid = false;    // boolean with value
        int age = 0;             // integer with value
        double cost = 0.0;       // double with value
        String name = "NotSet";  // string with value
        char letter = 'A';       // character with value

        // update a value by hard coding
        paid = true;
        age = 21;
        cost = 5000.00;
        name = "Elvis";
        letter = 'E';
        
        // convert to String
        String tempInput = name; //eg. "256", "true","23.52"

        int convToInt = Integer.parseInt(tempInput);
        boolean convToBool = Boolean.parseBoolean(tempInput);
        double convToDouble = Double.parseDouble(tempInput);
        char initial = tempInput.charAt(0);

        try {
            // ATTEMPTED CONVERSION CODE
            int number = Integer.parseInt("fred");
            boolean answer = Boolean.parseBoolean("true");
            double price = Double.parseDouble("23.52");

            /* ## Remove Unused Error Message */
            System.out.print(number + "" + answer + price);
        }
        catch(Exception exc) {
            System.out.println("error");
            exc.printStackTrace();
        }

        /* ## Remove Unused Error Messages */
        System.out.print(paid + "" + age + cost + name + letter + convToInt + convToBool + convToDouble + initial);
    };

    public static void main(String[] args) {

        /* Album.java task */
        String title; String artist; String tempShopSection;
        String tempNumTracks; String tempInStock; String tempPrice;

        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter Title: "); title = inputScanner.nextLine();
        System.out.print("Enter Artist: "); artist = inputScanner.nextLine();
        System.out.print("Enter Shop Section: "); tempShopSection = inputScanner.nextLine();
        System.out.print("Enter Num of Tracks: "); tempNumTracks = inputScanner.nextLine();
        System.out.print("Enter In Stock: "); tempInStock = inputScanner.nextLine();
        System.out.print("Enter Price: "); tempPrice = inputScanner.nextLine();

        char shopSection = tempShopSection.charAt(0);
        int numTracks = Integer.parseInt(tempNumTracks);
        boolean inStock = Boolean.parseBoolean(tempInStock);
        double price = Double.parseDouble(tempPrice);

        System.out.println(title + " " + artist + " " + shopSection + " " + numTracks + " " + inStock + " " + price);
        
        /* PersonalData.java task */
        System.out.print("\n\nEnter Name: "); 
        String name = inputScanner.nextLine();
        System.out.print("Enter Age: "); 
        String ageTemp = inputScanner.nextLine();

        try {
            int age = Integer.parseInt(ageTemp);

            System.out.println("Your name is: " + name + ", your age is " + age);
        }
        catch (Exception exc) {
            System.out.println("Woah, that age isn't a number...");
            exc.printStackTrace();
        }

        inputScanner.close();
    };
}