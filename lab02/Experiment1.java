package lab02;

public class Experiment1
{
	public static void main(String[] args)
	{
		/*****************
		 * Experiment #1 *
		 *****************/		
		// Create a random 'word' using random numbers. This will represent
		// a choice made by the computer.
		// Generate a random value, either 0, 1, or 2.
		int value = (int)(Math.random() * 3);
		
		/** Your work here -- fix the code so that it prints a 0, 1, or 2 randomly. **/
		System.out.println("Experiment #1: A random value: " + value);
		
		// This code converts the random value to a word. When it's working,
		// the computer word should be either 'rock', 'paper', or 'scissors' with 
		// equal probability. (Run it several times.)
		String computerWord = "No choice";
		
		if (value == 0)
			computerWord = "rock";
		else if (value == 1)
			computerWord = "paper";
		else if (value == 2)
			computerWord = "scissors";
		
		System.out.println("Experiment #1: The computer chose: " + computerWord);
	}
}
