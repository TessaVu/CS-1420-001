/** Finds all the palindromes in Sherlock.txt.
 *  Unfortunately, there weren't any interesting ones, so
 *  I manually added a few to the text file.  ;)
 *  
 *  Peter Jensen
 *  September 15, 2021
 */
package assignment5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Palindromes 
{
    /**
     * Application entry point
     * 
     * @param args unused
     */
	public static void main(String[] args) 
	{
		// The 'try' 'catch' blocks are used to handle
		// exceptions -- the file not existing is an 'exceptional'
		// situation.
		try
		{
			Scanner in = new Scanner(new File("Sherlock.txt"));
			
			while (in.hasNext())
			{
				String word = in.next();
				
				word = word.toLowerCase();
				
				if (isPalindrome(word))
				    System.out.println(word);
			}
			
			in.close();
		}
		catch (IOException e)
		{
			System.out.println("File not found, doofus.");
			return;  // End main right away
		}
	}

	/**
	 * Returns true if the word is a palindrome, false otherwise.
	 * 
	 * @param w
	 * @return
	 */
	public static boolean isPalindrome (String w)
	{
		//System.out.println(w);
		
		// Base case (should be first)
		
		if (w.length() < 2)
			return true;
		
		// Reduction step.
		
		if (w.charAt(0)  !=  w.charAt(w.length() - 1))
		    return false;
		
		// Might be a palindrome...
		
		String smallerString = w.substring(1, w.length() - 1);
		
		boolean smallerIsPalindrome = isPalindrome(smallerString);
		
		return smallerIsPalindrome;
		
	}
}
