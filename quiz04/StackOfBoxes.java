/* This class is a program that is a stack of
 * Box objects, which has accessors, mutators,
 * and a method to remove a Box object.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		09 December 2021
*/

package quiz04;

public class StackOfBoxes
{
	// Field.
	private Box topBox;
	
	/**
	 * Constructor that initializes the top box.
	 * 
	 * @param None.
	 * @return None.
	 */
	public StackOfBoxes()
	{
		topBox = null;
	}
	
	/**
	 * Method that gets the top box.
	 * 
	 * @param None.
	 * @return Box.
	 */
	public Box getTop()
	{
		return topBox;
	}
	
	/**
	 * Method that adds a box.
	 * 
	 * @param reference.	A Box object.
	 * @return None.
	 */
	public void addBox(Box reference)
	{
		// Put current boxes under the parameter's box.
		// Use .setUnder() method.
		reference.setUnder(topBox);
				
		// Set the parameter's box object as the top box.
		topBox = reference;
	}
	
	/**
	 * Method that removes a box.
	 * 
	 * @param None.
	 * @return Box.
	 */
	public Box removeBox()
	{
		// Temporarily hold a copy of the reference to the top box.
		Box tempTop = topBox;
		
		// Change the top box to the box under the top box.
		// Use .setUnder() method.
		topBox = tempTop.setUnder(topBox.getUnder());
		
		// Return the reference to the previous top box.
		return tempTop;
	}

	/**
	 * Method that retrieves the height of a box.
	 * 
	 * @param None.
	 * @return int.		A measurement of the box.
	 */
	public int getHeight()
	{
		// The height of a stack of boxes is just the height of the top box, if any.
		
		return 0;
	}
}
