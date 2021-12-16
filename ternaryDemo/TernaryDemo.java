package nov22;

import java.util.Scanner;

public class TernaryDemo
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a word: ");
		String word = s.next();
		
//		System.out.println(word + " has " + word.length() + (word.length() == 1 ? " character." : (" characters.")));
//		System.out.println(word + " has " + word.length() + " character" + (word.length() == 1 ? "" : "s") + ".");
		
		int x = 10;
//		System.out.println(x++); // Produces 10.
		System.out.println(x++ + " " + x); // Retrieves value first, then increments value.
		
		int y = 10;
//		System.out.println(++y); // Produces 11.
		System.out.println(++y + " " + y); // Increments value first, then retrieves value.
		
		int[] data = new int[10];
		
		int pos = 0;
		while(pos < 10)
			data[pos++] = (int)(Math.random() * 12);
	}
}
