import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleTextFileCompressionTest {

    private File testFile;
    
    @Before
    public void init() {
        testFile = new File("../../1-Files-Paths-StreamsUSAGE/NewFile.txt");    
    }
    
    @Test
    public void test() throws IOException {
        FileUtils fileUtils = FileUtils.getInstance();

        String testText = "buffalo buffalo buffalo rides a buffalo buffalo buffalo.";       
        fileUtils.writeTo(testFile, testText);
        
        SimpleTextFileCompression.compress(testFile.toPath());
        
        File compressedText = new File("../../1-Files-Paths-StreamsUSAGE/CompressedTextFile.txt");
        
        String textAfterCompression = "~0 ~0 ~0 ~1 ~2 ~0 ~0 ~0.";
        String textBeforeCompression = fileUtils.readFrom(compressedText);
        
        File compressionWords = new File("../../1-Files-Paths-StreamsUSAGE/CompressionWords.txt");
        
        SimpleTextFileCompression.decompress(compressedText.toPath(), compressionWords.toPath());
        
        String textAfterDecompression = testText;
        String textBeforeDecompression = fileUtils.readFrom(new File("../../1-Files-Paths-StreamsUSAGE/DecompressedTextFile.txt"));
        
        assertEquals(textAfterCompression.equals(textBeforeCompression), true);
        assertEquals(textAfterDecompression.equals(textBeforeDecompression), true);
        
    }
    
    @After
    public void tearDown() {
        testFile.delete();
    }

}
