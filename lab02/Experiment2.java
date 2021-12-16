package lab02;

import java.util.Scanner;

public class Experiment2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		/*****************
		 * Experiment #2 *
		 *****************/
		// Use a loop to get input, wait for valid input */
		// Create a Boolean 'flag' to hold true or false. It will represent
		// the idea that the user has supplied valid input. At the start
		// of the program run, it's false. (No valid user input yet.)
		boolean userInputIsOK = false; 
		
		// We need a variable to hold the user input. For this experiment,
		// we'll have the user input a string. We should initialize the variable
		// with something, but since the user hasn't typed anything in yet,
		// we need a 'nothing' string.
		String userWord = "";  // It may be better to use a null object. We'll cover it soon.
		
		// Our input loop.
		while (!userInputIsOK) // Loop as long as the user input is NOT ok.
		{
		    // Get input from the user.
			System.out.print("Experiment #2: Type a word and press enter: ");
			userWord = in.next();

		    // Test the input for validity.
		    // If valid, set userInputIsOK to true.
			if (userWord.equals("rock")) // Remove this after testing.
				userInputIsOK = true;
			if (userWord.equals("paper"))
				userInputIsOK = true;
			if (userWord.equals("scissors"))
				userInputIsOK = true;
			
			/** Your work here -- accept "rock", accept "paper", and accept "scissors" as input. **/
			/** Also remove "valid" as valid input. **/
		}
		// Done.
		System.out.println("Experiment #2: You entered: " + userWord);
	}
}
