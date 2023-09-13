import java.util.Random;

public class ArraySorting {

    public static void main(String[] args) {
        ArraySorting myClass = new ArraySorting();

        /* BubbleLottery.java task */
        myClass.bubbleLottery();

        /* InsertionLottery.java task */
        myClass.insertionLottery();
    };


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


    public int[] generateNumbers() {
        int[] arr = new Random()
            .ints(1, 50)
            .distinct()
            .limit(6)
            .toArray();
        return arr;
    };


    public void bubbleLottery() {
        int[] array = generateNumbers();
        array = bubbleSort(array);

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + (index != array.length-1 ? " | " : ""));
        };

        System.out.println("\nHighest Num: " + array[0] + "\nLowest Num: " + array[array.length - 1]);
    };

    public void insertionLottery() {
        int[] array = generateNumbers();
        array = insertionSort(array);

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + (index != array.length-1 ? " | " : ""));
        };
    };
};