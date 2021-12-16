/**
 * A ResourceLoader object acquires from the resources
 * folder items like images and paths, holding them in
 * image HashMaps and path HashMaps respectively for
 * use.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class ResourceLoader
{
	// Fields.
	private static ResourceLoader loader = null; // Declare and assign ResourceLoader loader to null.
	private HashMap<String, BufferedImage> imageMap; // Declare HashMap imageMap to hold BufferedImages.
	private HashMap<String, Path> pathMap; // Declare HashMap pathMap to hold Paths.
	
	/**
	 * Constructor that initializes the HashMaps for images and paths.
	 * 
	 * @param None.
	 * @return None.
	 */
	private ResourceLoader()
	{
		imageMap = new HashMap<>();
		pathMap = new HashMap<>();
	}
	
	/**
	* This method gets the resource loader object.
	* 
	* @param None.
	* @return None.
	*/
	static public ResourceLoader getLoader()
	{
		if(loader == null) // If loader is null...
			loader = new ResourceLoader(); // ...Create a new ResourceLoader named loader.
		return loader;
	}
	
	/**
	 * This method returns a BufferedImage given the file name as a String.
	 * 
	 * @param s		A String set up by the caller to provide the file name.
	 * @return BufferedImage
	 */
	public BufferedImage getImage(String s)
	{
		BufferedImage image = imageMap.get(s); // Declare and assign BufferedImage image to the given file name in the imageMap.
		
		if(image == null) // If image is null... (Checks if specified image has already loaded.)
		{
	    	try
	    	{
		    	ClassLoader loader = this.getClass().getClassLoader();
		    	InputStream is = loader.getResourceAsStream("resources/" + s); // Input the file path, appending the user input to "resources/".
		    	image = javax.imageio.ImageIO.read(is);
		    	imageMap.put(s, image);
	    	}
	    	catch (IOException e) // Catch an IOException.
	    	{
	    		System.out.println("Could not load the backdrop or path."); // Print out an error message.
	    	}
		}
		return image; // Return newly loaded or existing image.
	}
	
	/**
	 * This method builds a Path object given the file name as a String.
	 * 
	 * @param s		A String set up by the caller to provide the file name.
	 * @return Path
	 */
	public Path getPath(String s)
	{
		Path path = pathMap.get(s); // Declare and assign Path path to the given file name in the pathMap.
		
		if(path == null) // If path is null... (Checks if specified path has already loaded.)
		{
			try
	    	{
				ClassLoader loader = this.getClass().getClassLoader();
		    	Scanner pathScanner = new Scanner(loader.getResourceAsStream("resources/" + s)); // Input the file path, appending the user input to "resources/".
		    	path = new Path(pathScanner);
	    	}
	    	catch (IOException e) // Catch an IOException.
	    	{
	    		System.out.println("Could not load the backdrop or path."); // Print out an error message.
	    	}
		}
		return path; // Return newly loaded or existing path.
	}
}
