import java.util.Random;

public class RandomNumbers {
    public static void examples(String[] args) {
        // declare a new obj of Random
        Random r = new Random();

        // get a random number between 0 and 100
        int theRandom = r.nextInt(100);
        System.out.println("The random number is " + theRandom);
    };

    public static void main(String[] args) {

        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* RandomDice.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Random r = new Random();

        double total = r.nextInt(6) + 1.00;
        total += r.nextInt(6) + 1.00;
        total += r.nextInt(6) + 1.00;
        total += r.nextInt(6) + 1.00;

        System.out.println("The result is: " + (total / 4.0));

        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* SnakesAndLadders.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        Random rand = new Random();

        /* Declare variables */
        boolean winner = false;
        int activePlayer = 1;

        int playerOne = 0;
        int playerTwo = 0;

        /* While no one has won */
        while (winner == false) {
            int dice = rand.nextInt(6) + 1;
            int square = (activePlayer == 1) ? (playerOne + dice) : (playerTwo + dice);

            if (activePlayer == 1) { System.out.println(); }
            System.out.print("\nPlayer " + activePlayer + " rolled a " + dice + " and landed on square " + square);

            /* Ladders */
            if (square == 3) {
                square = 22; System.out.print(" and climbed the ladder up to " + square + "!");
            } else if (square == 5) {
                square = 8; System.out.print(" and climbed the ladder up to " + square + "!");
            } else if (square == 11) {
                square = 26; System.out.print(" and climbed the ladder up to " + square + "!");
            } else if (square == 20) {
                square = 29; System.out.print(" and climbed the ladder up to " + square + "!");
            }

            /* Snakes */
            else if (square == 17) {
                square = 4; System.out.print(" but slid down the snake to " + square + "!");
            } else if (square == 19) {
                square = 7; System.out.print(" but slid down the snake to " + square + "!");
            } else if (square == 21) {
                square = 9; System.out.print(" but slid down the snake to " + square + "!");
            } else if (square == 27) {
                square = 1; System.out.print(" but slid down the snake to " + square + "!");
            };

            /* Updates the player's position */
            if (activePlayer == 1) { playerOne = square; }
            else { playerTwo = square; }

            if (square >= 30) { winner = true; };
            activePlayer = (activePlayer == 1) ? 2 : 1;
        };

        /* Declare the winner */
        System.out.println("\n\n\nThere is a winner: " + playerOne + " vs " + playerTwo);
    };
};