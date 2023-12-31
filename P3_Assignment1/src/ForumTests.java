
//Patrick Noonan(20355426)

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ForumTests {
	
	@Test
	void testAutoGeneratedTimestampConstructor() throws TimeStampException
	{
		Forum forum = new Forum("Mileage", "The colorado buffaloes clock mileage in the off season"); //creating a forum object using the auto generated timestamp constructor
		
		assertFalse("The title is not equal to kilometrage",forum.getTitle().equals("kilometrage"));//seeing how the assertFalse assertion works
		
		assertTrue(forum.getTitle().equals("Mileage")); //test if the title is equal to milage
		
		assertEquals( forum.queryText(), "The colorado buffaloes clock mileage in the off season");//test is the post variable is being applied correctly and queryText() method is working correctly
		
		assertNotSame( forum.queryTitle(), forum.queryText());
		
		//tests if the timestamp is correct, I attempted to go between two certain timestamps as the .now() of the time of the code running and .now() of the test running maybe different 
		assertTrue(forum.queryTimestamp().isBefore(LocalDateTime.now()) || forum.queryTimestamp().isAfter(LocalDateTime.now().minusNanos(1000)));
	}
	
	@Test
	void testConstructorWithThreeEntries() throws TimeStampException
	{
		LocalDateTime timestamp = LocalDateTime.now().plusDays(5);
		Forum forums = new Forum("Driving licence", "You have to do 12 driving lessons to get your driving licenece", timestamp);
		
		assertTrue(forums.getTitle().equals("Driving licence")); //test if the title is correctly assigned and method returns correct title
		
		assertEquals(forums.queryText(), "You have to do 12 driving lessons to get your driving licenece" );//tests if the post is being assigned to correct variable and the method is returning correct variable
	
	}
	
	@Test
	void testIfInvalidTimeIsReturned()
	{
		LocalDateTime timestamp = LocalDateTime.now().minusDays(5);
		
		assertThrows(TimeStampException.class, () -> 
		{
			Forum forums = new Forum("Driving licence", "You have to do 12 driving lessons to get your driving licenece", timestamp);
		});
	}
	
	@Test
	void testIfTheForumIDs()
	{
		Forum forum = new Forum("Noise Complaint", "The neighbours were too noisy last night");
		Forum forummm = new Forum("Exam Results", "Exam results will be availible in the next two weeks");
		
		assertFalse(forum.getForumID().equals(forummm.getForumID()) );
	}

}
