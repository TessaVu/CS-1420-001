/**
 * Path objects represent the path of travel for the adversaries in 
 * our Tower Defense game. A path is just a series of sequential
 * line segments. A game object's position on the path is specified
 * by a 'percentage', or amount of the path that has been completed.
 * The start of the path is 0% completed, the end of the path is 100%
 * completed. (The range is 0.0 to 1.0 as a double.)
 * 
 * This class was completed as part of checkpoint #1. (You shouldn't
 * need to change it.)
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Path
{
	// Declare parallel arrays for storing x and y values in the coordinates.
	// Declare an integer array x to store x values in the coordinates.
	private int[] x;
	
	// Declare an integer array x to store y values in the coordinates.
	private int[] y;
	
	// Declare a double array distances to store the distances.
	private double[] distances;
	
	// Declare a double pathLength to return the length of the drawn path.
	private double pathLength;

	/**
	 * This constructor does the following: - It reads a number of coordinates, n,
	 * from the scanner. - It creates new array(s) (or an ArrayList) to hold the
	 * path coordinates, and stores it in the field in 'this' object. - It loops n
	 * times, each time scanning a coordinate x,y pair, creating an object to
	 * represent the coordinate (if needed), and stores the coordinate in the
	 * array(s) or ArrayList.
	 * 
	 * @param s		A Scanner set up by the caller to provide a list of coordinates
	 * @throws FileNotFoundException
	 */
	public Path(Scanner s) throws FileNotFoundException
	{
		// Declare integer n to store the number/size of coordinates from the path.txt file with the scanner.
		int n = s.nextInt();

		// Declare tracking integers i and j and set as 0.
		int i = 0;
		int j = 0;

		// Initialize the global x and y arrays as new integer arrays with length of n.
		this.x = new int[n];
		this.y = new int[n];
		
		// Initialize the global distances array as a new double array with length of n.
		distances = new double[n];
		
		// While the file has another integer...
		while(s.hasNextInt())
		{
			// ...increment the position of array x and set it as the next scanned integer.
			x[i++] = s.nextInt();
			
			// Increment the position of array x and set it as the next scanned integer.
			y[j++] = s.nextInt();
		}

		// Restart i to 0, and as long as it is less than x's length minus 1, increment i.
		for(i = 0; i < x.length - 1; i++)
		{
			// Set up variables for the Pythagorean Theorem.
			// Declare integer x1 and set its position to i, and declare integer x2 and set its position to i plus 1.
			int x1 = x[i];
			int x2 = x[i + 1];
			
			// Declare integer y1 and set its position to i, and declare integer y2 and set its position to i plus 1.
			int y1 = y[i];
			int y2 = y[i + 1];
			
			// Initializing the above variables like so is to make sure the values alternate.
			
			// Use the Pythagorean Theorem to calculate the path length.
			pathLength += Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
			
			// Store the path length into the distances array at i plus 1.
			distances[i + 1] = pathLength;
		}
	}

	/**
	 * Draws the current path to the screen (to wherever the graphics object points)
	 * using a highly-visible color.
	 * 
	 * @param g		A graphics object.
	 */
	public void draw(Graphics g)
	{
		// Declare integer i equal to 0, as long as it is less than x's length minus 1, increment i.
			// Stop one position early to avoid going out of bounds.
		for(int i = 0; i < x.length - 1; i++)
		{
			// Draw the line segment with x[i] and y[i] being the first set of coordinates and the latter two being the second set of coordinates.
			g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
		}
	}

	/**
	 * Returns the total length of the path. Since the path is specified using
	 * screen coordinates, the length is in pixel units (by default).
	 * 
	 * @return The length of the path.
	 */
	public double getPathLength()
	{
		// Accessor/Getter function for the path length.
		return pathLength;
	}

	/**
	 * Given a percentage between 0% and 100%, this method calculates the location
	 * along the path that is exactly this percentage along the path. The location
	 * is returned in a Point object (integer x and y), and the location is a screen
	 * coordinate.
	 * 
	 * If the percentage is less than 0%, the starting position is returned. If the
	 * percentage is greater than 100%, the final position is returned.
	 * 
	 * If students don't want to use Point objects, they may write or use another
	 * object to represent coordinates.
	 *
	 * Caution: Students should never directly return a Point object from a path
	 * list. It could be changed by the outside caller. Instead, always create and
	 * return new point objects as the result from this method.
	 * 
	 * @param percentTraveled	A distance along the path.
	 * @return The screen coordinate of this position along the path.
	 */
	public Point getPathPosition(double percentTraveled)
	{
		// If the percent traveled is less than or equal to 0...
		if(percentTraveled <= 0)
		{
			// ...return a new point at coordinates (0, 0).
			return new Point(x[0], y[0]);
		}
		
		// If the percent traveled is greater than or equal to 1...
		if(percentTraveled >= 1)
		{
			// ...return a new point at coordinates using x and y arrays at their lengths minus 1.
			return new Point(x[x.length - 1], y[y.length - 1]);
		}
		
		// Declare a double distance that stores the length of the path multiplied by the percent traveled.
		double distance = pathLength * percentTraveled;
		
		// Declare integer i equal to 1, and as long is it is less than distances' length, increment i.
		for(int i = 1; i < distances.length; i++)
		{
			// If the absolute value of distances at i minus distance is less than 0.01...
			if(Math.abs(distances[i] - distance) < 0.01)
			{
				// ...return a new point at x and y at i.
				return new Point(x[i], y[i]);
			}
			
			// If distances at i is greater than distance...
			if(distances[i] > distance)
			{
				// ...declare double pointToPoint to store distances at i minus distances at i minus 1.
				double pointToPoint = distances[i] - distances[i - 1];
				
				// If pointToPoint is equal to 0...
				if(pointToPoint == 0)
				{
					// ...return a new point x and y at position i.
					return new Point(x[i], y[i]);
				}
				
				// Declare double ratio and store the ratio, or percentage, through the path.
				double ratio = (distance - distances[i - 1]) / pointToPoint;
				
				// Approximate the x value as a double.
				double x = (this.x[i - 1] * (1 - ratio)) + (this.x[i] * ratio);
				
				// Approximate the y value as a double.
				double y = (this.y[i - 1] * (1 - ratio)) + (this.y[i] * ratio);
				
				// Return a new point at x and y variables above.
				return new Point((int) x, (int) y);
			}
		}
		return null;
	}
}
