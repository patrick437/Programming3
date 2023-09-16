package assignments;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * DataWriter class which writes data into a given text file
 */
public class DataWriter {
	
	/**
	 * Constructor for the DataWriter class
	 */
	public DataWriter()
	{
		
	}
	
	/**
	 *Write Land Data to file method reads in the filename, landtype and landvalue and writes it to the recorded filename
	 *@param Filename the name of the file that is going to be written to
	 *@param landType the type of land that is for sale
	 *@param landValue the value that the land is on sale for 
	 *@throws IOException
	 */
	
	public static void writeLandDataToFile(String filename, String landType, double LandValue)
	{
		
		PrintWriter pw = null;
		try {
			System.out.println("Printing example");
			
			
				pw = new PrintWriter(new FileWriter(filename+".txt", true));
//				String example = String.format("The land type is %s and its total value is %f\n", landType, LandValue);
				
				pw.format("The land type is %s and its total value is %f\n", landType, LandValue);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pw.close();
			
		}
	}

}
