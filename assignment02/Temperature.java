/* This class is a program that calculates and converts
 * Fahrenheit temperature to Celsius temperature given
 * the Fahrenheit temperature from the user's input.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		02 September 2021
*/

package assignment02;

import java.util.Scanner;

public class Temperature
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Create a scanner object.
		
		System.out.print("Enter the Fahrenheit temperature as an integer: "); // Prompt the user's input.
				
		int celsius, fahrenheit; // Declare variable for Celsius and the user's Fahrenheit input.
		
		fahrenheit = input.nextInt(); // Scan the user's input as an integer.
		
		celsius = ((5 * (fahrenheit - 32)) / 9); // Equation for converting degrees Fahrenheit to degrees Celsius.
		
		System.out.print(fahrenheit + " degree(s) Fahrenheit is equal to " + celsius + " degree(s) Celsius."); // Return the answer from the user's input.
		
		input.close(); // Call close.

	}

}
