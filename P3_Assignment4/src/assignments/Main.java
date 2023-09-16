package assignments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Main method which reads in the CSV file and breaks it up into its different regions
 * @author Patrick Noonan(20355426)
 */

public class Main {

	/**
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = null;
		
		
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\Patrick Noonan\\ass4.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = null;
	
		try {
			line = in.readLine();
			while((line = in.readLine()) != null)
			{
				Scanner scan = new Scanner(new StringReader(line));
				scan.useDelimiter(",");
//				if(line.startsWith("A") || line.startsWith("P"))
//				{
					while(scan.hasNext())
					{
						String landType = scan.next();
						System.out.println(landType);
						String region = scan.next();
						System.out.println(region);
						double valueOfLand = scan.nextDouble();
						
						
						Region userInput = Region.getRegion(region);
						
						PrintWriter pw = null;
						switch(userInput)
						{
							case STATE:
							System.out.println("xxxxxxxx");
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
								
								break;
							case BORDER:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
								break;
							case MIDLAND:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case WEST:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case DUBLIN:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;	
							case MIDWEST:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case SOUTHEAST:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case SOUTHWEST:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case MIDEAST:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
							case OTHER:
								DataWriter.writeLandDataToFile(region.toString(), landType, valueOfLand);
							break;
						}
						
						
//					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			in.close();
		}
	
		
		
		
	
	}

}
