/* FractionRoot is a program that takes
 * the square root of a user's fraction
 * input by using Newton's method.
 * 
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		04 October 2021
*/

package assignment05;

import java.util.Scanner;

public class FractionRoot
{
	public static void main(String[] args)
	{
		System.out.print("Enter a numerator: "); // Prompt the user for the numerator.
		Scanner numInput = new Scanner(System.in); // Store the user input into numInput.
		
		long numFinal = numInput.nextLong(); // Store the user numerator as a long.
		
		System.out.print("Enter a denominator: "); // Prompt the user for the denominator.
		Scanner denInput = new Scanner(System.in); // Store the user input into denInput.

		long denFinal = denInput.nextLong(); // Store the user denominator as a long.
		
		Fraction S = new Fraction(numFinal, denFinal); // Create a Fraction object from user input.
		
		System.out.println("\nYou entered: " + S); // Print the user's fraction.
		
		System.out.print("\nEnter an approximation count: "); // Prompt the user for an approximation (iteration) count.
		Scanner appInput = new Scanner(System.in); // Store the user input into appInput.
		
		int Z = appInput.nextInt(); // Store the user approximation count as an integer.
		
		Fraction half = new Fraction(1, 2); // Fraction 1/2.
		Fraction currentX = S.multiply(half); // Fraction S/2.
		Fraction nextX; // Fraction to store next iterative fraction value.
				
		for(int i = 0; i < Z; i++) // Declare i as 0. Loop and increment i as long as i is less than or equal to Z, the user's approximation count.
		{
			nextX = half.multiply((currentX.add((S.divide(currentX))))); // nextX = (1/2)(currentX + (S / currentX)), with currentX at the 0th iteration being S/2.
			
			currentX = nextX; // Set currentX equal to nextX.
		}
		
		// Print out the user's fraction and the square root estimate (as a fraction).
		System.out.println("\nThe square root of " + S + " is approximately " + currentX + ".");
	}
}