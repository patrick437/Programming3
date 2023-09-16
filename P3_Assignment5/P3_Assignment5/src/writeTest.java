import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class writeTest {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		//creating all the celebrities objects and adding the awards to there Objects
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
		
	}
	

}
