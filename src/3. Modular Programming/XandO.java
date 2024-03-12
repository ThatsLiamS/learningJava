import java.util.Random;
import java.util.Scanner;

/**
 * This class conforms to the regulations set forth within the
 * "Java Essentials" EBook's master 3.5 task.
 * 
 * @author Liam Skinner
 * 
 * Credit: Winstanley College
 *         for the creation of this task.
**/
public class XandO
{
	public static void main(String[] args)
	{
		XandO myClass = new XandO();
		myClass.executeCode();
	}

	private Scanner inputScanner = new Scanner(System.in);
	
	/**
	 * This method is the gateway into the XandO class, and provides
	 * the structure and order of event & method calls, and general logic.
	 * 
	 * Specifically, it will generate the board, and iteratively
	 * calls either PlayersTurn, or ComputersTurn until someone has
	 * won, or the board has been filled.
	**/
	public void executeCode()
	{
		String[][] board = generateBoard();

		String activePlayer = "x";
		int plays = 0;
		String result = "";

		for (int turns = 1; turns < (board.length * board.length + 1); turns++)
		{

			if (activePlayer.equals("x") == true)
			{
				playersTurn(board);
			}
			else
			{
				computersTurn(board);
			}
			
			result = (plays == board.length * board.length - 1) ? "You Drew!" : result;
			result = checkWinner(board, "x") ? "You Won" : result;
			result = checkWinner(board, "o") ? "You Lost" : result;
			
			if (result.isEmpty() == false)
			{
				break;
			}
	
			activePlayer = (activePlayer.equals("o")) ? "x" : "o";
			plays += 1;
		}

		/* Display the result */
		System.out.println("\n".repeat(10) + result);
		displayBoard(board);
		inputScanner.close();
	}

	
	/**
	 * ~~ Generate the Board ~~
	 * 
	 * This method will fetch a User input for the dimensions of the board,
	 * and will generate a square 2d array according to that dimension.
	 * 
	 * @return   String[][]  2D Empty Board
	 */
	public String[][] generateBoard()
	{

		/* Determine board size from input (INT 3 to 10) */
		int boardSize = 00;
		while (boardSize < 3 || boardSize > 10)
		{
			try
			{
				System.out.print("Enter board length (3 to 10): ");
				boardSize = Integer.parseInt(inputScanner.nextLine().trim());
			} catch (Exception exc) { };
		}

		/* Create a blank 2D array */
		String[][] board = new String[boardSize][boardSize];

		/* Fill the 2D array with " " */
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				board[i][j] = " ";
			}
		}
		return board;
	}

	/**
	 * ~~ Displays the Board ~~
	 * 
	 * This method will display the contents of the board to
	 * the screen, and generate a border around it. 
	 * 
	 * @param  board  The 2D Game Board Array
	 */
	public void displayBoard(String[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j] + (j != board[0].length-1 ?  " | " : ""));
			}
			/* Custom size the borders */
			int repeatNum = board.length < 5 ? board.length : 
				(board.length < 8 ? board.length + 1 : board.length + 2);

			System.out.println("\n-" + "---".repeat(repeatNum));
		}
	}


	/**
	 *  ~~ Checks The Winner ~~
	 * 
	 * This method will scan across the board, and 
	 * check for any winning combinations. 
	 * 
	 * @param   board         The 2D Game Board Array
	 * @param   playerSymbol  The string code of a Player
	 * @return  boolean       Whether the current player has won
	 */
	public boolean checkWinner(String[][] board, String playerSymbol)
	{
		/* Scans rows */
		for (int row = 0; row < board.length; row++)
		{
			boolean blocked = false;
			for (int column = 0; column < board.length; column++)
			{
				if (board[row][column].equalsIgnoreCase(playerSymbol) == false)
				{
					blocked = true;
				}
			}
			if (blocked == false)
			{
				return true;
			}
		}
		/* Scans columns */
		for (int column = 0; column < board.length; column++)
		{
			boolean blocked = false;
			for (int row = 0; row < board.length; row++)
			{
				if (board[row][column].contentEquals(playerSymbol) == false)
				{
					blocked = true;
				}
			}
			if (blocked == false)
			{
				return true;
			}
		}

		/* Diagonal TL-BR */
		int row = 0;
		boolean blocked = false;
		while (row < board.length)
		{
			if (board[row][row].equalsIgnoreCase(playerSymbol) == false)
			{
				blocked = true;
			}
			row = row + 1;
		}
		if (blocked == false)
		{
			return true;
		}

		/* Diagonal TR-BL */
		row = 0;
		int column = board.length - 1;
		blocked = false;
		while (row < board.length)
		{
			if (board[row][column].equalsIgnoreCase(playerSymbol) == false)
			{
				blocked = true;
			}
			row = row + 1;  column = column - 1;
		}
		if (blocked == false)
		{
			return true;
		}

		/* No one won yet */
		return false;
	}


	/**
	 * ~~ The Player's Turn ~~
	 * 
	 * This method allows the user to enter a co-ordinate of an empty
	 * space and then will place an 'X' in that lcoation.
	 * 
	 * @param   board     The 2D Game Board Array
	 */
	public void playersTurn(String[][] board)
	{
		displayBoard(board);

		int row = -1; int column = -1;
		while (row == -1 || column == -1 || (board[row - 1][column - 1].equalsIgnoreCase(" ") == false))
		{

			/* Validate user inputs: row & column */
			try
			{
				System.out.print("\nEnter row: ");
				row = Integer.parseInt(inputScanner.nextLine().trim());
			}
			catch (Exception exc) { }
			try
			{
				System.out.print("Enter column: ");
				column = Integer.parseInt(inputScanner.nextLine().trim());
			}
			catch (Exception exc) { }

			/* Are the numbers valid and the space filled? */
			if (row != 1 && column != -1 && board[row - 1][column - 1].equalsIgnoreCase(" ") == false)
			{
				System.out.println("That space is filled\n");
			}
		}

		/* add the user's choice */
		board[row - 1][column - 1] = "x";
	}

	/**
	 * ~~ The Computer's Turn ~~
	 * 
	 * This method will allow the computer to randomly generate 
	 * a set of co-ordinates, and checks whether that space is 
	 * free, to then place an 'O'.
	 * 
	 * @param   board     The 2D Game Board Array   
	 */
	public void computersTurn(String[][] board)
	{
		Random rand = new Random();

		/* Generate two random numbers */
		int row = rand.nextInt(board.length);
		int column = rand.nextInt(board.length);

		/* Is the space filled? Simply regenerate */
		while (board[row][column].equalsIgnoreCase(" ") == false)
		{
			row = rand.nextInt(board.length);
			column = rand.nextInt(board.length);
		}

		/* add the computer's choice */
		board[row][column] = "o";
	}
}