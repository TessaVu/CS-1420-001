/* ArrayExercises is a program with eight methods:
 * randomArray, reverseOrder, count, replace,
 * computeAreas, remove, sort, and findSmallest.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		25 October 2021
*/

/**
 * <p>
 * See below for requirements. Note that the JavaDoc comments below
 * (and this one) are formatted with HTML tags to create a nicer
 * view in the generated documentation.
 * </p>
 */
package assignment06;

/* Only import java.awt.Color and java.awt.Rectangle. */
import java.awt.Color;
import java.awt.Rectangle;
/* No other imports are allowed. */

/**
 * <p>
 * This class is a collection of static methods for processing arrays. There are
 * no fields or static variables, and none are allowed. (In other words, only
 * use variables declared inside each method.) You will not build ArrayExercises
 * objects. Instead, you'll just call (execute) the static methods in this
 * class, like this: ArrayExercises.sort(someArray)
 * </p>
 * 
 * <p>
 * This class is the starting point for programming assignment #6. Each method
 * has a contract, and you will write the statements inside each method to
 * exactly satisfy the contract. Note: Some methods indicate they might throw an
 * exception. You don't need to throw these exceptions -- I've anticipated what
 * exceptions will be thrown normally when incorrect parameters are passed to
 * the methods. (Don't add code to throw exceptions and don't prevent them from
 * being thrown.)
 * </p>
 * 
 * <p>
 * Note: None of the method contracts below says anything about files, user
 * input, or console printing. Don't prompt the user or ask for input. You may
 * print what you need to while testing, but all printing should be removed from
 * the code you submit.
 * </p>
 * 
 * <p>
 * When completing the lab or the assignment, students may not use any Java
 * library methods for working with arrays (sorting, searching, etc.). (Advanced
 * students must not use collections or equivalent structures.) You will write
 * equivalent code here instead.
 * </p>
 * 
 * @author Tessa Vu
 * @version 25 October 2021
 */

public class ArrayExercises
{
	/**
	 * <p>
	 * This method returns an array of size 'size' full of unique randomly ordered
	 * integers in the range [0...size). All integers in the range [0...size) will
	 * be in the array, but they will be in a shuffled order.
	 * </p>
	 * 
	 * <p>
	 * From Peter: This is an example array function that is more complex than all
	 * of the assignment problems. I am providing it to show you an interesting use
	 * of arrays as well as to show you how unit tests can be used to check
	 * correctness of methods and classes.
	 * </p>
	 * 
	 * @param size the number of array locations requested
	 * @return an array of the specified size filled with randomly ordered integers
	 */
	public static int[] randomArray(int size)
	{
		// Create an array of the requested size.
		int[] numbers = new int[size]; // If size is negative, this throws an exception.

		// Fill the array with the integers [0...size)
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = i; // Just store the index of each location in the location, not normally done.

		// Shuffle the array (starting from the right). For each position i, find a random position j, and swap elements at those positions.
		for(int i = numbers.length - 1; i > 0; i--)
		{
			// Pick a random location for j (but only to the left of i).
			// (Getting this wrong creates a bias - must do it as shown.)
			int j = (int)(Math.random() * (i + 1));

			// j = (int)(Math.random() * size); // This way is wrong - feel free to uncomment it to cause a JUnit test error.
			// Swap elements i and j in the array.
			int tempI = numbers[i];
			int tempJ = numbers[j];
			numbers[i] = tempJ;
			numbers[j] = tempI;
		}

		// Done. Feel free to uncomment the lines below to simulate errors.

		// numbers = new int[size + 1]; // This causes an error - the array size is wrong.
		// numbers[0] = -1; // This causes an error - a number is overwritten. I use it for testing my error code.
		
		return numbers;
	}

	/**
	 * <p>
	 * This method reverses 'in place' the elements in the array. Reversing is
	 * defined as moving the elements in the array such that the first element
	 * becomes the last element, the second element becomes the second to last
	 * element, the third element becomes the third to last element, etc.
	 * </p>
	 * 
	 * <p>
	 * This method does not have a return type - the list array is modified
	 * directly. In other words, the contents of the data array will be changed and
	 * the caller will see the changes.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #1 for programming assignment #6. </b>
	 * </p>
	 *
	 * <p>
	 * (Hint: Many students loop too far, and accidentally do and undo the
	 * reversal.)
	 * </p>
	 * 
	 * @param symbols An array that will be reversed.
	 */

	public static void reverseOrder(char[] symbols)
	{
		// Store character array symbols' length into integer length.
		int length = symbols.length;

		// If length is equal to 0...
		if(length == 0)
			return;

		// Declare integer position equal to 0; as long as position is less than half of length's length, increment position.
		for(int position = 0; position < (length / 2); position++)
		{
			// Store symbols at position into character i.
			char i = symbols[position];
			
			// Store symbols at length minus position minus 1 into symbols at position.
			symbols[position] = symbols[length - position - 1];
			
			// Store i in symbols at length minus position minus 1.
			symbols[length - position - 1] = i;
		}
	}

