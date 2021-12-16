/* This program scans through the DataNames.txt file of
 * cat breeds then randomly picks an integer for the cat
 * age and randomly picks a double for the cat weight.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		18 September 2021
*/

package quiz01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GenerateData
{
	public static void main(String[] args) throws IOException
	{
		File filename = new File("DataNames.txt");
		Scanner file = new Scanner(filename); // Opens the file for reading (scanning).
		
		String catBreed; // Declare the data in the DataNames.txt as a string for cat breeds.
		
		while (file.hasNext()) // While the text file has another line of data...
		{
			int catAge = (int)(Math.random() * 15); // The life span of cats is estimated to be around 15 years.
			double catWeight = (double)(Math.random() * 20); // The weight of cats can reach 20 pounds; depending on the breed, they can be considered healthy or overweight.
			
			catBreed = file.next(); // Scan the next word from the file.
			
			if(catAge > 0 && catWeight > 4) // This program is not including kittens of cat breeds, so the if statement is restricting ages less than a year and weights less than 5 pounds.
				System.out.println(catBreed + " " + catAge + " " + catWeight); // Print the breed, age (integer), and weight (double).
			
			else // If the cat age and weight are not within the if statement's condition...
			{
				continue; // ...repeat the loop.
			}
		}
		file.close(); // Close the file.
	}
}
