import java.util.Random;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's master 3.4 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class InsertionLottery {

	public static void main(String[] args)
	{
		InsertionLottery myClass = new InsertionLottery();
		myClass.executeCode();
	}


	/**
	 * This method preforms a standard insertion sort on an Integer Array,
	 * to sort into ascending order and then returns the array.
	 * 
	 * @param    array    Integer Array to be sorted
	 * @return            Sorted Integer Array
	**/
	public int[] insertionSort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int currentItem = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > currentItem) {
				array[j + 1] = array[j];
				j -= 1;
			}
			array[j + 1] = currentItem;
		}

		return array;
	}

	/**
	 * This method creates a stream of 6 random Integers, between
	 * 1 and 49 inclusive, which is converted to an array and returned.
	 * 
	 * @return   Integer Array, length 6
	**/
	public int[] generateNumbers()
	{
		int[] array = new Random()
			.ints(1, 50)
			.distinct()
			.limit(6)
			.toArray();

		return array;
	}

	/**
	 * This method takes an Integer Array, and will output each element on a single line.
	 * With the exception of any null, or falsy values.
	 * 
	 * @param   array   The String Array to be displayed
	**/
	public void displayArray(int[] array)
	{
		for (int index = 0; index < array.length; index++)
		{
			System.out.print(array[index] + (index != array.length-1 ? " | " : ""));
		}
	}


	/**
	 * This method is the gateway into the InsertionLottery class, and provides
	 * the structure and order of event & method calls, and general logic.
	**/
	public void executeCode()
	{
		displayArray(  insertionSort(  generateNumbers()  )  );
	}
}
