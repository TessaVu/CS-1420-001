/* This class is a program that takes integers 1 to 255
 * from the user and converts them into binary format.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		02 September 2021
*/

package assignment02;

import java.util.Scanner;

public class Binary
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Create a scanner object.
		
		System.out.print("Enter a number: "); // Ask for the user's input.
				
		int num, n1, n2, n3, n4, n5, n6, n7, r1, r2, r3, r4, r5, r6, r7, r8; // Declare variable for the user's input and the area of a circle.
		
		num = (int)Math.random() * 256;
		num = input.nextInt(); // Scan the user's input as an integer.
		
		n1 = (num)/2; // Divide the user input by two.
		n2 = (n1)/2;
		n3 = (n2)/2;
		n4 = (n3)/2;
		n5 = (n4)/2;
		n6 = (n5)/2;
		n7 = (n6)/2;
		
		r1 = num%2; // Use the modulus to calculate the remainders.
		r2 = n1%2;
		r3 = n2%2;
		r4 = n3%2;
		r5 = n4%2;
		r6 = n5%2;
		r7 = n6%2;
		r8 = n7%2;
		
		System.out.print("The decimal number " + num + " is "); // Return the answer from the user's input.
		System.out.print(r8);
		System.out.print(r7);
		System.out.print(r6);
		System.out.print(r5);
		System.out.print(r4);
		System.out.print(r3);
		System.out.print(r2);
		System.out.print(r1);
		System.out.print(" in binary.");
		
		input.close(); // Call close.
	}
}
