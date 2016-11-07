/**This program is based upon the problem 8.11 in Chapter 8 of 
 * Liang's Intro to Java
 * Found nothing to spice the program up...
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
		//Importing scanner to receive user input
		Scanner input = new Scanner(System.in);

		//Introducing the program to the user
		System.out.println("This program prints a matrix depending on"
				+ " the number that the user typed in, by converting"
				+ " that number to binary form");

		//Prompting the user to input a number between 0 and 511
		System.out.println("Please insert a number between 0 and 511");
		System.out.print("Desired number: ");
		int sel = input.nextInt();
		
		//If the input is invalid, take necessary actions
		if (sel < 0 || sel > 511) {
			System.out.println("Invalid input. Program terminated.");
			System.exit(0);
		}
		
		//Create a string to contain the binary after it is converted
		String binary = DecimaltoBinaryConversion(sel);
		
		//Just print out the binary form of the number the user put in
		System.out.println("The number " + sel + " after being converted to "
				+ "binary is " + binary);

		//Create a 2D array to contain the matrix
		String[][] matrix = new String[3][3];
		
		//User interface
		System.out.println("Here is the head-tails matrix:");
		
		//A variable to pinpoint the location in the binary string
		int binarypos = 0;

		//A for loop inside a for loop to cover all 9 slots of the 2D array
		for (int i=0; i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				//If the position in the binary is 0, it would be heads
				if (binary.charAt(binarypos++) == '0') {
					//So that slot in the array will be heads (H)
					matrix[i][j] = "H";
					
					//Print out the matrix slot, and adds a space
					System.out.print(matrix[i][j] + " ");
				}
				
				//If it's not 0 it can only be 1
				else {
					//Assign tails (T)
					matrix[i][j] = "T";
					
					//And print out the matrix slot + add a space
					System.out.print(matrix[i][j] + " ");
				}
			}
			//After every array line, add a line (?)
			System.out.println();
		}
	}

	//Custom method to convert a number to binary form
	private static String DecimaltoBinaryConversion(int sel) {
		//Create a StringBuilder to contain binary
		StringBuilder binary = new StringBuilder();
		
		//Unless the number typed by the user is 0...
		while (sel!=0) {
			/*Binary depends on whether that number when divided by 2
			/*will yield a remainder. 0 for no remainder, 1 for remainder.
			 */
			binary.append(sel % 2);
			
			//After using modular, divide that by 2
			sel = sel / 2;
		}	
		
		/*Since we put in the binary from left to right which isn't right,
		/*reverse that sucker to give it the correct form
		 */ 
		binary = binary.reverse();
		
		//Sometimes we need to fill in 0's to make the binary's length 9...
		while (binary.length() < 9) {
			binary.insert(0, "0");
		}
		
		//Return that to the binary in the main method above
		return binary.toString();
	}
}