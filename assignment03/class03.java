package assignment03;

import java.util.Scanner;

public class class03
{

	public static void main(String[] args)
	{
		int n = 2;
		while (n < 100)
		{
			boolean isPrime = true;
			
			int divisor = 2;
			while (divisor < n)
			{
				int remainder = n % divisor;
				if (remainder == 0)
					isPrime = false;
				
				divisor++;
			}
			
			if (isPrime)
				System.out.println(n + " is prime.");
			else
				System.out.println(n + " is not prime.");
			
			n++;
		}

	}

}
