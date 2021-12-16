/* This class is a program that is related to the
 * Collatz conjecture, which states that eventually
 * the series will converge to one no matter what
 * starting positive integer is chosen.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		10 September 2021
*/

package assignment03;

import java.util.Scanner;

public class Hailstone
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: "); // Prompt user for input.

		int N = 0; // Allow user input for N, the starting integer of the Hailstone sequence.
		int X = 0; // Iteration tracker.
		
		boolean inputOK = false;
		
		while(!inputOK) // Loop as long as the user input is not okay.
		{
			N = input.nextInt();
			
			if(N > 0) // If N is greater than 1, the boolean is true.
				inputOK = true;
			
			System.out.print("Enter an integer: "); // Prompt user for input.
		}
		
		while(N > 1) // While N is greater than 1 (exclusive)...
		{
			System.out.print(N + " ");

			if(N % 2 == 0) // If the current integer N is even, the next number is computed as N / 2.
			{
				N = (N / 2);
			}
			else
			{
				N = (3 * N + 1); // If the current integer N is odd, the next number is computed as (N * 3) + 1.
			}
			X++; // Increment the iteration.
		}
		System.out.println(N);

		System.out.print("This sequence took " + X + " iterations."); // Print results.

		input.close();
	}
}
