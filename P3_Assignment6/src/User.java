import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class User implements Comparable<User>{
	
	private long userID;
	private String name;
	private String emailAddress;
	ArrayList<User> users = new ArrayList<User>();
	
	/**
	 *Constructor for the user object
	 *@param userID what is used to identify a user
	 *@param name the name of the user
	 *@param users email address
	 */
	public User(long userID, String name, String emailAddress)
	{
		this.userID = userID;
		this.name = name;
		this.emailAddress = emailAddress;
	}
	
	/**
	 *Reads in csv file
	 *@param string which is read in from the CSV file
	 *@return retuens the user object once all the parameters are read in from the CSV 
	 */
	public User readObject(String line)
	{
		String[] users = line.split(",");
		
		long userID = Long.valueOf(users[0]);
		String name = users[1];
		String emailAddress = users[2];
		
		User user = new User(userID,name,emailAddress);
		
		return user;
	}
	//multiple getters and setters
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 *method from the comparable interface which compares each email address to another to creaate a natural order
	 *@param user object which is being compared 
	 *@return returns int value which states whether its in the right place in natural order or not
	 */
	@Override
	public int compareTo(User user) {
		return emailAddress.compareTo(user.emailAddress);
	}

	/**
	 *Hashcode method which commes from the comparable method also
	 *@return integer value which represents the hash value of object
	 */
	@Override
	public int hashCode() {
		
		int prime = 7;
		int result = 1;
		String ID = String.valueOf(userID);
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return Objects.hash(userID);
	}

	/**
	 *equals method tells us whether two objets are equal by returning a boolean function
	 *@param obj which needs to be compared
	 *@return boolean value which states whether objects are equal or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return	userID == other.userID;
	}

	/**
	 *toString method describing the user object
	 *@return string value which describes the user object
	 */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", emailAddress=" + emailAddress + "]";
	}
	
	/**
	 *method which binary searches the Arraylist and if the object isnt found it is places in in its natural order
	 *@param Arraylist<User> arraylist which contains users
	 *@param key the object which is being searched for. If not found it is being placed in the list
	 *@return retuens intger value pos which is the position it is in the list
	 */
	public static int searchList(ArrayList<User> l, User key) {
        int pos = Collections.binarySearch(l, key);
        if (pos >= 0) {
          System.out.println(key + " already in the list in positon " + pos + "\n");
          return pos;
        }
        else {
          l.add(-pos-1, key);
          System.out.println(key + " not found in the list, added to position " + (-pos-1) + "\n");
          return pos;
        }
      }
	
	
	
	

}
