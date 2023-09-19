import java.util.Scanner;
 
public class Encryption {
    
    public static void examples(String[] args) {
 
        String myString = "Java";
        //the FIRST character at each position of a String
        char firstLetter = myString.charAt(0);
        //Or ITERATE through EVERY character using a for loop…
        int i = 0; char currentLetter = myString.charAt(i);
        
        //Get the ASCII value of a character
        int firstLetterASCII = (int)firstLetter;
        
        //Alter the position of an ASCII value
        int newLetterASCII = (firstLetterASCII-3);
        //Convert an ASCII value to a character
        char newLetter = (char) newLetterASCII;

        System.out.println(newLetter + " " + currentLetter);
    };

    
    public static void main(String[] args) {
        /* SecretCaeser.java */
        Encryption myClass = new Encryption();
        myClass.caeserRunAll();
        
        /* SecretAtBash.java task */
        myClass.AtbashInput();
        myClass.AtbashEncrypt();
        myClass.AtbashOutput();
    };


    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* Secret Caeser */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 
    String plainText = "HelloWorld";
    String encrypted = "";
    
    /* Display the Ascii for each character */
    public void caeserAscii() {
        for (int i = 0; i < plainText.length(); i++) {
            int ascii = plainText.charAt(i) + 0;
            System.out.println(plainText.charAt(i) + ": " + ascii);
        };
    };
    /* Increase the Ascii value by 10 and convert to Char */
    public void caeserEncrypt() {
        for (int i = 0; i < plainText.length(); i++) {
            int ascii = plainText.charAt(i) + 10;
            encrypted = encrypted + (char)ascii;
        };
    };
    /* Display the new encrypted String */
    public void caeserOutput() {
        System.out.println(encrypted);
    };

    public void caeserRunAll() {
        Encryption myClass = new Encryption();
        /* Run all methods */
        myClass.caeserAscii();
        myClass.caeserEncrypt();
        myClass.caeserOutput();
    };
 
    
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* Secret AtBash */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    String sentence = "";
    String sentenceEncrypted = "";

    public void AtbashInput() {
        Scanner inputScanner = new Scanner(System.in);
        
        /* UserEntry: Validation */
        while (sentence.isEmpty() || sentence.length() < 3) {
            System.out.print("Enter a sentence: ");
            sentence = inputScanner.nextLine().trim();
        };
 
        inputScanner.close();
    };

    /* Apply the Atbash encryption method */
    public void AtbashEncrypt() {
        for (int i = 0; i < sentence.length();  i++) {
            int letter = (int)sentence.charAt(i);
            letter = 122 - (letter - 65);
            
            sentenceEncrypted += (char)letter;
            
        };
    };
    /* Display the encrypted string */
    public void AtbashOutput() {
        System.out.println(sentenceEncrypted);
    };
};