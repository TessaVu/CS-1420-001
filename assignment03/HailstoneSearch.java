/* This class is a program that prompts the user,
 * asking for a sequence length, then prints out
 * the smallest positive starting integer such
 * that the Hailstone sequence for the integer
 * takes exactly the user inputed iterations.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		10 September 2021
*/

package assignment03;

import java.util.Scanner;

public class HailstoneSearch
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an iteration: "); // Prompt user for input.

		int X = input.nextInt(); // Iteration input.
		
		int count = 0; // Iteration tracker.
		
		int startingN = 1; // Start startingN at 1, increment later to 2.
		
		while(startingN < 1001 && count < X) // While startingN is less than 1001 (exclusive) and count is less than X.
		{			
			startingN++; // Increment startingN to 2.
			
			int loopCount = count;
			
			int N = startingN;
			
			while(N > 1) // While N is greater than 1 (exclusive).
			{
				loopCount++; // Increment loopCount.
				
				if(N % 2 == 0) // If the current integer N is even, the next number is computed as N / 2.
				{
					N = (N / 2);
				}
				else
				{
					N = (3 * N + 1); // If the current integer N is odd, the next number is computed as (N * 3) + 1.
				}
			}
			if(loopCount != X) // If loopCount (the iteration tracker) is not equal to X (the input iteration).
			{
				continue; // Loop again.
			}
			else if(loopCount == X) // Else if loopCount (the iteration tracker) is equal to X (the input iteration).
			{
				System.out.print("The Hailstone sequence starting at " + startingN + " takes " + X + " steps to converge to 1."); // Print the results.
				break; // Break from the loop.
			}
		}
		input.close(); // Close the scanner.
	}
}
