/* This class is a program that prompts the user
 * for an input and displays a dialog box to the
 * target folder for the user to select from, then
 * recursively lists all the files within the search
 * folder.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		21 September 2021
*/

package lab04;

// Import necessary libraries below.
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileLocator
{
	public static void main(String[] args)
	{
		try // Try catch block to locate exceptions.
		{
			System.out.println("File locator tool has started."); // Notify user that the tool started.
	
			String target = getTargetName(); // Call getTargetName method.
	
			System.out.println ("You selected this as the search target: " + target); // Notify user their selection.
			
			File startingFolder;
			startingFolder = getStartingFolder(); // Call getStartingFolder method.

			System.out.println ("Your search will start in: " + startingFolder); // Notify user where their search starts.
			
			searchFolder(startingFolder, target); // Call searchFolder method.
		}
		catch(IllegalArgumentException e) // Catch invalid arguments.
		{
			System.out.println("The search has been cancelled."); // Notify user the search was cancelled.
		}
	}
	
	public static String getTargetName() // Method to display a GUI box for user to input part of a file name. The input will be returned as a string.
	{
		String input = JOptionPane.showInputDialog("Enter a search term:"); // Display GUI dialog box for user input.
		
		if (input == null) // If the input is null...
		    throw new IllegalArgumentException(); // ...throw the exception.
		if (input.length() == 0) // If the input length is 0...
			throw new IllegalArgumentException(); // ...throw the exception.
		
		return input; // Return the input as a string.
	}
	
	public static File getStartingFolder() // Method to display a GUI box for user folder selection. The selection, a file object, will be returned.
	{
		JFileChooser chooser = new JFileChooser("C:\\Users\\vutes\\eclipse-workspace\\CS1420-001"); // Search will default to the CS1420-001 Eclipse folder.
		
		chooser.setDialogTitle("Select a folder to search"); // Prompt user to search a folder.
		
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Show directories.
		
		chooser.showOpenDialog(null);
		
		int result;
		result = chooser.showOpenDialog(null);
		        
		if (result == JFileChooser.CANCEL_OPTION) // If the result is cancelled...
		{
			throw new IllegalArgumentException(); // ...throw the exception.
		}
		
		File folder = chooser.getSelectedFile(); // Initiate a variable to hold the chosen folder.
		
		return folder; // Return the folder chosen by user.
	}
	
	public static void searchFolder(File folder, String target) // Method will recursively search user folder for a file name containing the target string. Once found, the file path is printed and will print the files that match the target name. There is no return value.
	{
		System.out.println("Searching: " + folder + " for filenames containing '" + target + "'."); // Print the folder being searched and the user target string.
		
		File[] files;
		files = folder.listFiles();
		
		if(files != null) // If the files are not null...
			for (File file : files) // Loop through the files.
			{
				String filename = file.getName(); // Acquire the file name.
			    if (filename.contains(target)) // If the file name contains the target string.
			    	System.out.println("Found: " + file.getName()); // Print the found files.
			    
			    if (file.isDirectory()) // Look through sub-folders.
			        searchFolder (file, target);
			}
	}
}