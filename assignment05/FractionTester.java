/* FractionTester is a program that uses the
 * Fraction class to divide or multiply values
 * and print them to the user in fraction form.
 * 
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		04 October 2021
*/

package assignment05;

public class FractionTester
{	
	public static void main(String[] args)
	{
		// Declare error trackers for testing.
		int errorCount = 0;
		int errorTotal = 0;
		
		// Start of program.
		System.out.println ("Fraction tester:\n");

		// Create new Fraction objects.
		Fraction f = new Fraction (2, 3);
		Fraction g = new Fraction (1, 4);
		Fraction h = new Fraction (-5);
		
		// Test printing.
		System.out.println ("Fraction f contains: " + f);
		System.out.println ("Fraction g contains: " + g);
		System.out.println ("Fraction h contains: " + h);
		
		// Test getters.
		System.out.println ("\nG's numerator is: " + g.getNumerator());
		System.out.println ("G's denominator is: " + g.getDenominator() + "\n");
		
		// Test operation methods.
		Fraction p;
		p = f.multiply(g);
		System.out.println(f + " * " + g + " = " + p);
		if (f.getNumerator() == 2 && f.getDenominator() == 3 && g.getNumerator() == 1 && g.getDenominator() == 4
				&& p.getNumerator() == 1 && p.getDenominator() == 6)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		p = f.divide(g);
		System.out.println(f + " / " + g + " = " + p);
		if (f.getNumerator() == 2 && f.getDenominator() == 3 && g.getNumerator() == 1 && g.getDenominator() == 4
				&& p.getNumerator() == 8 && p.getDenominator() == 3)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		p = f.add(g);
		System.out.println(f + " + " + g + " = " + p);
		if (f.getNumerator() == 2 && f.getDenominator() == 3 && g.getNumerator() == 1 && g.getDenominator() == 4
				&& p.getNumerator() == 11 && p.getDenominator() == 12)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		p = f.subtract(g);
		System.out.println(f + " - " + g + " = " + p);
		if (f.getNumerator() == 2 && f.getDenominator() == 3 && g.getNumerator() == 1 && g.getDenominator() == 4
				&& p.getNumerator() == 5 && p.getDenominator() == 12)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		Fraction q;
		q = g.multiply(h);
		System.out.println(g + " * " + h + " = " + q);
		if (g.getNumerator() == 1 && g.getDenominator() == 4 && h.getNumerator() == -5 && h.getDenominator() == 1
				&& q.getNumerator() == -5 && q.getDenominator() == 4)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		

		q = g.divide(h);
		System.out.println(g + " / " + h + " = " + q);
		if (g.getNumerator() == 1 && g.getDenominator() == 4 && h.getNumerator() == -5 && h.getDenominator() == 1
				&& q.getNumerator() == -1 && q.getDenominator() == 20)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		q = g.add(h);
		System.out.println(g + " + " + h + " = " + q);
		if (g.getNumerator() == 1 && g.getDenominator() == 4 && h.getNumerator() == -5 && h.getDenominator() == 1
				&& q.getNumerator() == -19 && q.getDenominator() == 4)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		q = g.subtract(h);
		System.out.println(g + " - " + h + " = " + q);
		if (g.getNumerator() == 1 && g.getDenominator() == 4 && h.getNumerator() == -5 && h.getDenominator() == 1
				&& q.getNumerator() == 21 && q.getDenominator() == 4)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		// toString tester.
		String fractF = f.toString();
		System.out.println(fractF);
		if (fractF == "2/3")
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		String fractG = g.toString();
		System.out.println(fractG);
		if (fractG == "1/4")
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		String fractH = h.toString();
		System.out.println(fractH);
		if (fractH == "-5/1")
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		// toDouble tester.
		double doubF = f.toDouble();
		System.out.println(doubF);
		if (doubF == 0.666666)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		double doubG = g.toDouble();
		System.out.println(doubG);
		if (doubG == 0.25)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		double doubH = h.toDouble();
		System.out.println(doubH);
		if (doubH == -5)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		Fraction first = new Fraction(0, 1);
		Fraction second = new Fraction(-1);
		
		Fraction mistake = first.divide(second);
		System.out.println(first + " / " + second + " = " + mistake);
		if (first.getNumerator() == 0 && first.getDenominator() == 1 && second.getNumerator() == -1 && second.getDenominator() == 1
				&& mistake.getNumerator() == 0 && mistake.getDenominator() == 1)
		{
			errorCount = 0; // Keep errorCount at 0.
			errorTotal = 0; // Keep errorTotal at 0.
		}
		else
		{
			errorCount++; // Increment errorCount.
			errorTotal++; // Increment errorTotal.
		}
		
		if (errorCount == errorTotal) // If the errorCount is not equal to the errorTotal...
		{
			System.out.println("All tests completed, no errors."); // Print that there are no errors.
		}
		else if (errorCount < errorTotal) // Else if the errorCount is less than the errorTotal...
		{
			System.out.println("All tests completed, errors found."); // Print that there are errors.
		}
	}
}
