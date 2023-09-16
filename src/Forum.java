
//Patrick Noonan(20355426)

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Forum {
	
	
	LocalDateTime localDateTime;
	private String uniqueID, forumID;
	
	private String title, post;
	public Forum() //set up three different constructors one which enters timestamp and one which automatically generates timestamp.
	{
		
	}
	
	public Forum(String title, String post) //automatically generates
	{
		this.title = title;  //takes in title reading
		this.post = post;   //takes in the post
		localDateTime = LocalDateTime.now();
		forumID = createUniqueID(); //creates posts unique ID
	}
	
	public Forum(String title, String post, LocalDateTime timestamp) throws TimeStampException //creates its own timestamp with user entry
	{
		this.title = title; //takes in title
		this.post = post;	//takes in post
		
		if(correctTimeStamp(timestamp)) //if statement to check if timestamp is sometime in the future
		{
			timestamp = localDateTime;
		}
		else  //if it is not in the future an exception will be thrown to tell user of invalid timestamp
		{
			throw new TimeStampException("Can't enter a time sooner then the present moment");
		}
		forumID = createUniqueID(); //creates posts unique ID
	}
	
	public boolean correctTimeStamp(LocalDateTime timestamp) //method which checks if timestamp is in the past or present
	{
		
		if(timestamp.isBefore(LocalDateTime.now())) //if timestamo entered is before present time return false else return true
		{
			return false;
		}
		
		else return true;
	}
	
	public String createUniqueID()
	{
		uniqueID = UUID.randomUUID().toString();
		
		return uniqueID;
	}
	public String getForumID()
	{
		return forumID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	
	public LocalDateTime queryTimestamp()
	{
		return localDateTime;
	}
	
	
	public String queryTitle()
	{
		return title;
	}
	
	
	public String queryText()
	{
		return post;
	}
	
	
	public void editTitle(String newTitle)
	{
		this.title = newTitle;
	}
	
	
	public void editPost(String newPost)
	{
		this.post = newPost;
		
	}
	
	public String toString()
	{
		String forumPost = "";
		forumPost += "TimeStamp: " +localDateTime;
		forumPost += "Title: " +title;
		forumPost += "Post: " +post;
		
		return forumPost;
		
				
	}
	

}