	/**
	 * <p>
	 * This method counts and returns how many times the target object occurs in the
	 * array. For this method, two objects are considered the same if they represent
	 * the same thing. In other words, use .equals().
	 * </p>
	 * 
	 * <p>
	 * Note: It is legal for the values array to contain a null object, and it is
	 * legal for the target to be null. No exception should be thrown in this case,
	 * and the correct count should be returned.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #2 for programming assignment #6. </b>
	 * </p>
	 *
	 * <p>
	 * (Hint: For testing, you can use Object arrays that you fill with Strings,
	 * Colors, or any other Object.)
	 * </p>
	 * 
	 * @param values An array of Object references
	 * @param target A target object
	 * @return The number of objects in the array that equal the target
	 * @throws NullPointerException If values is null
	 */
	
	public static int count(Object[] values, Object target)
	{
		// Declare integer count equal to 0.
		int count = 0;
		
		// Create object elements for every value in object array values.
		for(Object elements : values)
		{
			// If elements is not null and object target is not null...
			if(elements != null && target != null)
			{
				// If element's contents are equal to target's contents...
				if(elements.equals(target))
				{
					// ...increment count.
					count++;
				}
			}
			// Else if elements is null and target is null...
			else if(elements == null && target == null)
			{
				// ...increment count.
				count++;
			}
		}
		return count;
	}

	/**
	 * <p>
	 * This method examines the elements in the array and replaces all occurrences
	 * in the array of the original String with the replacement String. (The array
	 * contents are modified.)
	 * </p>
	 * 
	 * <p>
	 * For this method, two Strings are considered equal if they refer to the same
	 * object. (Use ==) Note that either the original String, the replacement
	 * String, or any of the Strings in the list may be null, and this is both
	 * allowed and expected on occasion.
	 * </p>
	 * 
	 * <p>
	 * This method does not have a return type - the list array is modified
	 * directly. In other words, the contents of the data array will be changed and
	 * the caller will see the changes.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #3 for programming assignment #6. </b>
	 * </p>
	 * 
	 * <p>
	 * Hint: If you have "Hello" and "Hello" in separate places in your code, note
	 * that Eclipse may choose to create a single String object for both of these
	 * "Hello" strings, and use it in both places that "Hello" exists. To get around
	 * this, use new String("Hello") if you want to guarantee the creation of a
	 * different String object.
	 * </p>
	 * 
	 * @param list        An array of String references
	 * @param original    The String reference to be replaced
	 * @param replacement The replacement String reference
	 * @throws NullPointerException If list is null
	 */
	
	public static void replace(String[] list, String original, String replacement)
	{
		// Declare variable position equal to 0; as long as position is less than list's length, increment position.
		for(int position = 0; position < list.length; position++)
		{
			// If string array list at position is equal to string original...
			if(list[position] == original)
			{
				// ...store string replacement into list at position.
				list[position] = replacement;
			}
		}
	}

	/**
	 * <p>
	 * This method computes and returns the area of several rectangular regions. The
	 * data is not stored in Rectangle objects. Instead, the data is stored in
	 * parallel arrays. (In parallel arrays, data at position i in each array is
	 * related to the data in the other arrays at position i:
	 * </p>
	 * 
	 * <p>
	 * For a rectangle i, width[i] specifies the width of the rectangle, and
	 * height[i] specifies the height of the rectangle.
	 * </p>
	 * 
	 * <p>
	 * A new array is created (that is the same size as the width and height arrays)
	 * and the area of each rectangle is computed and placed in this array. (Area of
	 * rectangle i would be stored in the ith position in the array.) The array is
	 * then returned.
	 * </p>
	 * 
	 * <p>
	 * This method assumes (but does not check) that the widths and heights are
	 * positive.
	 * </p>
	 * 
	 * <p>
	 * Note that width and height arrays must be the same size.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #4 for programming assignment #6. </b>
	 * </p>
	 * 
	 * @param widths  An array of rectangle widths
	 * @param heights An array of rectangle heights
	 * @return An array of rectangle areas
	 * @throws NullPointerException           If widths or heights is null
	 * @throws ArrayIndexOutOfBoundsException If widths or heights are not the same
	 *                                        size
	 */
	public static double[] computeAreas(double[] widths, double[] heights)
	{
		// Declare double array areas with size equal to double array widths' length.
		double[] areas = new double[widths.length];

		// If areas' contents are null...
		if(areas.equals(null))
		{
			return areas;
		}
		else
		{
			// Declare position equal to 0; as long as position is less than width's length, increment position.
			for (int position = 0; position < widths.length; position++)
			{
				// Store double array heights at position multiplied by widths at position into areas at position.
				areas[position] = heights[position] * widths[position];
			}
			return areas;
		}
	}

