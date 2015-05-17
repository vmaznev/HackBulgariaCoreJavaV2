import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WCCommand {
    public static WordCountResult wordCount(Path pathToFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathToFile.toString()));
        
        String currentLine = "";
        String allTheLines = "";
        
        int lineCounter = 0;
        int wordCounter = 0;
        int characterCounter = 0;
        
        String[] allTheWords;
        
        char[] allTheChars;
        
        while((currentLine = br.readLine()) != null) {
            lineCounter++;
            allTheLines = allTheLines + currentLine;
        }
        
        allTheWords = allTheLines.split("\\s+");
        wordCounter = allTheWords.length;
        
        allTheChars = allTheLines.toCharArray();
        characterCounter = allTheChars.length;
        
        br.close();
        
        return new WordCountResult(lineCounter, wordCounter, characterCounter);
    }
    
    public static WordCountResult wordCount(File someFile) throws IOException {
        return wordCount(someFile.toPath());
    }
}
