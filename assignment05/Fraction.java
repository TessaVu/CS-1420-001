/* Fraction is a program with methods used to
 * create fractions with longs and is called
 * in the FractionTester program.
 * 
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		04 October 2021
*/

package assignment05;

public class Fraction
{
	// Fields.
	private long numerator;
	private long denominator;
	
	// First constructor.
	public Fraction (long n, long d)
	{
		// Reduce fraction using GCD before storing.
		long gcd = n;
		long remainder = d;
		long temp = 0;
		
	    // Compute the greatest common divisor of x and y.
	    while (remainder != 0) // While the remainder is not zero...
	    {
	        temp = remainder; // Temporary storage for the remainder.
	        remainder = gcd % remainder; // Divide the GCD by the remainder, returning the remainder.
	        gcd = temp; // Store the GCD into the temporary remainder storage.
	    }
	    
	    if (n < 0 && d < 0) // If both n and d are negative...
		{
			n = Math.abs(n); // Make n positive.
			d = Math.abs(d); // Make d positive.
		}
		else if (n > 0 && d < 0) // If n is positive and d is negative...
		{
			// Store the fraction as -n/d instead of n/-d.
			n = -n; // Make n negative.
			d = Math.abs(d); // Make d positive.
		}
	    
	    // Complete the fraction reduction.
	    numerator = n / Math.abs(gcd);
	    denominator = d / Math.abs(gcd);
	}
	
	// Second constructor for a single number entry for a fraction.
	public Fraction(long number)
	{
		this.numerator = number;
		this.denominator = 1;
	}
	
	/**
	 * Preconditions: Fraction has been called given two longs.
	 * Postconditions: Returns a Fraction object.
	 * 
	 * Used to add Fractions.
	 * 
	 * @param Fraction.
	 * @return Fraction.
	 */
	public Fraction add (Fraction rightHandSide)
	{
		// Build a new Fraction object - send the products to the constructor.
	    Fraction result = new Fraction ((this.numerator * rightHandSide.denominator) + (this.denominator * rightHandSide.numerator),
	    						this.denominator * rightHandSide.denominator);
	    
	    // Pass the resulting fraction back to the caller.
	    return result;
	}
	
	/**
	 * Preconditions: Fraction has been called given two longs.
	 * Postconditions: Returns a Fraction object.
	 * 
	 * Used to subtract Fractions.
	 * 
	 * @param Fraction.
	 * @return Fraction.
	 */
	public Fraction subtract (Fraction rightHandSide)
	{
		// Build a new Fraction object - send the products to the constructor.
	    Fraction result = new Fraction ((this.numerator * rightHandSide.denominator) - (this.denominator * rightHandSide.numerator),
	    						this.denominator * rightHandSide.denominator);
	    
	     // Pass the resulting fraction back to the caller.
	     return result;
	}
	
	
	/**
	 * Preconditions: Fraction has been called given two longs.
	 * Postconditions: Returns a Fraction object.
	 * 
	 * Used to multiply Fractions.
	 * 
	 * @param Fraction.
	 * @return Fraction.
	 */
	public Fraction multiply (Fraction rightHandSide)
	{
		// Build a new Fraction object - send the products to the constructor.
	    Fraction result = new Fraction (this.numerator * rightHandSide.numerator,
	                           this.denominator * rightHandSide.denominator);
	    
	     // Pass the resulting fraction back to the caller.
	     return result;
	}
	
	/**
	 * Preconditions: Fraction has been called given two longs.
	 * Postconditions: Returns a Fraction object.
	 * 
	 * Used to divide Fractions.
	 * 
	 * @param Fraction.
	 * @return Fraction.
	 */
	public Fraction divide (Fraction rightHandSide)
	{
	    // Build a new Fraction object - send the products to the constructor.
	    Fraction result = new Fraction (this.numerator * rightHandSide.denominator,
	                           this.denominator * rightHandSide.numerator);
	    
	     // Pass the resulting fraction back to the caller.
	     return result;
	}
	
	/**
	 * Preconditions: Variable referenced must be a Fraction object.
	 * Postconditions: Returns a double.
	 * 
	 * Used to convert Fractions into doubles.
	 * 
	 * @param None.
	 * @return double.
	 */
	public double toDouble()
	{
		return ((double) this.numerator / (double) this.denominator); // Typecast the Fraction.
	}
	
	/**
	 * Preconditions: Variable referenced must be a Fraction object.
	 * Postconditions: Returns a String.
	 * 
	 * Used to convert Fractions into Strings.
	 * 
	 * @param None.
	 * @return String.
	 */
	public String toString ()
	{
		return numerator + "/" + denominator;
	}
	
	/**
	 * Preconditions: Variable referenced must be a Fraction object.
	 * Postconditions: Returns a long.
	 * 
	 * Used to get the numerator.
	 * 
	 * @param None.
	 * @return long.
	 */
	public long getNumerator ()
	{
	    return numerator;
	}
	
	/**
	 * Preconditions: Variable referenced must be a Fraction object.
	 * Postconditions: Returns a long.
	 * 
	 * Used to get the denominator.
	 * 
	 * @param None.
	 * @return long.
	 */
	public long getDenominator ()
	{
	    return denominator;
	}
}
