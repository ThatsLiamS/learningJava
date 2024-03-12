import java.util.Scanner;
import java.util.Random;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's master 3.6 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class ChallengeSafeCracker
{
	
	Scanner inputScanner = new Scanner(System.in);
	
	int[] safeCode = new int[3];
	int maxGuesses = -2;
	boolean hints = false;


	public static void main(String[] args)
	{
		SafeCracker myClass = new SafeCracker();
		myClass.executeCode();
	}
	
	/**
	 * This method is the gateway into the SafeCracker class, and provides
	 * the structure and order of event & method calls, and general logic.
	**/
	public void executeCode()
	{
		generateCode();
		while (true)
		{
			if (menu() == true)
			{
				break;
			}
		}
	}
	
	/**
	 * This method displays the menu of 4 options, and uses selection to execute the
	 * required section of code.
	 */
	public boolean menu()
	{
		/* Enter and validate option int input */
		int option = -1;
		while (option < 1 || option > 5)
		{
			/* Display menu options */
			System.out.println("\n1. Randomly generate a 3-digit safe code\n2. Set max number of guesses");
			System.out.println("3. Turn hints on/off \n4. Guess the code \n5. Exit\n\n");
			/* Has the user entered a valid int? */
			try
			{
				System.out.print("Enter menu option: ");
				option = Integer.parseInt(inputScanner.nextLine().trim());
			}
			catch (Exception exc) { }
		}

		/* Run the selected method */
		if (option == 1)
		{
			generateCode();
		}
		else if (option == 2)
		{
			setGuesses();
		}
		else if (option == 3)
		{ 
			setHints();
		}
		else if (option == 4) 
		{
			boolean failed = true;
			if (maxGuesses < 0)
			{
				/* User is allowed unlimited guesses */
				while (guessCode() == false) { };
				failed = false;
			}
			else
			{
				/* Allow guesses up to the max */
				for (int x = 0; x < maxGuesses; x++)
				{
					if (guessCode() == true)
					{ 
						failed = false;
						break;
					}
				}
			}
			
			System.out.println("\n\n" + (failed == true ?
				"You didn't manage to guess the code in time..." :
				"Congrats, you cracked the safe!!"
				) + "\n\n");
		}

		/* User has requested the stop */
		else if (option == 5)
		{
			inputScanner.close();
			return true;
		}

		/* Add a small delay between methods and the next menu */
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception exc) { }
		return false;
	}


	/**
	 * This method will generate a random 3 digit integer using the
	 * defaulty included random class.
	 */
	public void generateCode()
	{
		/* Generate 'random' int[3] */
		safeCode = new Random().ints(0, 10).limit(3).toArray();
		System.out.println("Code has been generated!");
	}

	
	/**
	 * This method will take a user input to determine the number of guesses 
	 * the user can have, including unlimited guesses.
	 */
	public void setGuesses()
	{
		/* UserInput: int number of guesses */
		while (maxGuesses < -1)
		{
			System.out.print("Enter max number of guesses (-1 for unlimited): ");
			/* Is the input an Integer */
			try 
			{
				maxGuesses = Integer.parseInt(inputScanner.nextLine());
			}
			catch (Exception exc) { };
			/* Inform the user of the changes */
			System.out.println("Max Guess set to: " + maxGuesses);
		}
	}


	/**
	 * This method will determine whether the user accepts hints 
	 * to how many numbers they have guessed right.
	 */
	public void setHints()
	{
		/* UserInput: boolean string y/n */
		String response = "";
		while (response.isEmpty() == true || (response.equals("y") == false && response.equals("n") == false))
		{
			System.out.print("Do you wish to have hints (y/n): ");
			response = inputScanner.nextLine().trim();
		}
		
		/* Inform the user of the changes */
		hints = (response.equalsIgnoreCase("y")) ? true : false;
		System.out.println("Hints sets to: " + hints);
	}


	/**
	 *  This method allows the user to guess the code, and will display
	 *  how many numbers are guessed correctly and returns whether all three
	 *  are correct or not
	 *  
	 *  @return   have they won
	 */
	public boolean guessCode()
	{
		/* input a 3 digit number */
		int tempNum = -1;
		while (tempNum < 0 || tempNum > 999)
		{
			try
			{
				System.out.print("Enter a 3 digit number: ");
				tempNum = Integer.parseInt(inputScanner.nextLine());
			}
			catch (Exception exc) { }
		}
		
		/* Ensure there are 3 digits - auto-filled suffix 0's */
		String numStr = Integer.toString(tempNum);
		while (numStr.length() < 3)
		{
			numStr = numStr + "0";
		}
		
		String[] guessed = numStr.split("");
		
		/* How many did they guess right */
		int numCorrect = 0;
		for (int index = 0; index < 3; index++)
		{
			if (Integer.parseInt(guessed[index]) == safeCode[index])
			{
				numCorrect += 1;
			}
		}
		
		/* are hints enabled? */
		if (hints == true)
		{
			/* Informs the user how many they got right */
			System.out.println("You guessed " + numCorrect + " correctly\n");
		}

		/* Ternary, did they get all three */
		return (numCorrect == 3) ? true : false;
	}
}