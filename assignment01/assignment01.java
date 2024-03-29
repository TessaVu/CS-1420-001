/* This class states a student identification number and uses
 * the integer as seconds to convert the time to hours, minutes, seconds.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		26 August 2021
 */

package assignment01;

public class TimeCalculation
{
	public static void main(String[] args)
	{
		int uID = 847438; // Omitted the leading 0 to avoid an error.
		
		System.out.print("My uID number is u"); // Identification statement starts here.
		System.out.print(uID);
		System.out.println(".");
		
		int totalSeconds, totalMinutes, totalHours; // Time calculation starts here.
		
		totalSeconds = uID;
		totalMinutes = totalSeconds / 60;
		totalHours = totalMinutes / 60;
		
		System.out.print(totalSeconds + " seconds is ");
		System.out.print(totalHours + " hour(s), ");
		System.out.print((totalMinutes%60) + " minute(s), and "); // Compute and print out remainders.
		System.out.print((totalSeconds%60) + " second(s).");
	}
}
