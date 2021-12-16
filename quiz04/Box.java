/* This class is a program that 
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		09 December 2021
*/

package quiz04;

public class Box
{
	// Fields.
	private Object thing; // Contents of the box.
	private Box underMe; // Refers to the box under this one.
	
	/**
	 * Constructor that initializes the thing and the box under.
	 * 
	 * @param thing.		An Object that refers to the thing inside the box.
	 * @return None.
	 */
	public Box(Object thing)
	{
		this.thing = thing;
		
		// When a box is made, there is no box under it.
		underMe = null;
	}
	
	/**
	 * Method that returns what is inside the box, or the thing.
	 * 
	 * @param None.
	 * @return Object.
	 */
	public Object getThing()
	{
		return thing;
	}
	
	/**
	 * Method that returns what is under the current box.
	 * 
	 * @param None.
	 * @return Box.
	 */
	public Box getUnder()
	{
		return underMe;
	}
	
	/**
	 * Method that sets the box under the current box.
	 * 
	 * @param newUnder.		A Box object.
	 * @return Box.
	 */
	public Box setUnder(Box newUnder)
	{
		return underMe = newUnder;
	}
	
	/**
	 * Method that retrieves the height of a box.
	 * 
	 * @param None.
	 * @return int.		A measurement of the box.
	 */
	public int getHeight()
	{
		// A single box (a box with a null 'underMe') is defined to have a height of 1.
		// If there are boxes under the current one, the height of the current box is
		// 1 + the height of the box under the current box.
		
		
		return 0;
	}
}
