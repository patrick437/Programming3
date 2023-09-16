import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		//making a user object
		User user = new User(123, "pa", "no");
		//instantiating a buffered reader and filereader to read in the csv file
		BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\Patrick Noonan\\P3_Assignment6\\User.csv"));
		//workspace and user arraylist being created
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Workspace> workspaces = new ArrayList<Workspace>();
		
		//creatig workspace objects and adding these to the workspace array
		Workspace w1 = new Workspace("workspace1", "description1", user);
		Workspace w2 = new Workspace("workspace2", "description2", user);
		Workspace w3 = new Workspace("workspace3", "description3", user);
		Workspace w4 = new Workspace("workspace4", "description4", user);
		
		workspaces.add(w1);
		workspaces.add(w2);
		workspaces.add(w3);
		workspaces.add(w4);
		
		
		//buffered reader reads in a line from csv
		String CSV = buffReader.readLine();
		//while the csv string isnt equal to null keep looping
		while(CSV != null)
		{
			//add object that has been read in from the readObject method to the arraylist
			users.add(user.readObject(CSV));
			System.out.println(user.readObject(CSV)); //print out object toString
			System.out.println();
			System.out.println();
			CSV = buffReader.readLine(); //read the next line of the array till there are no more lines to read
		}
		
	
		
		//sorting arraylist in natural order
		Collections.sort(users);
		System.out.println("Sorted in natural order: \n");
		users.forEach(n -> System.out.println(n)); //using lamda expression to print arraylist out
		System.out.println();
		System.out.println();
		
		//sorting arraylist according to userID in ascending order
		Collections.sort(users, new Comparator<User>() {
		      public int compare(User u1, User u2) {
		        return Long.compare(u1.getUserID(), u2.getUserID());
		      }
		    });
		
		System.out.println("Sorted by userID in ascending order: \n");
		users.forEach(n -> System.out.println(n)); //printing out using lamda expression and forEach
		System.out.println();
		System.out.println();
		
		//sorted by name in descending order using lamda expression
		Collections.sort(users, (User u1, User u2) ->
	    u2.getName().compareTo(u1.getName()));
	    System.out.println("Sorted by descending order by name: \n" );
	    users.forEach(n -> System.out.println(n));//printing out using lamda expression and forEach
	    System.out.println();
	    System.out.println();
	    
	    
	    
	    User.searchList(users, users.get(6)); //binary searching the arraylist for the 6th object in the arraylist
	    
	    //adding the 4th and 7th member of the arraylist to workspace as collaborators
	    w1.addCollaborator(users.get(3));
		w1.addCollaborator(users.get(6));
		w2.addCollaborator(users.get(3));
		w2.addCollaborator(users.get(6));
		w3.addCollaborator(users.get(3));
		w3.addCollaborator(users.get(6));
		w4.addCollaborator(users.get(3));
		w4.addCollaborator(users.get(6));
		
		//creating a map
	    Map<User, ArrayList<Workspace>> m = new HashMap<User, ArrayList<Workspace>>(); 
	    
	    //mapping the first member of the user arraylist and the arraylist of workspaces together
	    m.put(users.get(0),workspaces);
	    
	    //printing out the mapped arraylist of workspaces using the map.get method
	   System.out.println(m.get(users.get(0))); 
	    
	    
	}
	
	

}
