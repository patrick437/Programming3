//Patrick Noonan(20355426)


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;



public class ForumTests {
	
	@Test
	void userCreated()
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(233, "Patrick");
		
		assertTrue(user.getUserID() == 233);
		
	}
	
	@Test
	void duplicateUsers() throws InvalidUserException
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(233, "Patrick");
		Forum.User user2 = forum.new User(233, "Patrick");
		forum.addingNewUser(user);
		
		assertThrows(InvalidUserException.class, () ->
		{
			forum.addingNewUser(user2);
		});
		
	}
	
	@Test
	void deletingUserAndUserThatDoesntExist() throws InvalidUserException
	{
		//method shows us that user has been deleted as when we try to delete it twice the exception is activated showing it was deleted the first time
		//also shows us you cant delete something without a valid userID as the exception is activated
		Forum forum = new Forum();
		Forum.User user = forum.new User(233, "Patrick");
		
		forum.addingNewUser(user); 
		
		forum.deletingUser(user.getUserID());
		
		assertThrows(InvalidUserException.class, () -> 
		{
			forum.deletingUser(user.getUserID());
		});
		
		
	}
	
	@Test
	void addingForumPostToForum() throws InvalidUserException
	{
		Forum forum = new Forum();
		Forum.User user =  forum.new User(233, "Patrick");
		ForumPost forumPost = new ForumPost("Mileage", "Colorado buffaloes cover lots of miles", 233);
		forum.addingNewUser(user);//have to add user to forum in order for post to be posted
		forum.addForumPost(forumPost);
		
		assertTrue(forum.forumPosts.get(0) == forumPost); //if the forumPost is the same as the post in the array then the post has been posted
		
	   
	}
	
	@Test
	void addingForumPostWithoutRegisteredUser() throws InvalidUserException
	{
		Forum forum = new Forum();
		Forum.User user =  forum.new User(233, "Patrick");
		ForumPost forumPost = new ForumPost("Mileage", "Colorado buffaloes cover lots of miles", 233);
		
		
		assertThrows(InvalidUserException.class, () -> //should throw an exception as although user object has been created it hasnt been registered to the forum so should throw exception
		{
			forum.addForumPost(forumPost);
		});
	}
	
	
	

}
