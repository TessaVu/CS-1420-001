/* Tester is a program used to test
 * the Rectangle.java class and its
 * methods.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		08 October 2021
*/

package quiz02;

public class Tester
{
	public static void main(String[] args)
	{
		System.out.println("Rectangle tester:\n"); // Indicate program start.
		
		RectangleQuiz big = new RectangleQuiz(30, 70, 12, 66.47); // Create an object with measurements of 30x70x12.
		System.out.println(big); // Print object fields.
		
		int bigV = big.volume(big); // Declare variable to hold result and call the volume method.
		System.out.println("Volume = " + bigV + " units^3"); // Print volume result.
		
		int bigSA = big.surfaceArea(big); // Declare variable to hold result and call the surface area method.
		System.out.println("Surface Area = " + bigSA + " units^2\n"); // Print surface area result.
		
		RectangleQuiz little = new RectangleQuiz(8, 11, 3, 33.77); // Create an object with measurements of 8x11x3.
		System.out.println(little); // Print object fields.
		
		int littleV = little.volume(little); // Declare variable to hold result and call the volume method.
		System.out.println("Volume = " + littleV + " units^3"); // Print volume result.
		
		int littleSA = little.surfaceArea(little); // Declare variable to hold result and call the surface area method.
		System.out.println("Surface Area = " + littleSA + " units^2\n"); // Print surface area result.
		
		// Create more rectangle objects.
		RectangleQuiz flat = new RectangleQuiz(22, 20, 3, 42.42);
		RectangleQuiz giant = new RectangleQuiz(1076, 1111, 1101, 101.998);
		RectangleQuiz skinny = new RectangleQuiz(10, 9, 96, 69.83);
		RectangleQuiz wide = new RectangleQuiz(366, 199, 81, 67.456);
		
		// Print out rectangle objects.
		System.out.println("Flat\n" + flat + "\n" + "\n" + "Giant\n" + giant + "\n" + "\n" + "Skinny\n" + skinny + "\n" + "\n" + "Wide\n" + wide);
		
		// Test accessors.
		System.out.println("\nFlat length: " + flat.getLength());
		System.out.println("Flat width: " + flat.getWidth());
		System.out.println("Flat height: " + flat.getHeight());
		System.out.println("Flat weight: " + flat.getWeight());
		
		System.out.println("\nGiant length: " + giant.getLength());
		System.out.println("Giant width: " + giant.getWidth());
		System.out.println("Giant height: " + giant.getHeight());
		System.out.println("Giant weight: " + giant.getWeight());
		
		System.out.println("\nSkinny length: " + skinny.getLength());
		System.out.println("Skinny width: " + skinny.getWidth());
		System.out.println("Skinny height: " + skinny.getHeight());
		System.out.println("Skinny weight: " + skinny.getWeight());
		
		System.out.println("\nWide length: " + wide.getLength());
		System.out.println("Wide width: " + wide.getWidth());
		System.out.println("Wide height: " + wide.getHeight());
		System.out.println("Wide weight: " + wide.getWeight());
		
		// Test mutator.
		flat.setWeight(40.0);
		giant.setWeight(951369.8642);
		skinny.setWeight(1.025);
		wide.setWeight(153.351);
		
		// Print mutated weights.
		System.out.println("\nMutated flat weight: " + flat.getWeight());
		System.out.println("Mutated giant weight: " + giant.getWeight());
		System.out.println("Mutated skinny weight: " + skinny.getWeight());
		System.out.println("Mutated wide weight: " + wide.getWeight());
	}
}
