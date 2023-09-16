import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SerialisationTest {

	@Test
	void TestSerialisation() throws IOException, ClassNotFoundException
	{
		Celebrity MichaelPhelps = new Celebrity(1, "MichaelPhelps", "Swimmer", LocalDate.of(1970, 12, 12));
		MichaelPhelps.addAward(new Awards("World Champs", "World Swimming", LocalDate.of(2014, 5, 6)));
		MichaelPhelps.addAward(new Awards("Olympic Gold", "Olympic Committee", LocalDate.of(2012, 7, 6)));
		
		Celebrity UsainBolt = new Celebrity(2, "Usain Bolt", "Sprinter", LocalDate.of(1996, 12, 1));
		UsainBolt.addAward(new Awards("Olympic Gold", "Olympic Committee", LocalDate.of(2012, 6, 4)));
		UsainBolt.addAward(new Awards("4x100m Olympic Gold", "Olympic Committee", LocalDate.of(2012, 7, 10)));
		
		Celebrity TomCruise = new Celebrity(3, "Tom Cruise", "Film Star", LocalDate.of(1980, 10, 2));
		TomCruise.addAward(new Awards("Best Action Actor", "Golden Globes", LocalDate.of(2012, 7, 6)));
		TomCruise.addAward(new Awards("Best Comedian", "VMAS", LocalDate.of(2012, 7, 6)));
		
		Celebrity Tupac = new Celebrity(4, "Tupac", "rapper", LocalDate.of(2000, 1, 11));
		Tupac.addAward(new Awards("Best Album", "Grammies", LocalDate.of(2012, 7, 6)));
		Tupac.addAward(new Awards("Best Single", "Grammies", LocalDate.of(2012, 7, 6)));
		
		//all celebrities added to array to be iterated through later
		ArrayList<Celebrity> celebrities = new ArrayList<Celebrity>();
		celebrities.add(MichaelPhelps);
		celebrities.add(UsainBolt);
		celebrities.add(TomCruise);
		celebrities.add(Tupac);
		
		//create file output stream to celebrity.ser
		FileOutputStream fos1 = new FileOutputStream("Celebrity.ser");
		FileOutputStream fos2 = new FileOutputStream("awards.csv");
		//create object output stream using the file output stream
		ObjectOutputStream os = new ObjectOutputStream(fos1);
		
		//iterate through each of the celebrity objects and serialise them
		for(Celebrity celebrity : celebrities)
		{
			celebrity.writeObject(os);
		
		
			//save all the awards in CSV
			for(Awards award : celebrity.getAwards())
			{
				award.writeObject(fos2, celebrity.getID()); //place ID in so awards can be recognized when they are read back in
			}
			
		}
		
		//close fileOutput Streams
		fos1.close();
		fos2.close();
		os.close();
		
		//create the arraylist that will hold the celebrity object
				ArrayList<Celebrity> celebrities2 = new ArrayList<Celebrity>();
				
				
				//create input streams
				FileInputStream fi = new FileInputStream("C:\\Users\\Patrick Noonan\\P3_Assignment5\\Celebrity.ser");
				ObjectInputStream objectInput = new ObjectInputStream(fi);
				
				//stay reading lines until there are no lines available to read in
				while(fi.available() > 0)
				{
					//iniating buffered reader which will read in the csv file
					BufferedReader awardReader = new BufferedReader(new FileReader("awards.csv"));
					
					//creating celebrity object which will be taken in from the serialized file and then added to the celebrities array
					Celebrity celebrity = Celebrity.readObject(objectInput, awardReader);
					celebrities2.add(celebrity);
				}
				
				//tests which tests if the Objects before serialization and after serialization are equal
			assertEquals(celebrities.get(0), MichaelPhelps);
			assertEquals(celebrities.get(1), UsainBolt);
			assertEquals(celebrities.get(2), TomCruise);
			assertEquals(celebrities.get(3), Tupac);
		
	}
	

}
