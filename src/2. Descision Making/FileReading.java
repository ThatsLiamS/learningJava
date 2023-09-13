import java.io.*;
import java.util.Scanner;
 
public class FileReading {
    
    public static void examples(String[] args) {
        
        try {
            //File reading lines go here
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
             
             // read and store the first line
            String tempString = br.readLine();
    
            tempString = br.readLine(); // read the next line
            tempString = br.readLine(); // read the next line
            tempString = br.readLine(); // read the next line
    
            br.close(); //ONCE, when all READING IS FINISHED
            System.out.println(tempString);
 
        } catch(Exception exc) {
             System.out.println("File Reading Error");
             exc.printStackTrace(); 
        };
    };
    
    public static void main(String[] args) {
        
        /* BasicReader.java task */
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Name of the file to read: ");
        String fileName = inputScanner.nextLine();
        
        inputScanner.close();
 
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/2. Descision Making/" + fileName + ".txt"));
            
            int count = 0;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                
                System.out.println(line);
                count += 1;
                
            };
            br.close();
            
            System.out.println("\nThere were " + count + " lines in the file " + fileName);
        } catch (Exception exc) {
            System.out.println("File Reading Error");
            exc.printStackTrace();
        };
        
    };
};
