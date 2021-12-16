/* This program analyzes the DataNames.txt
 * and gathers user input on how many loop
 * iterations to go through, then prints
 * the oldest cat and the fattest cat.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		18 September 2021
*/

package quiz01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AnalyzeData
{
	public static void main(String[] args) throws IOException
	{
		File filename = new File("DataNames.txt");
		Scanner file = new Scanner(filename); // Opens the file for reading (scanning).
		
		Scanner input = new Scanner(System.in); // Create a scanner object.
		
		System.out.print("Enter the number(s) of entry/entries: "); // Prompt user for input.
		
		int userInput = input.nextInt(); // Declare user input as an integer.
		
		String catBreed; // Declare the data in the DataNames.txt as a string for cat breeds.
		
		String oldestCatBreed = null; // Keep track of the oldest cat breed.
		int oldestCat = 0;
		
		String fattestCatBreed = null; // Keep track of the fattest cat breed.
		double fattestCat = 0;
		
		int count = 0; // Loop iteration tracker.
		
		while(count < userInput) // While the iteration is less than the user's input...
		{
			count++; // ...keep track of the loop iteration.
	        
			while(file.hasNext()) // While the text file has another line of data.
	        {	            
	            int catAge = (int)(Math.random() * 15); // The life span of cats is estimated to be around 15 years.
	    		double catWeight = (double)(Math.random() * 20); // The weight of cats can reach 20 pounds; depending on the breed, they can be considered healthy or overweight.
	            
	            catBreed = file.next(); // Scan the next word from the file.
	            
	            if(catAge > 0 && catWeight > 4 && catAge > oldestCat) // If the cat age is greater than 0, cat weight is greater than 4, and catAge is greater than oldestCat.
	            {
	                oldestCatBreed = catBreed; // Keep a copy of the oldest cat data.
	                oldestCat = catAge;
	            }
	            
	            if(catAge > 0 && catWeight > 4 && catWeight > fattestCat) // If the cat weight is greater than 0, cat weight is greater than 4, and catWeight is greater than fattestCat.
	            {
	            	fattestCatBreed = catBreed; // Keep a copy of the fattest cat data.
	                fattestCat = catWeight;
	            }
	            System.out.println("Entry name: " + catBreed + "\n" + "Entry age: " + catAge + "\n" + "Entry weight: " + catWeight); // Print the entry information.
	            
	            if(count == userInput) // If the iteration matches the user input...
	            	System.out.println(""); // New line.
	            	break; // ...break from the loop.
	        }
		}
        System.out.println("The oldest cat is a(n) " + oldestCatBreed + " that has an age of " + oldestCat + " years."); // Print the oldest cat breed and its age.
        System.out.println("The fattest cat is a(n) " + fattestCatBreed + " that has a weight of " + fattestCat + " pounds."); // Print the fattest cat breed and its weight.
        
        file.close(); // Close the file.
        input.close(); // Close the input.
	}
}