	/**
	 * <p>
	 * This method creates and returns a new array that contains all the colors
	 * stored in the original array, except those colors that are equal to the
	 * target. For this method, two colors are equal if they represent the same
	 * color.
	 * </p>
	 * 
	 * <p>
	 * Note that target may be null, and 'pixels' may contain null elements. Two
	 * null elements will be considered equal.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #6 for programming assignment #6. </b>
	 * </p>
	 * 
	 * <p>
	 * (Hint: Use Color.BLUE, Color.GREEN, etc. for testing.)
	 * </p>
	 * 
	 * @param pixels An array of Color references
	 * @param target The Color object to be removed
	 * @throws NullPointerException If pixels is null
	 */
	public static Color[] remove(Color[] pixels, Color target)
	{
		// If color array pixels is not null...
		if(pixels != null)
		{
			// ...create color array temp with size equal to pixels' length.
			Color[] temp = new Color[pixels.length];
			
			// Declare integer count equal to 0.
			int count = 0;
			
			// Declare integer position equal to 0; as long as position is less than pixels' length, increment position.
			for(int position = 0; position < pixels.length; position++)
			{
				// If pixels at position is null...
				if(pixels[position] == null)
				{
					// If color target is not null...
					if(target != null)
					{
						// ...store pixels at position into temp at incremented count.
						temp[count++] = pixels[position];
					}
				}
				// Else if pixels at position is not equal to contents of target...
				else if(!pixels[position].equals(target))
				{
					// ...store pixels at position into temp at incremented count.
					temp[count++] = pixels[position];
				}
			}

			// If count is equal to pixels' length...
			if(count == pixels.length)
			{
				return temp;
			}
			
			// Declare color array colors and set length equal to count.
			Color[] colors = new Color[count];
			
			// Declare integer position equal to 0; as long as position is less than count, increment position.
			for(int position = 0; position < count; position++)
			{
				// Store temp at position into colors at position.
				colors[position] = temp[position];
			}
			return colors;
		}
		return null;
	}

	/**
	 * <p>
	 * This method sorts the elements in the data array in descending order using
	 * selection sort (The largest element will be placed in position 0.)
	 * </p>
	 * 
	 * <p>
	 * Note that this method does not have a return type - the data array is sorted
	 * 'in place'. In other words, the contents of the data array will be changed
	 * and the caller will see the changes.
	 * </p>
	 * 
	 * <p>
	 * You must write a selection sort algorithm for this solution.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #7 for programming assignment #6. Your TA will help you
	 * with this problem during lab on October 5. </b>
	 * </p>
	 * 
	 * @param data The array to be sorted
	 * @throws NullPointerException If data is null
	 */
	public static void sort(int[] data)
	{
		// Declare integer i equal to 0; as long as i is less than integer array data's length, increment i.
		for(int i = 0; i < data.length - 1; i++)
		{
			// Declare integer max equal to i.
			int max = i;
			
			// Declare integer j equal to i plus 1; as long as j is less than data's length, increment j.
			for(int j = i + 1; j < data.length; j++)
			{
				// If data at j is greater than data at max...
				if(data[j] > data[max])
				{
					// Store j into max.
					max = j;
				}
			}
			// If max is not equal to i...
			if(max != i)
			{
				// ...declare integer temp equal to data at i.
				int temp = data[i];
				
				// Store data at max into data at i.
				data[i] = data[max];
				
				// Store temp into data at max.
				data[max] = temp;
			}
		}
	}

	/**
	 * <p>
	 * This method finds and returns the smallest rectangle in the array. The
	 * smallest rectangle is defined as the one with the smallest area. If two
	 * rectangles have the same smallest area, the one that occurs last in the array
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * This method requires that the rectangles array must not contain null.
	 * </p>
	 * 
	 * <p>
	 * <b> This is problem #8 for programming assignment #6. </b>
	 * </p>
	 * 
	 * <p>
	 * (Hint: Look up the documentation for the Rectangle class. You'll see how to
	 * extract the needed information from each Rectangle.)
	 * </p>
	 * 
	 * @param rectangles An array of rectangle objects
	 * @return The smallest rectangle in the array
	 * @throws NullPointerException If rectangles is null or rectangles contains
	 *                              null
	 */
	public static Rectangle findSmallest(Rectangle[] rectangles)
	{
		// Declare rectangle min equal to null.
		Rectangle min = null;
		
		// Declare double minArea equal to max value of double. 
		double minArea = Double.MAX_VALUE;
		
		// Create rectangle element for every value in rectangle array rectangles.
		for(Rectangle element : rectangles)
		{
			// If element is not null...
			if(element != null)
			{
				// ...declare double area equal to element's width and height multiplied.
				double area = element.getWidth() * element.getHeight();
				
				// If area is less than or equal to minArea...
				if(area <= minArea)
				{
					// ...store area into minArea.
					minArea = area;
					
					// Store element into min.
					min = element;
				}
			}
		}
		return min;
	}
}
