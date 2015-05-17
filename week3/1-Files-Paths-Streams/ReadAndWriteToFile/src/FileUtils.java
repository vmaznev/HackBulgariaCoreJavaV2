import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    
    private static FileUtils instance = null;
    
    private FileUtils() {}
    
    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }
    
    public String readFrom(File someFile) throws IOException {
        Path path = someFile.toPath();
        return readFrom(path);
    }
    
    public String readFrom(Path pathToFile) throws IOException {
        List<String> linesInFile = Files.readAllLines(pathToFile, Charset.defaultCharset());
        String finalString = "";
        
        for (String line : linesInFile) {
            finalString = finalString + line;
            
            if(line.equals(linesInFile.get(linesInFile.size() - 1))) {
                continue;
            }
            
            finalString = finalString + "\n";
        }
        
        return finalString;
    }
    
    public void writeTo(File someFile, String someText) throws IOException {
        Path path = someFile.toPath();
        writeTo(path, someText);
    }

    public void writeTo(Path pathToFile, String someText) throws IOException {
        Files.write(pathToFile, someText.getBytes());
    }

}