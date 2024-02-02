import java.util.Random;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's standard 3.4 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class BubbleLottery {

	public static void main(String[] args)
	{
		BubbleLottery myClass = new BubbleLottery();
		myClass.executeCode();
	}


	/**
	 * This method preforms a standard bubble sort on an Integer Array,
	 * to sort into descending order and then returns the array.
	 * 
	 * @param    array    Integer Array to be sorted
	 * @return            Sorted Integer Array
	**/
	public int[] bubbleSort(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length - 1; j++)
			{

				if (array[j] < array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}

			}
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
	 * This method is the gateway into the BubbleLottery class, and provides
	 * the structure and order of event & method calls, and general logic.
	**/
	public void executeCode()
	{
		int[] array = generateNumbers();
		array = bubbleSort(array);

		displayArray(array);

		System.out.println("\nHighest Num: " + array[0] + "\nLowest Num: " + array[array.length - 1]);
	}
}
