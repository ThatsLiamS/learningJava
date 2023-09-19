import java.util.Random;
import java.util.Scanner;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        MultiDimensionalArrays myClass = new MultiDimensionalArrays();
        myClass.noughtsAndCrosses();
    };

    /* Create global variables */
    Scanner inputScanner = new Scanner(System.in);

    String activePlayer;
    int plays = 0;
    String result = "";

    public void noughtsAndCrosses() {
        String[][] board = generateBoard();

        /* Manage the turns */
        activePlayer = "x";
        for (int turns = 1; turns < (board.length * board.length + 1); turns++) {
            if (plays == board.length * board.length) { result = "You drew!"; }

            /* Determine the next player */
            else if (activePlayer.equals("x") == true) {
                if (playerTurns(board) == true) { result = "You won!"; }
                activePlayer = "o";
            } else {
                if (computerTurns(board) == true) { result = "You lost!"; }
                activePlayer = "x";
            };

            /* Has someone won? */
            if (result.isEmpty() == false) break;
            plays += 1;
        };

        /* Display the result */
        System.out.println("\n\n\n\n" + result);
        displayBoard(board);
        inputScanner.close();
    };

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    // generateBoard, displayBoard
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public String[][] generateBoard() {

        /* Determine board size from input (INT 3 to 10) */
        int boardSize = 0;
        while (boardSize < 3 || boardSize > 10) {
            try {
                System.out.print("Enter board length (3 to 10): ");
                boardSize = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
        };

        /* Create a blank 2D array */
        String[][] board = new String[boardSize][boardSize];

        /* Fill the 2D array with " " */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            };
        };
        return board;
    };

    public void displayBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + (j != board[0].length-1 ?  " | " : ""));
            };
            /* Custom size the borders */
            int repeatNum = board.length < 5 ? board.length : 
                (board.length < 8 ? board.length + 1 : board.length + 2);

            System.out.println("\n-" + "---".repeat(repeatNum));
        };
    };

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    // checkWinner
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean checkWinner(String[][] board) {
        if (plays < (board.length * 2 - 2)) return false;

        /* Scans rows */
        for (int row = 0; row < board.length; row++) {
            boolean blocked = false;
            for (int column = 0; column < board.length; column++) {
                if (board[row][column].equalsIgnoreCase(activePlayer) == false) { blocked = true; };
            };
            if (blocked == false) { return true; };
        };
        /* Scams columns */
        for (int column = 0; column < board.length; column++) {
            boolean blocked = false;
            for (int row = 0; row < board.length; row++) {
                if (board[row][column].contentEquals(activePlayer) == false) { blocked = true; };
            };
            if (blocked == false) { return true; };
        };

        /* Diagonal TL-BR */
        int row = 0;
        boolean blocked = false;
        while (row < board.length) {
            if (board[row][row].equalsIgnoreCase(activePlayer) == false) { blocked = true; };
            row = row + 1;
        };
        if (blocked == false) { return true; };

        /* Diagonal TR-BL */
        row = 0;
        int column = board.length - 1;
        blocked = false;
        while (row < board.length) {
            if (board[row][column].equalsIgnoreCase(activePlayer) == false) { blocked = true; }
            row = row + 1;  column = column - 1;
        };
        if (blocked == false) { return true; };

        /* No one won yet */
        return false;
    };

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    // computerTurns, playerTurns
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean playerTurns(String[][] board) {
        displayBoard(board);

        int row = -1; int column = -1;
        while (row == -1 || column == -1 || (board[row - 1][column - 1].equalsIgnoreCase(" ") == false)) {

            /* Validate user inputs: row & column */
            try {
                System.out.print("\nEnter row: ");
                row = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
            try {
                System.out.print("Enter column: ");
                column = Integer.parseInt(inputScanner.nextLine().trim());
            } catch (Exception exc) { };
            
            /* Are the numbers valid and the space filled? */
            if (row != 1 && column != -1 && board[row - 1][column - 1].equalsIgnoreCase(" ") == false) {
                System.out.println("That space is filled\n");
            }
        }

        /* add the user's choice */
        board[row - 1][column - 1] = "x";
        return checkWinner(board);
    };

    public boolean computerTurns(String[][] board) {
        Random rand = new Random();

        /* Generate two random numbers */
        int row = rand.nextInt(board.length);
        int column = rand.nextInt(board.length);

        /* Is the space filled? Simply regenerate */
        while (board[row][column].equalsIgnoreCase(" ") == false) {
            row = rand.nextInt(board.length);
            column = rand.nextInt(board.length);
        };

        /* add the computer's choice */
        board[row][column] = "o";
        return checkWinner(board);
    };
};