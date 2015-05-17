import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WCCommandTest {

	private File testFile;
	
	@Before
	public void init() {
		testFile = new File("../../1-Files-Paths-StreamsUSAGE/NewFile.txt");
	}
	
	@Test
	public void test() throws IOException {
		
		FileUtils fileUtils = FileUtils.getInstance();
		String textContent = fileUtils.readFrom(new File("../../1-Files-Paths-StreamsUSAGE/RandomTextFile.txt"));
		fileUtils.writeTo(testFile, textContent);
		
		WordCountResult result = WCCommand.wordCount(testFile);
		
		assertEquals(1, result.getLineCount());
		assertEquals(5, result.getWordCount());
		assertEquals(25, result.getCharacterCount());
	}
	
    @After
    public void tearDown() {
        testFile.delete();
    }

}
