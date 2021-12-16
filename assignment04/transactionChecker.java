/* This class is a program that scans through a file
 * with a list of transactions, recording entries,
 * dates, totals, subgroups, and subtotals looking
 * for amount equality. If the program finds an
 * arithmetic error, it prints the errors with the
 * dates and aborts. If the program finds no
 * arithmetic error, it prints that there are no
 * errors and ends.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		26 September 2021
*/

package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class transactionChecker
{
	public static void main(String[] args)
	{
		double computedTotal = 0; // Declare variable to store computed total calculations.

		System.out.println("Transaction Checker by Tessa Vu"); // Notify user the program has started.

		System.out.print("Enter a filename: "); // Prompt user for filename input.
		Scanner input = new Scanner(System.in);

		String inputFile = input.nextLine(); // Store user's input as a string.

		try (Scanner fileScanner = new Scanner(new File(inputFile));) // Check transactions.
		{
			int entryCount = fileScanner.nextInt(); // Store number of entries.

			fileScanner.next(); // Skip "ITEMS".
			fileScanner.next(); // Skip "ON".

			String date = fileScanner.next(); // Store date.

			fileScanner.next(); // Skip "TOTALING".

			double recordedTotal = scanMoneyValue(fileScanner); // Store recorded total.
			
			try
			{
				// Check one group of transactions.
				for(int i = 0; i < entryCount; i++) { // As long as i is less than the entry count loop and increment.
					computedTotal += scanOneTransaction(fileScanner); // Calculate computed total for comparison with recorded total.
				}
	
				if(isNearlyEqual(recordedTotal, computedTotal)) // Use to compare computed and recorded totals.
				{
					System.out.println("File " + inputFile + " does not have any arithmetic errors.");
				}
				else
				{
					throw new ArithmeticException("Arithmetic error on " + date + ".\nAmount is recorded as " + printMoneyValue(recordedTotal) + ", should actually be " + printMoneyValue(computedTotal) + "." + "\nAn error has terminated checking.");
				}
			} catch (ArithmeticException ae)
			{
				System.out.println(ae.getMessage());
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File " + inputFile + " cannot be accessed.");
		}
	}

	/**
	 * Preconditions: The below method assumes the scanned word is a money value, starting with $.
	 * Postconditions: Returns the scanned string as a double.
	 * Used to read a money value.
	 * @param Scanner fileScanner
	 * @return double
	 */
	public static double scanMoneyValue(Scanner fileScanner)
	{
		String string$Amount = fileScanner.next(); // Takes amount as a string, includes $.
		String stringAmount = string$Amount.substring(1, string$Amount.length()); // Removes $ from amount string.

		double smvAmount = Double.parseDouble(stringAmount); // Converts string to a double.

		return smvAmount; // Returns amount as a double. Does not include ending zeroes because it is not formatted.
	}

	/**
	 * Preconditions: The below method assumes the input has gone through the scanMoneyValue method.
	 * Postconditions: Returns the double amount as a string amount formatted to two decimal places.
	 * Used to print a money value when an error takes place.
	 * @param double smvAmount
	 * @return String
	 */
	public static String printMoneyValue(double smvAmount)
	{
		String pmvAmount = String.format("$%.2f", smvAmount); // Stores "$XX.xx" (two decimal places) into pmvAmount.

		return pmvAmount; // Returns amount as a string with two decimal places.
	}

	/**
	 * Preconditions: The below method assumes that the recorded subtotal and computed subtotal have gone through the scanMoneyValue method.
	 * Postconditions: Returns the comparison as true or false.
	 * Used to compare computed totals to recorded totals.
	 * @param double subtotalAmount, double computedAmount
	 * @return boolean
	 */
	public static boolean isNearlyEqual(double recordedTotal, double computedTotal)
	{
		if (Math.abs(recordedTotal - computedTotal) < 0.00000001) // If the recorded amount minus the computed amount is near-zero...
			return true; // Return true.
		else // Otherwise...
		{
			return false; // Return false.
		}
	}

	/**
	 * Preconditions: The below method assumes the Scanner is positioned so it is about to read in a transaction from the file, starting at "BUY" or "SELL".
	 * Postconditions: Returns the scanned amounts as doubles.
	 * Used to scan one buy/sell transaction or uses scanAndCheckOneGroup method when there is a subgroup.
	 * @param Scanner fileScanner
	 * @return double
	 */
	public static double scanOneTransaction(Scanner fileScanner)
	{
		double sotAmount = 0; // Declare variable to store recorded amount.
		String sotDate = null; // Declare variable to store date.

		String transactionWord = fileScanner.next(); // Read "BUY" or "SELL".

		if(transactionWord.equals("BUY") || transactionWord.equals("SELL")) { // If it is BUY or SELL...
			sotDate = fileScanner.next(); // Store date.
			sotAmount = scanMoneyValue(fileScanner); // Read money value.
		}
		else if(transactionWord.equals("SUBGROUP")) { // If it is a SUBGROUP...
			sotAmount = scanAndCheckOneGroup(fileScanner); // Use scanAndCheckOneGroup to read and check the subgroup.
		}
		return sotAmount; // Return recorded total amount since a subgroup is also a transaction.
	}

	/**
	 * Preconditions: The below method assumes that the Scanner is positioned after "SUBGROUP" from the scanOneTransaction method.
	 * Postconditions: Returns the scanned amounts as doubles and checks for equality with a throw exception if there is inequality.
	 * Used to scan transactions in subgroups.
	 * @param Scanner fileScanner
	 * @return double
	 */
	public static double scanAndCheckOneGroup(Scanner fileScanner)
	{
		double computedTotal = 0; // Declare variable to store computed amount.
		double subAmount = 0; // Declare variable to store recorded amount.
		int subEntryCount = fileScanner.nextInt(); // Store number of sub-entries.
		
		StringBuilder test = new StringBuilder();
		
		fileScanner.next(); // Skip "ITEMS".
		fileScanner.next(); // Skip "ON".
		
		String date = fileScanner.next();

		fileScanner.next(); // Skip "TOTALING".

		double recordedTotal = scanMoneyValue(fileScanner); // Recorded subtotal.

		// Repeatedly use scanOneTransaction to scan transaction amounts.
		for (int i = 0; i < subEntryCount; i++)
		{ // As long as i is less than the entry count loop and increment.
			subAmount = scanOneTransaction(fileScanner); // Store subgroup amounts.
			computedTotal += subAmount; // Calculate computed total for comparison with recorded total.
		}
		
		if(isNearlyEqual(computedTotal, recordedTotal) == true)
		{ // Compare computed and recorded totals.
			return computedTotal;
		}
		else
		{
		throw new ArithmeticException("Arithmetic error on " + date + ".\nAmount is recorded as " + printMoneyValue(recordedTotal) + ", should actually be " + printMoneyValue(computedTotal) + "." + "\nAn error has terminated checking.");
		}
	}
}
