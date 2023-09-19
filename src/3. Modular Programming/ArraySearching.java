import java.util.Scanner;
 
public class ArraySearching {
    
    public static void main(String[] args) {
        ArraySearching myClass = new ArraySearching();
 
        /* LinearNames.java task */
        myClass.linearNames();
        
        /* TenTimesBinary.java */
        myClass.tenTimesBinary();
    };
    
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* Linear Names.java Task
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public int linearSearch(String[] arr, String searchQuery) {
        for (int index = 0; index < arr.length; index++) {
            /* Does the index match the search */
            if (arr[index].equalsIgnoreCase(searchQuery)) {
                return index;
            }
        };
        /* 404 NOT FOUND */
        return -1;
    };

    public void linearNames() {
        String[] array = new String[10];
        
        Scanner inputScanner = new Scanner(System.in);
        
        /* Populate the Array */
        for (int x = 1; x <= 12; x++) {
            if (array[array.length - 1] != null) {
                System.out.println("The array is now full!");
                break;
            };
            
            System.out.print("Enter name " + x + ": ");
            array[x - 1] = inputScanner.nextLine().trim();
        };
        
        /* Display each element in the array */
        for (int x = 0; x < array.length; x++) {
            System.out.print(array[x] + (x != array.length-1 ? " | " : ""));
        };
        
        /* Validate user input: SearchQuery */
        String query = "";
        while (query.isEmpty() || query.length() < 1) {
            System.out.print("\nEnter a SearchQuery: ");
            query = inputScanner.nextLine().trim();
        } 
        
        /* Search the array */
        ArraySearching myClass = new ArraySearching();
        System.out.println("The position is: " + myClass.linearSearch(array, query));
        
        inputScanner.close();
        
    };


    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* TenTimesBinary.java Task */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public int binarySearch(int[] arr, int searchQuery) {
        
        int start = 0;
        int midpoint = 0;
        int end = arr.length;
        
        while (start != end && arr[midpoint] != searchQuery) {
            midpoint = start + (end - start) / 2;
            
            if (arr[midpoint] < searchQuery) {
                start = midpoint + 1;
            }
            else if (arr[midpoint] > searchQuery) {
                end = midpoint - 1;
            }
            
            else { return midpoint; };
        };
    
        return -1;
    };
    
    public void tenTimesBinary() {
        /* Create and populate the array */
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i * 10;
        };
        
        ArraySearching myClass = new ArraySearching();
        
        /* Search the array */
        System.out.println("\n350's position is: " + myClass.binarySearch(array, 350));
        System.out.println("750's position is: " + myClass.binarySearch(array, 750));
    };
};