import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class readTest {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		//create the arraylist that will hold the celebrity object
		ArrayList<Celebrity> celebrities = new ArrayList<Celebrity>();
		
		
		//create input streams
		FileInputStream fi = new FileInputStream("C:\\Users\\Patrick Noonan\\P3_Assignment5\\Celebrity.ser");
		ObjectInputStream objectInput = new ObjectInputStream(fi);
		
		//stay reading lines until there are no lines availible to read in
		while(fi.available() > 0)
		{
			//iniating buffered reader which will read in the csv file
			BufferedReader awardReader = new BufferedReader(new FileReader("awards.csv"));
			
			//creating celebrity object which will be taken in from the serialized file and then added to the celebrities array
			Celebrity celebrity = Celebrity.readObject(objectInput, awardReader);
			celebrities.add(celebrity);
		}
		
		//for loop which iterates through the created celebrities array and prints out the to string
		for(Celebrity celebrity : celebrities)
		{
			System.out.println(celebrity);
		}
		
		
	}
	
	

}
