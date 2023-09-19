import java.io.FileWriter;
import java.util.Scanner;
 
public class FileWriting {
    
    public static void examples(String[] args) {
        
        // declared wherever file writing occurs
        try {
            FileWriter fw = new FileWriter("FileWritten.txt");
            
            fw.write("This will be on line one"); // write
            fw.write("\r\n"); //new Line
            fw.write("This will be"+" on line two"); // write
            fw.close(); // ONCE, when all WRITING IS FINISHED
    
        } catch (Exception exc) { };
   
    };


    /* Declare global variables */
    Scanner inputScanner = new Scanner(System.in);
 
    String[] words = new String[10];
    int itemsAdded = 0;
    String fileName = "";
 
    public static void main(String[] args) {
        
        FileWriting myClass = new FileWriting();
 
        /* BasicWriter.java task */
        myClass.getFileName();     // determine file name
        myClass.getLines();     // input string data
        myClass.writeToFile();   // write data to file
    };
    
    public void getFileName() {
        /* UserEntry: Validation */
        while (fileName.isEmpty() || fileName.length() < 3) {
            System.out.print("Enter filename: ");
            fileName = inputScanner.nextLine().trim();
        };
    };
    
    public void getLines() {
        boolean flag = false;
        
        /* While array isn't full */
        while (itemsAdded < words.length && flag == false) {
            String line = "";

            /* Validate user entry */
            while (line.isEmpty()) {
                System.out.print("Enter line " + (itemsAdded + 1) + ": ");
                line = inputScanner.nextLine().trim();
                
                if (line.equalsIgnoreCase("stop")) flag = true;
            };

            /* Did the user ask to stop */
            if (flag == false) {
                words[itemsAdded] = line;
                itemsAdded += 1;
            };
        };
    }; 
    
    public void writeToFile() {
        try {
            /* Open the file */
            FileWriter file = new FileWriter("src/3. Modular Programming/" + fileName + ".txt");
            
            /* Loop through the lines and add them */
            for (int x = 0; x < itemsAdded; x++) {
                file.write(words[x] + "\r\n");
            };
            
            /* Close the file */
            file.close();
        } catch (Exception exc) {
            System.out.println("File Writing Error");
            // exc.printStackTrace();
        };
    };
};