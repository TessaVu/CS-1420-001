package sarcasm;

import java.util.Scanner;

public class sArCaSm 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		
		String line = input.nextLine();
		
		String response = makeSarcasm(line);		
		System.out.println(response);
		
		input.close();
	}
	
	public static String makeSarcasm (String s)
	{
		char[] characters = s.toCharArray();
		
		String response = "";
		for (char ch : characters)
		{
			if (Math.random() > 0.5)
				ch = Character.toUpperCase(ch);
			
			response = response + ch;
		}
		return response;
	}
}