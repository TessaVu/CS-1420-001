/* Rectangle is a class used to
 * create a rectangle object with integers
 * length, width, height, as well as double
 * weight. It has methods that computes the
 * surface area and volume, and a mutator
 * to alter the fourth field.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		08 October 2021
*/

package quiz02;

public class RectangleQuiz
{
	// PRIVATE VARIABLES.
	private int length;
	private int width;
	private int height;
	private double weight;
	
	// CONSTRUCTOR.
	public RectangleQuiz(int l, int w, int h, double wt) // Parameters are standard rectangle dimensions and weight.
	{
		this.length = l;
		this.width = w;
		this.height = h;
		this.weight = wt;
	}
	
	// METHODS.
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object.
	 * Postconditions: Returns a String.
	 * Used to print out a string of the fields in a Rectangle object.
	 * @param None
	 * @return String
	 */
	public String toString()
	{
		return "Dimensions: " + this.length + " x " + this.width + " x " + this.height + "\nWeight: " + this.weight; // Return measurements as standard order L (length) x W (width) x H (height) as well as the weight.
	}
	
	// ACCESSORS.
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object.
	 * Postconditions: Returns an integer.
	 * Used to get the length of a Rectangle object.
	 * @param None
	 * @return int
	 */
	public int getLength()
	{
		return this.length; // Return length of rectangle.
	}
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object.
	 * Postconditions: Returns an integer.
	 * Used to get the width of a Rectangle object.
	 * @param None
	 * @return int
	 */
	public int getWidth()
	{
		return this.width; // Return width of rectangle.
	}
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object.
	 * Postconditions: Returns an integer.
	 * Used to get the height of a Rectangle object.
	 * @param None
	 * @return int
	 */
	public int getHeight()
	{
		return this.height; // Return height of rectangle.
	}
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object.
	 * Postconditions: Returns an integer.
	 * Used to get the weight of a Rectangle object.
	 * @param None
	 * @return double
	 */
	public double getWeight()
	{
		return this.weight; // Return weight of rectangle.
	}
	
	// MUTATOR.
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object and the parameter must be a double.
	 * Postconditions: Alters the weight of a Rectangle object.
	 * Used to change/set the weight of a Rectangle object.
	 * @param None
	 * @return None
	 */
	public void setWeight(double wt)
	{
		this.weight = wt; // Changes the fourth property.
	}
	
	// SURFACE AREA.
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object and the parameter must also be a Rectangle object.
	 * Postconditions: Returns the surface area value.
	 * Used to calculate the surface area of a Rectangle object, computed as a six-sided rectangular solid.
	 * @param RectangleQuiz object
	 * @return int
	 */
	public int surfaceArea(RectangleQuiz rectSA)
	{
		int resultSA = 2 * ((this.length * this.width) + (this.height * this.width) + (this.height * this.length));
		
		return resultSA;
	}
	
	// VOLUME.
	
	/**
	 * Preconditions: Variable referenced must be a Rectangle object and the parameter must also be a Rectangle object.
	 * Postconditions: Returns the volume value.
	 * Used to calculate the volume of a Rectangle object, computed as a rectangular solid.
	 * @param RectangleQuiz object
	 * @return int
	 */
	public int volume(RectangleQuiz rectV)
	{
		int resultV = (this.length * this.width * this.height);
		
		return resultV;
	}
}