//Patrick Noonan(20355426)

import java.time.LocalDateTime;
import java.util.Scanner;



public class ForumApp {
	
	
	
	public enum Options //enum class created
	{ 
		 REGISTERUSER(1),
		 DeleteUser(2),
		 CreateForumPost(3);
		
		int options;

		Options(int i) {//enum constructor
			
			options = i;
		}
		
		public int getValue() {
			return this.options;
		}
	}
	
		
	public void chooseYourOption() throws InvalidUserException, InvalidTimestampException
		{
			Scanner input = new Scanner(System.in); //creating scanner
			
			System.out.println("Please enter 1(Register), 2(Delete) and 3(Post)"); //please enter desired digit to carry out whichever operation
			int number = input.nextInt(); //int value is read in
			Forum forum = new Forum(); //forum object is created
			input.nextLine(); //line is here so the user input below can all be done one by one using the enter key
			
			Options userEnum = Options.values()[number-1];		//this creates an enum variable of the inputed value above	
			                                    //have to iterate by one as the enum starts at 0
			
			switch(userEnum) { //enum variable used in the switch statement
				case REGISTERUSER:
				
					System.out.println("If you want to register user could you please enter");
					System.out.print("Username: ");//enter username and its scannned in
					String userName = input.nextLine();
					System.out.print("User ID: ");
					int userID = input.nextInt();
					Forum.User user = forum.new User(userID, userName); //scanned info created into a object
					chooseYourOption(); //calls the class if you want to continue with deleting users or creating posts
					break;
				
				case DeleteUser: 
				
					System.out.println("Pleae enter the user ID you want to delete:");
					int userID2 = input.nextInt(); //read in userID
					
					forum.deletingUser(userID2); //use userID in delete method to delete user
					chooseYourOption(); //recall the method again
					break;
				
			
				case CreateForumPost:
				
					System.out.println("If you want to make post please enter: "); //calls in all info required for ForumPost
					System.out.println("Title: ");
					String Title = input.nextLine();
					System.out.println("Post: ");
					String post = input.nextLine();
					System.out.println("Timestamp(if you do not want timestamp press enter): ");
					String timestamp = input.nextLine();
					System.out.println("Please enter your UserID: ");
					int authorID = input.nextInt();
				
					if(timestamp == "") //if there was nothing entered for Timestamp use constructor without timestamp
					{
						ForumPost forumPost = new ForumPost(Title,post,authorID);
					}
					else //else use the constructor with timestamp. Have to parse the timestamp from string to LocalDateTime
					{
						ForumPost forumPostTimeStamp = new ForumPost(LocalDateTime.parse(timestamp), Title, post, authorID);
					}
					
					chooseYourOption();
					break;
				
				
				default:	System.out.println("You have entered an incorrect number please try again"); //if they didnt enter one of the desired numbers this message pops up
				
			
			}
		}
}
			
		

		

	
	


