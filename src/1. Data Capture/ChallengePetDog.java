import java.util.Scanner;

public class ChallengePetDog {

	public static void main(String[] args) {
		
		/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* Challenge - Pet Dog */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		Scanner inputScanner = new Scanner(System.in);

		/* Define Variable Types */
		String name = "";
		while (name.length() < 2) {
			System.out.print("Enter the dog's name: ");
			name = inputScanner.nextLine();
		};

		String coatColor = "";
		while (coatColor.length() < 2) {
			System.out.print("Enter the dog's coat color: ");
			coatColor = inputScanner.nextLine();
		};

		int levelEnergy = 0;
		while (levelEnergy < 1 || levelEnergy > 10) {
			System.out.print("How energetic is " + name + " (1-10): ");
			levelEnergy = inputScanner.nextInt();
		};
		inputScanner.nextLine();

		double weightKG = -1.0;
		while (weightKG == -1.0) {
			try {
				System.out.print("Enter " + name + "'s weight (KG): ");
				weightKG = Double.parseDouble(inputScanner.nextLine());
			} catch (Exception exc) { System.out.println("That isn't a valid double.."); };
		};
		/* Convert Kg to Lbs */
		double weightPounds = Math.round(weightKG * 2.204623 * 100.0) / 100.0;

		/* Display the dog's bio */
		System.out.println("\nDog's Name: " + name);
		System.out.println("Dog's Fur Color: " + coatColor);
		System.out.println("Dog's Energy Level: " + levelEnergy);
		System.out.println("Dog's Weight: " + weightPounds + " lbs");

		/* Action Commands for the dog */
		System.out.print("\n\n_Commands_\n\nSit. Speak. Fetch. Shake.\n");
		String command = "";
		while (command.equalsIgnoreCase("sit") == false && command.equalsIgnoreCase("speak") == false &&
			command.equalsIgnoreCase("fetch") == false && command.equalsIgnoreCase("shake") == false) {
	
				System.out.print("Enter command: ");
				command = inputScanner.nextLine();
			};
		
		/* Display an action based on the command */
		if (command.equalsIgnoreCase("sit")) { System.out.println(name + " sits patiently and waits."); }
		else if (command.equalsIgnoreCase("speak")) { System.out.println(name + " barks loudly."); }
		else if (command.equalsIgnoreCase("fetch")) { System.out.println(name + " runs to fetch the ball."); }
		else { System.out.println(name + " raises their paw and shakes your hand."); };

		/* End the Scanner Stream */
		inputScanner.close();
	};
};