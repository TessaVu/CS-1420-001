package worksheet03;

import java.io.File;

public class tryCatch
{

	public static void main(String[] args)
	{
		try
		{
			start();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Error #404: Runtime exception.");
		}
	}
	
	public static void start()
	{
		if(null)
			throw new RuntimeException();
	}
}