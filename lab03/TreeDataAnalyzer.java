/* This class takes a .txt file and goes through
 * each line of text to find and print a statement
 * of what tree it is and what its count is, ending
 * with a statement declaring the tree type with
 * the most trees.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		07 September 2021
*/

package lab03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TreeDataAnalyzer
{

	public static void main(String[] args) throws IOException
	{
		File filename = new File("forest.txt"); // A file object just represents a path to a file
		Scanner file = new Scanner(filename); // Opens the file for reading (scanning)

		String treeName;
		int treeCount, count = 0;

		while (file.hasNext())
		{
			treeName = file.next(); // Use the scanner, scan the 'next' word from the file.
			treeCount = file.nextInt(); // Use the scanner, scan the 'next' int from the file.
			count++;
			System.out.println("Tree: " + treeName + " has a count of " + treeCount + ".");
		}

		file.close();
		
		// Reopen the file.  (Build a new Scanner, store it in our file
        // variable.  The new Scanner scans from the beginning of the file.)
        
        file = new Scanner(filename);
        
        // Create a few variables for keeping track of the 'best' tree
        // found so far.
        
        String bestTreeName = null;
        int bestTreeCount = 0;
        
        // Loop, read in values, attempt to find the tree with the 
        // highest count.
        
        int loopCount = 0;
        while (file.hasNext())
        {
            // Advance the counter.
            
            loopCount++;
            
            // Read in the data
            
            treeName = file.next(); // Use the scanner, scan the 'next' word from the file.
            treeCount = file.nextInt(); // Use the scanner, scan the 'next' int from the file. 
            
            // If it's the first tree, or if the current tree count
            // is higher than the best one found so far, keep it.
            
            if (loopCount == 1 || treeCount > bestTreeCount)
            {
                // We've just read in the best tree so far.  Keep a copy
                // of it's data.
                
                bestTreeName = treeName; 
                bestTreeCount = treeCount;
            }
            
            // Loop end.
        }
        
        // Print out the tree with the highest count.
        
        System.out.println("'Best' tree: " + bestTreeName + " has a count of " + bestTreeCount + ".");        

        // Close the file.
        
        file.close();

	}

}
