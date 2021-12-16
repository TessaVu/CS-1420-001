/* This class is a program that, with the help of the
 * user's input, the area of a circle will be calculated.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		02 September 2021
*/

package assignment02;

import java.util.Scanner;

public class CircleArea
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Create a scanner object.
		
		System.out.print("Enter a number: "); // Ask for the user's input.
		
		double pi = Math.PI; // Declare variable for the value pi.
		
		double area, number; // Declare variable for the user's input and the area of a circle.
		
		number = input.nextDouble(); // Scan the user's input as a double.
		
		area = pi * Math.pow(number, 2); // Equation for the area of a circle.
		
		System.out.print("The area of a circle with radius " + number + " is " + area + "."); // Return the answer from the user's input.
		
		input.close(); // Call close.
	}
}
