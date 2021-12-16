/* This class is a program that 
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		09 December 2021
*/

// Create a 'Box' class that holds a reference to some object
// (the thing in the box).

// Create a 'StackOfBoxes' class that represents a single stack
// of Box objects.

// Create a small program (main method) to test and debug it.

package quiz04;

public class StackTest
{
	public static void main(String[] args)
	{
		// Test 1
		// Write a test that creates a stack.
		// When making Box objects, put unique text strings in each box (no duplicates).
		StackOfBoxes theStack = new StackOfBoxes();
		
		// Add three different boxes to the stack.
		Box boxOne = new Box("One");
		theStack.addBox(boxOne);
		
		Box boxTwo = new Box("Two");
		theStack.addBox(boxTwo);
		
		Box boxThree = new Box("Three");
		theStack.addBox(boxThree);
		
		// Remove one box from the stack, print out its thing.
		System.out.println(theStack.removeBox().getThing() + "\n"); // Should print "Three".
		
		// Add two more boxes to the stack.
		Box addOne = new Box("Added One");
		theStack.addBox(addOne);
		
		Box addTwo = new Box("Added Two");
		theStack.addBox(addTwo);
		
		// Remove all four boxes from the stack. As each box is removed, print out it's thing.
		// (Don't reorder the printing -- print out each thing as its enclosing box is removed.)
		System.out.println(theStack.removeBox().getThing()); // Should print "Added Two".
		System.out.println(theStack.removeBox().getThing()); // Should print "Added One".
		System.out.println(theStack.removeBox().getThing()); // Should print "Two".
		System.out.println(theStack.removeBox().getThing()); // Should print "One".
		
		// Test 2
		// Add additional code to StackTest to create a second stack of boxes. (Do not remove your other test.)
		// Use a loop to add a whole bunch of boxes. (Not too many -- make sure the program finishes in less than a second.)
		// Once you have built the second stack, print out its height by calling the getHeight function on the StackOfBoxes.
		// (Use a nice message to make it easy for us to check your output.)
		
		
	}
}