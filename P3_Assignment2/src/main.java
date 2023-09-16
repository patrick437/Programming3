//Patrick Noonan(20355426)

public class main {

	public static void main(String[] args) throws InvalidUserException, InvalidTimestampException {
	
		Forum forum = new Forum(); //creating a forum object
		Forum.User user =  forum.new User(2, "Patrick"); //creating a user object
		ForumPost forumPost = new ForumPost("Mileage", "The chicago buffaloes are mileage machine",2);
		ForumApp forumApp = new ForumApp();
		forum.addingNewUser(user);
		forum.addForumPost(forumPost);
		//System.out.println(forum.forumPosts.get(0));
		
		forumApp.chooseYourOption(); // method to call the Forum app
		
	}

}
