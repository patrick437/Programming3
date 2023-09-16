import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Awards {
	
	//instantiating variables from the constructor
	private String awardName;
	private String awardOrganisation;
	private LocalDate dateOfAward;

	
	//constructor
	/**
	 *Constructor for the Celebrity object
	 *@param awardName name of the award
	 *@param awardOrganisation the organisatikn in charge of the award
	 *@param dateOfAwaed date award was presented
	 */
	public Awards(String awardName, String awardOrganisation, LocalDate dateOfAward)
	{
		this.awardName = awardName;
		this.awardOrganisation = awardOrganisation;
		this.dateOfAward =dateOfAward;
	}
	
	
	/**
	 *Method which writes the awards into a CSV file
	 *@param fileOutput the output stream which the awards are read out on
	 *@param id the Celebrities ID so we can assign particular awards to a certain celebrity
	 */
	public void writeObject(FileOutputStream fileOutput, int id) throws IOException
	{
		//instantiate buffered writer which will write the awards into a CSV file
		BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(fileOutput));
																				//puts dateOfAward into a string
		buffWriter.write(id + "," + awardName + "," + awardOrganisation + "," + dateOfAward.toString());
		buffWriter.newLine(); //puts CSV file on new line
	}
	
	
	/**
	 *reads the CSV file back in from the file
	 *@param line the string which is read in from the CSV file
	 *@return retuens the awards once its been translated from the CSV file
	 */
	public static Awards readObject(String line)
	{
		String[] awards = line.split(",");//method which splits raad in string into an array with each character separated by commas being a new member
		
		//reads in each member of the array and assigns it to a value
		String awardName = awards[1];
		String awardOrganisation = awards[2];
		//date formatter
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(awards[3], dateTimeFormatter);
		//instantiate a award object using the read in variables
		Awards award = new Awards(awardName, awardOrganisation, dateOfBirth);
		return award;
	}
	
	
	//multiple getters and setters for the awards object
	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardOrganisation() {
		return awardOrganisation;
	}

	public void setAwardOrganisation(String awardOrganisation) {
		this.awardOrganisation = awardOrganisation;
	}

	public LocalDate getDateOfAward() {
		return dateOfAward;
	}

	public void setDateOfAward(LocalDate dateOfAward) {
		this.dateOfAward = dateOfAward;
	}

}
