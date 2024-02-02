import java.util.Scanner;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's standard 3.3 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class LinearNames {

	public static void main(String[] args)
	{
		LinearNames myClass = new LinearNames();
		myClass.executeCode();
	}


	/**
	 * This method preforms a standard linear search from index 0, on a String Array
	 * until the search query is met, or the array length is exceeded. 
	 * 
	 * @param  array           String array with contents to be searched
	 * @param  searchQuery     Query value to search for
	 * @return                 Index position of searchQuery (-1 if not found)
	**/
	public int linearSearch(String[] array, String searchQuery)
	{
		for (int index = 0; index < array.length; index++)
		{
			if (array[index].equalsIgnoreCase(searchQuery))
			{
				return index;
			}
		}
		return -1;
	}

	/**
	 * This method takes a String Array, and will output each element on a new line.
	 * With the exception of any null, or falsy values.
	 * 
	 * @param   array   The String Array to be displayed
	**/
	public void displayArray(String[] array)
	{
		for (int index = 0; index < array.length; index++)
		{
			if (array[index] != null && array[index].length() > 0)
			{
				System.out.println( array[index] );
			}
		}
	}

	/**
	 * This method will prompt the user with a provided phrase repeatedly until a
	 * valid string value has been entered.
	 * 
	 * @param    prompt   The prompting message to display to the user
	 * @return            The valid string entered by the user
	**/
	public String getUserInput(String prompt)
	{
		Scanner inputScanner = new Scanner(System.in);

		String searchQuery = "";
		while (searchQuery.isEmpty() || searchQuery.length() < 1)
		{
			System.out.print(prompt + ": ");
			searchQuery = inputScanner.nextLine().trim();
		}
		
		inputScanner.close();
		return searchQuery;
	}

	/**
	 * This method will create an array (fixed length of 10), and will
	 * call "getUserInput" until the array is full of valid string names.
	 * 
	 * @return    An array of 10 string-value names
	**/
	public String[] generateArray()
	{
		String[] array = new String[10];

		for (int index = 0; index < 12; index++)
		{
			if (array[array.length - 1] == null)
			{
				String enteredName = getUserInput("Enter name " + (index + 1));
				array[index] = enteredName;
			}
			else
			{
				System.out.println("The array is now full.");
				break;
			}
		}

		return array;
	}


	/**
	 * This method is the gateway into the LinearNames class, and provides
	 * the structure and order of event & method calls, and general logic.
	**/
	public void executeCode()
	{
		String[] array = generateArray();
		displayArray(array);
		
		String searchQuery = getUserInput("Enter the Search Query");
		int elementLocation = linearSearch(array, searchQuery);

		System.out.println("The position is: " + elementLocation);
	}
}
