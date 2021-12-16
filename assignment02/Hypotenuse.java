/* This class is a program that calculates the
 * hypotenuse of a right triangle, given the
 * length of two sides provided by the user's input.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		02 September 2021
*/

package assignment02;

import java.util.Scanner;

public class Hypotenuse
{
	public static void main(String[] args)
	{
		Scanner inputA = new Scanner(System.in); // Create a scanner object for side A.
		
		double hypotenuse, numberA, numberB; // Declare variables for the hypotenuse of a right triangle and for the user's sides inputs.
		
		System.out.print("Enter a number for side A: "); // Ask for the user's side A input.
		
		numberA = inputA.nextDouble(); // Scan the user's side A input as a double.
		
		Scanner inputB = new Scanner(System.in); // Create a scanner object for side B.
		
		System.out.print("Enter a number for side B: "); // Ask for the user's side B input.
		
		numberB = inputB.nextDouble(); // Scan the user's side B input as a double.
		
		hypotenuse = Math.sqrt(Math.pow(numberA, 2) + Math.pow(numberB,  2)); // Equation for the Pythagorean Theorem, solved for C.
		
		System.out.print("The hypotenuse of a right triangle with side A " + numberA + " and side B " + numberB + " is " + hypotenuse + "."); // Return the answer from the user's input.
		
		inputA.close(); // Call close.
		inputB.close();
	}
}
