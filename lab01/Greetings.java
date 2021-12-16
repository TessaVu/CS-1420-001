/* Greeting - a small program to demonstrate a few
 * Java concepts on the first day of class.
 * 
 * I added this comment to provide a few details not
 * given in class.  The code still exists, below.
 * 
 * Note that this source code is in a .java file, and
 * that when it is compiled, a .class file is created
 * behind the scenes.  If you look in the project
 * folder on your hard drive (or SSD), you should be able
 * to find both the .java files (in the src directory) and
 * the .class files (in the bin directory).
 * 
 * Also note this really cool bit of text.  It's called
 * a comment, and it is ignored by Java.  Notice how this
 * style of comment takes up multiple lines (block comment).
 * Below is a different style comment that takes a single
 * line.
 * 
 * Peter Jensen
 * August 23, 2021
 */

package lab01;

// All Java code exists within classes.  (Explored later)

public class Greetings
{
	// The 'main' method, where execution will begin.
	
	public static void main(String[] args) 
	{
		System.out.println("Hello world.");
		
		int inches;
		inches = 42;
		
		int feet;
		feet = inches / 12;
		
		System.out.println(feet);
	}
}
