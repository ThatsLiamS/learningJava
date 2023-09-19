import java.util.Random;

public class ArraySorting {

    public static void main(String[] args) {
        ArraySorting myClass = new ArraySorting();

        /* BubbleLottery.java task */
        myClass.bubbleLottery();

        /* InsertionLottery.java task */
        myClass.insertionLottery();
    };


    /* Generate 6 random unique numbers between 1 and 49 */
    public int[] generateNumbers() {
        int[] arr = new Random()
            .ints(1, 50)
            .distinct()
            .limit(6)
            .toArray();
        return arr;
    };

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* BubbleLottery.java task */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public int[] bubbleSort(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {

                /* if A > B, swap the variables */
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        };
        return arr;
    };

    public void bubbleLottery() {
        int[] array = generateNumbers();
        array = bubbleSort(array);

        /* Display the elements in the array */
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + (index != array.length-1 ? " | " : ""));
        };

        /* Display the first and last element */
        System.out.println("\nHighest Num: " + array[0] + "\nLowest Num: " + array[array.length - 1]);
    };

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    /* InsertionLottery.java task */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public int[] insertionSort(int[] arr) {
       
        for (int i = 1; i < arr.length; i++) {
            int currentItem = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > currentItem) {
                arr[j + 1] = arr[j];
                j -= 1;
            };
            arr[j + 1] = currentItem;
        };
        return arr;
    };

    public void insertionLottery() {
        int[] array = generateNumbers();
        array = insertionSort(array);

        /* Display the sorted elements */
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + (index != array.length-1 ? " | " : ""));
        };
    };
};