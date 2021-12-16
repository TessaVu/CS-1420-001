/* This class is a program that uses a loop to output
 * the powers of two from 2^0 through 2^16, inclusive.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		10 September 2021
*/

package assignment03;

public class PowersOfTwo
{
	public static void main(String[] args)
	{
		int num = 2, exp = -1; // Num is the base integer, exp is the exponent.
				
		while (exp != 16) // As long as the exponent is NOT the number 16...
		{
			exp++; // Increment the exponent (i.e. add a unit successively).
			System.out.println((int)Math.pow(num, exp)); // Print the answer.
		}
	}
}
