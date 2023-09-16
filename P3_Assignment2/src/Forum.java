//Patrick Noonan(20355426)

import java.util.ArrayList;


public class Forum {
	
	public Forum() //constructor for the forum object
	{
		
	}
	
	ArrayList<User> users = new ArrayList<User>(); //creating a users array
	ArrayList<ForumPost> forumPosts= new ArrayList<ForumPost>(); //creating a forumPosts array
	
	
	public void addingNewUser(User user) throws InvalidUserException //method that adds new user to the class
	{
		if(isUserValid(user.getUserID())) //firstly checks to see if user ID is valid
		{
			users.add(user); //if it is valid add it to the forum
		}
		else
		{
			throw new InvalidUserException("User ID has already been registered"); //if not valid throw exception
		}
	}
	
	public void deletingUser(int userID) throws InvalidUserException //method which deletes users from forum
	{
		
		if(!isUserValid(userID)) //if user ID does already exist on forum then delete it from forum
		{
			for(int i=0; i<users.size(); i++)//iterates through arraylist till is finds matching user ID then deletes is
			{
				int ID = users.get(i).getUserID();
				
				if(ID == userID)
				{
					users.remove(i);
				}
			}
		}
		
		else
		{
			throw new InvalidUserException("Cannot delete user as it does not exist"); //if the user ID doesnt exist throw exception
		}
			
	}
	
	
	
	public void printArray()
	{
		for(int i = 0; i<users.size(); i++)
		{
			System.out.println(users.get(i).getUserID());
		}
	}
	
	public boolean isUserValid(int ID)//method to check if user ID is valid
	{
		
		
		for(int i=0; i< users.size(); i++)
		{
			int userID = users.get(i).getUserID();//iterates through array checks if userID already exists
			
			if(ID == userID)
			{
				return false; //if it does exist return false as user cant be created
			}
			
			
		}
		
		return true; //if it doesnt exist return true as user can be created
	}
	
	public void addForumPost(ForumPost forumPost) throws InvalidUserException
	{
		if(!isUserValid(forumPost.getUserID())) //if user exists create forum post
		{
			forumPosts.add(forumPost);
		}
		else
		{
			throw new InvalidUserException("Cannot create post as user is invalid"); //if user doesnt exist the post cant be posted
		}
	}
	
	
	public class User //inner class of user
	{
		
		String userName;
		int ID;
		
		public User(int ID, String username) //users constructor
		{
			//if(isUserValid(ID))
			{
				this.ID = ID;
				this.userName = username;	
			}		
			
		}
		
		public int getUserID()//method to get the user ID of any user
		{
			return ID;
		}
		
	}
	
	
	

}
