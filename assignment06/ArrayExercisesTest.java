/* ArrayExercisesTest is a JUnit testing
 * program to test ArrayExercises' methods
 * with a variety of cases.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		25 October 2021
*/

package assignment06;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Random;

// Imports for JUnit 4 (currently unused)

// import static org.junit.Assert.*;
// import org.junit.Test;

// Imports for JUnit 5

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */

public class ArrayExercisesTest
{
	/*
	 * This is my first example unit test. A unit test is just a piece of code that
	 * calls some method or builds some object, and tests for errors. The code/test
	 * is up to the programmer.
	 * 
	 * The unit test library provides functions for 'asserting' correctness. I use
	 * assertEquals below. If the two values are not equal, the unit test library
	 * records a failure.
	 * 
	 * There are other assert functions in the unit test library that are useful for
	 * noting errors. If the function below completes without recording a failure,
	 * then the test is marked as a success.
	 */

	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.

		int[] result;
		int size = 30;

		result = ArrayExercises.randomArray(size); // This calls the function I'm testing.

		// The function has a specific contract that guarantees things
		// about its' return value. Check to make sure the method
		// call did what it was supposed to.

		// Make sure the size of the result array is correct.

		assertEquals(size, result.length); // If unequal, an error is recorded.
//		if (size != result.length)
//			fail();
//		return;

		// Make sure the required numbers [0...n-1] are in the array.

		numberLoop: for (int n = 0; n < size; n++) // Notice that I labeled this loop
		{
			// Search for n in the array. When found, move on to the next n.

			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop; // Found it, continue the outer loop. (I have not shown this yet.)

			// If we get this far, the number n was not found. This is an error.

			fail("Number missing from random array: " + n + " in " + Arrays.toString(result)); // Record an error
		}

