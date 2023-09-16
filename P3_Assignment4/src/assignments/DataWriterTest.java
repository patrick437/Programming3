package assignments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class DataWriterTest {

	
	
	@Test
	void testIfValuesTransferred() throws IOException {
		
		DataWriter.writeLandDataToFile("States", "Arable Land", 11617883.3);
		DataWriter.writeLandDataToFile("States", "Permanent GrassLand", 27295790);
		Path fileName = Path.of("C:\\Users\\Patrick Noonan\\P3_Assignmnet4\\State.txt");
		Path fileName2 = Path.of("C:\\Users\\Patrick Noonan\\P3_Assignmnet4\\States.txt");
		String str = Files.readString(fileName);
		String str1 = Files.readString(fileName2);
		
		System.out.println(str);
		
		assertTrue(str.equals(str1));
		
	}

}
