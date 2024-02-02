import java.util.Scanner;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's master 3.3 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class TenTimesBinary {

	public static void main(String[] args)
	{
		TenTimesBinary myClass = new TenTimesBinary();
		myClass.executeCode();
	}


	/**
	 * This method preforms a standard binary search, from median value, on a Integer Array
	 * until the search query is met, or the upper bound is less than the lower bound.
	 * 
	 * @param  array           Integer array with contents to be searched
	 * @param  searchQuery     Query value to search for
	 * @return                 Index position of searchQuery (-1 if not found)
	**/
	public int binarySearch(int[] array, int searchQuery)
	{
		int start = 0;
		int midpoint = 0;
		int end = array.length;
		
		while (start != end && array[midpoint] != searchQuery)
		{
			midpoint = start + (end - start) / 2;

			if (array[midpoint] < searchQuery)
			{
				start = midpoint + 1;
			}
			else if (array[midpoint] > searchQuery)
			{
				end = midpoint - 1;
			}
			else
			{
				return midpoint;
			}
		}

		return -1;
	}

	/**
	 * This method will generate an Integer Array with 100 elements,
	 * where each element is 10 times the index position.
	 * 
	 * @return   Integer array, where the value is 10 times the index
	**/
	public int[] generateArray()
	{
		int[] array = new int[100];
		for (int i = 0; i < 100; i++)
		{
			array[i] = i * 10;
		}

		return array;
	}


	/**
	 * This method is the gateway into the TenTimesBinary class, and provides
	 * the structure and order of event & method calls, and general logic.
	**/
	public void executeCode()
	{
		int[] array = generateArray();

		System.out.println("\n350's position is: " + binarySearch(array, 350));
		System.out.println("750's position is: " + binarySearch(array, 750));
	}
}
