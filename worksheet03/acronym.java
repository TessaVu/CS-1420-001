package worksheet03;

import java.util.Scanner;

public class acronym
{
	public static void main(String[] args)
	{		
		System.out.println("Enter a word: ");
		Scanner input = new Scanner(System.in);
				
		System.out.println(getAcronym(input));
		
		input.close();
	}
	
	public static String getAcronym(Scanner input)
	{
		String word = input.next();
		
		return word.toUpperCase();
	}
}