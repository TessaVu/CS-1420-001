/* This program plays a simple game of rock-paper-scissors (roshambo)
 * with the user. (Students will complete this program as part of
 * lab #2.) See the lab instructions.
 * 
 * Peter Jensen and Tessa Vu
 * August 31, 2021
 */

package lab02;

import java.util.Scanner;

public class RockPaperScissors
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); // Create a scanner object.

		String computerWord = "";
		String userWord = "";

		int value = (int)(Math.random() * 3); // Randomize integers 0 to 2 and assign as rock, paper, and scissors respectively.
		
		System.out.println("Enter rock, paper, or scissors: " + value);
				
		if (value == 0)
			computerWord = "rock";
		else if (value == 1)
			computerWord = "paper";
		else if (value == 2)
			computerWord = "scissors";
		
		boolean userInputIsOK = false;
		
		while (!userInputIsOK) // Loop as long as the user input is not okay (i.e. not rock, paper, nor scissors).
		{	
			System.out.print("Enter rock, paper, or scissors: ");
			userWord = in.next();
			
			if (userWord.equals("rock")) // Test user input(s) for validity.
				userInputIsOK = true;
			if (userWord.equals("paper"))
				userInputIsOK = true;
			if (userWord.equals("scissors"))
				userInputIsOK = true;			
		}
		
		System.out.println("I picked " + computerWord + ".");
		System.out.println("You picked " + userWord + ".");
		
		if (userWord.equals(computerWord))
	        System.out.println("It's a tie.");
	    else if (userWord.equals("rock") && computerWord.equals("paper"))
	        System.out.println("I win.");
	    else if (userWord.equals("paper") && computerWord.equals("scissors"))
	        System.out.println("I win.");
	    else if (userWord.equals("scissors") && computerWord.equals("rock"))
	        System.out.println("I win.");
		else if (userWord.equals("rock") && computerWord.equals("scissors"))
			System.out.println("You win.");
		else if (userWord.equals("paper") && computerWord.equals("rock"))
			System.out.println("You win.");
		else
			System.out.print("You win.");
		
		in.close(); // Call closed.
	}
}