		// If the number loop completes without failing, all tests pass!
		// (When this method ends normally, the test is marked as passing.)
	}

	/*
	 * I wanted two unit tests for my function. The first one, above, just makes
	 * sure the basic operation of 'randomArray' is correct. This second unit test
	 * makes sure the 'randomness' is correct. A truly random shuffle has equal
	 * likelihood of any outcome. I repeatedly generate random arrays, then I count
	 * up results, and then check to make sure that each outcome occurred with
	 * similar probability.
	 * 
	 * Because of the fact that random numbers may produce results that look uneven,
	 * I loop many times to reduce the likelihood of random results looking like an
	 * error.
	 * 
	 * I do not expect students to study this code - it is poor code. (I don't like
	 * the way I'm counting permutations.) There are better ways, but you haven't
	 * seen the required lectures yet, so I'm using a more primitive solution. I
	 * expect your unit tests to be much less complex.
	 */

	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.

		// Counts of how many times each permutation appears.

		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;

		// Repeatedly generate arrays (1,000,000 times).

		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.

			int[] result = ArrayExercises.randomArray(3); // This calls the function I'm testing.

			// Keep counts of each permutation in the array.

			if (result[0] == 0 && result[1] == 1) // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2) // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0) // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2) // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0) // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}

		// Check each permutation. It should occur 166,666 times on average. Accept
		// anything within +/- 3,000.

		if (Math.abs(166_666 - count012) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012);

		if (Math.abs(166_666 - count021) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021);

		if (Math.abs(166_666 - count102) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102);

		if (Math.abs(166_666 - count120) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120);

		if (Math.abs(166_666 - count201) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201);

		if (Math.abs(166_666 - count210) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210);

		// If execution completes without failing, the test passes!
		// (When this method ends normally, the test is marked as passing.)
	}

	@Test
	public void testReverseOrderEmpty()
	{
		// Declare character array myEmpty with no values.
		char[] myEmpty = {};
		
		// Declare copy of myEmpty.
		char[] copyEmpty = myEmpty.clone();
		
		// Call .reverseOrder(...) method.
		ArrayExercises.reverseOrder(myEmpty);

		// Reverse copyEmpty array with StringBuilder method .reverse() and store into string stringEmpty.
		String stringEmpty = new StringBuilder(new String(copyEmpty)).reverse().toString();

		// Convert stringEmpty to character array and store into character array testEmpty.
		char[] testEmpty = stringEmpty.toCharArray();
				
		// Assert arrays testEmpty and myEmpty are equal.
		assertArrayEquals(testEmpty, myEmpty);
	}
	
	@Test
	public void testReverseOrderOdd()
	{
		// Declare character array myOdd with nine values lower case a thru i.
		char[] myOdd = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};

		// Declare copy of myOdd.
		char[] copyOdd = myOdd.clone();

		// Call the .reverseOrder(...) method.
		ArrayExercises.reverseOrder(myOdd);

		// Reverse copyOdd array with StringBuilder method .reverse() and store into string stringOdd.
		String stringOdd = new StringBuilder(new String(copyOdd)).reverse().toString();

		// Convert stringOdd to character array and store into character array testOdd.
		char[] testOdd = stringOdd.toCharArray();
		
		// Assert arrays testOdd and myOdd are equal.
		assertArrayEquals(testOdd, myOdd);
	}
	
	@Test
	public void testReverseOrderEven()
	{
		// Declare character array myEven with six values lower and upper case a thru f.
		char[] myEven = {'A', 'b', 'C', 'd', 'E', 'f'};

		// Declare copy of myEven.
		char[] copyEven = myEven.clone();

		// Call .reverseOrder(...) method.
		ArrayExercises.reverseOrder(myEven);

		// Reverse copyEven with StringBuilder method .reverse() and store into string stringEven.
		String stringEven = new StringBuilder(new String(copyEven)).reverse().toString();

		// Convert stringEven to character array and store into character array testEven.
		char[] testEven = stringEven.toCharArray();
			
		// Assert arrays testEven and myEven are equal.
		assertArrayEquals(testEven, myEven);
	}
	
	@Test
	public void testReverseOrderLargeOdd()
	{
		// Declare character array alphabet with 26 values lower case a thru z.
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		// Declare character array myLarge with size 60.
		char[] myLarge = new char[100001];
		
		// Declare random object random.
		Random random = new Random();
		
		// Declare variable position equal to 0; as long as position is less than myLarge's length, increment position.
		for(int position = 0; position < myLarge.length; position++)
		{
			// Randomize values in myLarge array.
			myLarge[position] = alphabet[random.nextInt(alphabet.length)];
		}
		
		// Declare copy of myLarge.
		char[] copyLarge = myLarge.clone();
		
		// Call .reverseOrder(...) method.
		ArrayExercises.reverseOrder(myLarge);

		// Reverse copyLarge with StringBuilder method .reverse() and store into string stringLarge.
		String stringLarge = new StringBuilder(new String(copyLarge)).reverse().toString();

		// Convert stringLarge to character array and store into character array testLarge.
		char[] testLarge = stringLarge.toCharArray();
					
		// Assert arrays testLarge and myLarge are equal.
		assertArrayEquals(testLarge, myLarge);
	}
	
	@Test
	public void testReverseOrderLargeEven()
	{
		// Declare character array alphabet with 26 values lower case a thru z.
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		// Declare character array myLarge with size 60.
		char[] myLarge = new char[100000];
		
		// Declare random object random.
		Random random = new Random();
		
		// Declare variable position equal to 0; as long as position is less than myLarge's length, increment position.
		for(int position = 0; position < myLarge.length; position++)
		{
			// Randomize values in myLarge array.
			myLarge[position] = alphabet[random.nextInt(alphabet.length)];
		}
		
		// Declare copy of myLarge.
		char[] copyLarge = myLarge.clone();
		
		// Call .reverseOrder(...) method.
		ArrayExercises.reverseOrder(myLarge);

		// Reverse copyLarge with StringBuilder method .reverse() and store into string stringLarge.
		String stringLarge = new StringBuilder(new String(copyLarge)).reverse().toString();

		// Convert stringLarge to character array and store into character array testLarge.
		char[] testLarge = stringLarge.toCharArray();
					
		// Assert arrays testLarge and myLarge are equal.
		assertArrayEquals(testLarge, myLarge);
	}

	@Test
	public void testCountNoNull()
	{
		// Declare string array values with six values.
		String[] values = new String[] {"Hello", "hello", "Hellow", "How low", "hullo", "hello"};
		
		// Assert count (first parameter) equals values from .count(...) method (right parameter).
		assertEquals(1, ArrayExercises.count(values, "Hello"));
		assertEquals(2, ArrayExercises.count(values, "hello"));
		assertEquals(1, ArrayExercises.count(values, "Hellow"));
		assertEquals(1, ArrayExercises.count(values, "How low"));
		assertEquals(1, ArrayExercises.count(values, "hullo"));
		assertEquals(0, ArrayExercises.count(values, null));
	}
	
	@Test
	public void testCountNull()
	{
		// Declare a String array values with 4 values and 3 nulls.
		String[] values = new String[] {"Hello", "hello", "Hellow", "How low", null, null, null};
		
		// Assert count (first parameter) equals values from .count(...) method (right parameter).
		assertEquals(1, ArrayExercises.count(values, "Hello"));
		assertEquals(1, ArrayExercises.count(values, "hello"));
		assertEquals(1, ArrayExercises.count(values, "Hellow"));
		assertEquals(1, ArrayExercises.count(values, "How low"));
		assertEquals(0, ArrayExercises.count(values, "hullo"));
		assertEquals(3, ArrayExercises.count(values, null));
	}

	@Test
	public void testReplaceEmpty()
	{
		// Declare string array values with size 3.
		String[] values = new String[3];
		
		// Call .replace(...) method.
		ArrayExercises.replace(values, null, "yo");
		
		// Assert values at all positions are equal to expected strings or nulls.
		assertEquals(values[0], "yo");
		assertEquals(values[1], "yo");
		assertEquals(values[2], "yo");
	}
	
	@Test
	public void testReplaceNoNull()
	{
		// Declare string array values with 6 values.
		String[] values = new String[] {"Hello", "hello", "hello", "hullo", "Hellow", "How low"};
		
		// Call .replace(...) method.
		ArrayExercises.replace(values, "hello", null);
		
		// Assert values at all positions are equal to expected strings or nulls.
		assertEquals(values[0], "Hello");
		assertEquals(values[1], null);
		assertEquals(values[2], null);
		assertEquals(values[3], "hullo");
		assertEquals(values[4], "Hellow");
		assertEquals(values[5], "How low");
	}
	
	@Test
	public void testReplaceNull()
	{
		// Declare string array values with 5 values and 2 nulls.
		String[] values = new String[] {"Hello", null, "hello", "hewwo", "Hellow", null, null};
		
		// Call .replace(...) method.
		ArrayExercises.replace(values, null, "uwu");
		
		// Assert values at all positions are equal to expected strings or nulls.
		assertEquals(values[0], "Hello");
		assertEquals(values[1], "uwu");
		assertEquals(values[2], "hello");
		assertEquals(values[3], "hewwo");
		assertEquals(values[4], "Hellow");
		assertEquals(values[5], "uwu");
		assertEquals(values[6], "uwu");
	}
	
	@Test
	public void testComputeAreasEmpty()
	{
		// Declare double array areas and call .computeAreas(...) method.
		double[] areas = ArrayExercises.computeAreas(new double[] {}, new double[] {});
		
		// Assert areas' length is equal to 0.
		assertEquals(areas.length, 0);
	}

	@Test
	public void testComputeAreasSmall()
	{
		// Declare double array areas and call .computeAreas(...) method.
		double[] areas = ArrayExercises.computeAreas(new double[] {2, 6}, new double[] {3, 4});
		
		// Assert areas at given position are equal to computation.
		assertEquals(areas[0], 6);
		assertEquals(areas[1], 24);
		
//		// Assert areas' length is equal to 2.
//		assertEquals(areas.length, 2);
	}
	
	@Test
	public void testComputeAreasDuplicate()
	{
		// Declare double array areas and call .computeAreas(...) method.
		double[] areas = ArrayExercises.computeAreas(new double[] {9, 9}, new double[] {9, 9});
		
		// Assert areas at given position are equal to computation.
		assertEquals(areas[0], 81);
		assertEquals(areas[1], 81);
		
//		// Assert areas' length is equal to 2.
//		assertEquals(areas.length, 2);
	}
	
	@Test
	public void testComputeAreasLarge()
	{
		// Declare double array areas and call .computeAreas(...) method.
		double[] areas = ArrayExercises.computeAreas(new double[] {101, 101}, new double[] {66, 96});
		
		// Assert areas at given position are equal to computation.
		assertEquals(areas[0], 6666);
		assertEquals(areas[1], 9696);
		
//		// Assert areas' length is equal to 2.
//		assertEquals(areas.length, 2);
	}

	@Test
	public void testRemoveNoNull()
	{
		// Declare color array colors with black and blue.
		Color[] colors = new Color[] {Color.black, Color.blue, Color.blue};
		
		// Store .remove(...) method with colors and blue into colors.
		colors = ArrayExercises.remove(colors, Color.blue);
		
		// Assert colors' length is 1.
		assertEquals(1, colors.length);
		
		// Assert black is equal to colors at 0.
		assertEquals(colors[0], Color.black);
	}
	
	@Test
	public void testRemoveNull()
	{
		// Declare color array colors with values black, blue, and 2 nulls.
		Color[] colors = new Color[] {Color.black, Color.gray, Color.blue, null, null};
		
		// Declare color array result and call .remove(...) method with colors and null.
		Color[] result = ArrayExercises.remove(colors, null);
		
		// Assert result's length is equal to 2.
		assertEquals(3, result.length);
		
		// Assert values at all positions are equal to expected colors or nulls.
		assertEquals(colors[0], Color.black);
		assertEquals(colors[1], Color.gray);
		assertEquals(colors[2], Color.blue);
	}
	
	@Test
	public void testRemoveLargeNoNull()
	{
		// Declare string array stuff with 5 values and 1 null.
		Color[] rainbow = new Color[] {Color.white};
		
		// Declare string array values with size 100,002.
		Color[] colors = new Color[100002];
		
		// Declare random object r.
		Random r = new Random();
		
		// Declare variable position equal to 0; as long as position is less than values' length, increment position.
		for(int position = 0; position < colors.length; position++)
		{
			// Randomize values in values array.
			colors[position] = rainbow[r.nextInt(rainbow.length)];
		}
		
		// Declare color array result and call .remove(...) method with colors and yellow.
		Color[] result = ArrayExercises.remove(colors, Color.yellow);
				
		// Assert result's length is 1.
		assertEquals(100002, result.length);
		
		// Assert colors at position 69,069 is white.
		assertEquals(colors[69069], Color.white);
	}
	
	@Test
	public void testSortSmall()
	{
		// Declare integer array data with 11 random values.
		int[] data = ArrayExercises.randomArray(11);

		// Call .sort(...) method.
		ArrayExercises.sort(data);

		// Declare integer position equal to 1; as long as position is less than data's length, increment position.
		for(int position = 1; position < data.length; position++)
		{
			// Assert true when data at position is less than or equal to data at position minus 1.
			assertTrue(data[position] <= data[position - 1]);
		}
	}
	
	@Test
	public void testSortLarge()
	{
		// Declare integer array data with 50 random values.
		int[] data = ArrayExercises.randomArray(50);

		// Call .sort(...) method.
		ArrayExercises.sort(data);

		// Declare integer position equal to 1; as long as position is less than data's length, increment position.
		for(int position = 1; position < data.length; position++)
		{
			// Assert true when data at position is less than or equal to data at position minus 1.
			assertTrue(data[position] <= data[position - 1]);
		}
	}

	@Test
	public void testFindSmallestSmall()
	{
		// Declare Rectangle array rectangles with 3 values.
		Rectangle[] rectangles = new Rectangle[] {new Rectangle(10, 10), new Rectangle(4, 4), new Rectangle(1, 1)};
		
		// Store .findSmallest(...) method into rectangle object r.
		Rectangle r = ArrayExercises.findSmallest(rectangles);
		
		// Assert r is equal to rectangles at 2.
		assertEquals(r, rectangles[2]);
	}
	
	@Test
	public void testFindSmallestDuplicate()
	{
		// Declare rectangle array rectangles with 4 values.
		Rectangle[] rectangles = new Rectangle[] {new Rectangle(1, 10), new Rectangle(4, 4), new Rectangle(1, 10), new Rectangle(1, 10)};
		
		// Store .findSmallest(...) method into rectangle object r.
		Rectangle r = ArrayExercises.findSmallest(rectangles);
		
		// Assert r is equal to rectangles at rectangles' length minus 1.
		assertEquals(r, rectangles[rectangles.length - 1]);
	}
}
