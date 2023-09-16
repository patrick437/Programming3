import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Celebrity {
	
	//variables from the constructor and the arraylist
	private int ID;
	private String name;
	private String profession;
	private LocalDate dateOfBirth;
	private ArrayList<Awards> awards = new ArrayList<Awards>();

	/**
	 *Constructor for the Celebrity object
	 *@param ID number which identifies the Celebrity
	 *@param name the name of Celebrity
	 *@param profession what the celebrity works as
	 *@param dateOfBirth celebritys date of birth
	 */
	public Celebrity(int ID, String name, String profession, LocalDate dateOfBirth )
	{
		this.ID = ID;
		this.name = name;
		this.profession = profession;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	/**
	 *Method which adds award to the awards array
	 *@param awards Awards object to be added to the array
	 */
	//method which adds an award to the above arraylist
	public void addAward(Awards award)
	{
		awards.add(award);
	}

	//multiple getters and setters for the Celebrity object
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Awards> getAwards() {
		return awards;
	}

	public void setAwards(ArrayList<Awards> awards) {
		this.awards = awards;
	}
	
	/**
	 *method which seriaise the Celebrity object
	 *@param os Object output stream which the Celebrities are wrote out on
	 */
	//method which serialises the Celebrity object
	public void writeObject(ObjectOutputStream os) throws IOException
	{		
		os.writeObject(ID);
		os.writeObject(name);
		os.writeObject(profession);
		os.writeObject(dateOfBirth);
	}
	
	/**
	 *Reads serialised object back in and reads in CSV file. Adds awards to given celebrity
	 *@param is Object Input stream which reads in serialised object
	 *@param buffReader reade which reads the CSV file that the awards are in
	 */
	//method which reads the serialised object back in 
	public static Celebrity readObject(ObjectInputStream is, BufferedReader buffReader)throws IOException, ClassNotFoundException
	{
		//read variables back in and assign them to variables
		int ID = (int) is.readObject();
		String name = (String)is.readObject();
		String profession = (String)is.readObject();
		LocalDate dateOfBirth = (LocalDate)is.readObject();
		
		//create the new Celebrities object from the above variables
		Celebrity celebrity = new Celebrity(ID, name, profession, dateOfBirth);
		
		//read in the CSV file
		String CSV = buffReader.readLine();
		while(CSV != null)//while there is still lines to read in in CSV stay reading the lines
		{
			//taking the awards ID and comparing it to the celebrities ID if they are equal add this award to the celebrities array
			if(Integer.parseInt(String.valueOf(CSV.charAt(0))) == celebrity.getID())
			{
				celebrity.addAward(Awards.readObject(CSV));
			}
			//read next line of the CSV
			CSV = buffReader.readLine();
		}
		return celebrity; //return the celebrity that has just been recreated
	}
	
	/**
	 *toString method to print celebrity object when it is called in the write test
	 *@return s the toString variable
	 */
	public String toString()
	{
		String s = "";
		s += "Celebrity ID: " + ID + "\n";
		s += "Celebrity name: "+ name + "\n";
		s += "Celebrity profession: " + profession + "\n";
		s += "Celebrity's DOB: " + dateOfBirth + "\n";
		return s;
	}
}
