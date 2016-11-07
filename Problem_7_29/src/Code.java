/**This program is based upon the problem 7.29 in Chapter 7 of 
 * Liang's Intro to Java
 * This program also yielded the value of the suit, just for
 * aesthetic purposes
 * Additional info to solve the problem was found on StackOverflow
 * The people on StackOverflow are very noob-friendly...
 * Props to Dr. Jeremy Evert for being an awesome professor
 * This coding has been done in Eclipse.
 * The program utilizes the Java language.
 * God bless America.
 */

import java.util.Scanner;
public class Code {

	//Main method
	public static void main(String[] args) {
		//Importing the scanner
		Scanner input = new Scanner(System.in);

		//Lengthy introduction of the program
		System.out.print("This program will pick 4 cards from a deck");
		System.out.println(" that will yield a specific sum.");
		System.out.println("Ace is worth 1, Jack is worth 11, Queen is"
				+ " worth 12, King is worth 13.");
		System.out.println("If you're looking for Blackjack values, go "
				+ "find someone else to do so.");

		//The program now asks the user to input the desired sum
		System.out.println("Insert the sum you want to find combinations.");
		System.out.print("Sum: ");

		//Receiving the value of the sum
		int userSum = input.nextInt();

		//Considering impossible cases...
		if (userSum < 4 || userSum > 52) {
			System.out.println("That's impossible");
			System.out.println("Program terminated.");
			System.exit(0);
		}

		//Initializing array for the value of the card
		int[] pickValue;
		pickValue = new int[4];

		//Initializing array for the suit of the card
		int[] pickSuit;
		pickSuit = new int[4];

		//Intialize value for the sum that is used in the loop below
		int sum = 0;

		/*If the sum yielded by the randomized values of the card in
		 *the loop below, then keep on going until it meets the 
		 *criteria that the user defined
		 */
		while (sum!=userSum) {
			//Reset the sum to 0 every time the loop goes back
			sum = 0;

			//A loop that suns for 4 slots of the array.
			for (int i=0; i<pickValue.length; i++) {
				//Recalls the custom method that gives a random value
				pickValue[i] = randomValue();

				//Adds that value to the sum
				sum += pickValue[i];
			}

			/*A loop that suns for 4 slots of the array.
			 *It is a for loop in a for loop to make sure
			 *that there are no duplications of the suits
			 */
			for (int i=0; i<pickSuit.length; i++) {
				for (int j=i+1; j<pickSuit.length; j++) {
					if (pickValue[i] == pickValue[j]) {
						if (pickSuit[i] == pickSuit[j])
							/*Recalls the custom method that 
							 *gives a random suit
							 */
							pickSuit[j] = randomSuit();
					}

				}
			}

			//If the sum that is yielded from the calculations 
			if (sum==userSum) {
				//Recalls the custom method to... print stuff
				printStuff(pickValue,pickSuit);
			}
		}
	}

	//The custom method to print stuff
	private static void printStuff(int[] pickValue, int[] pickSuit) {
		/*Initializes a string array to represent the values.
		 *The Fool is supposed to represent 0, which is not possible
		 *in deck values
		 */
		String value[] = {"Fool", "Ace", "2", "3", "4", "5", "6", "7", "8", 
				"9", "10", "Jack", "Queen", "King"};

		//Initializes a stirng array to represent the suits
		String suit[] = {" of Spades", " of Diamonds", " of Hearts"
				, " of Clubs"};

		//Just a print statement for user interface's sake
		System.out.print("Four card combinations that yield 24 are ");

		for (int i=0; i<pickValue.length-1; i++) {
			System.out.print((value[pickValue[i]]) + suit[pickSuit[i]] + ", ");
		}
		System.out.println((value[pickValue[3]]) + "" + suit[pickSuit[3]] + ".");
	}

	private static int randomValue() {
		return (int)(Math.random() * (14-1) + 1);
	}

	private static int randomSuit() {
		return (int)(Math.random() * 4);
	}

}