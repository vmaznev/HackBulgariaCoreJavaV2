import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesFileParser {
    public static Map<String, String> convertListToMap(List<String> someList) {
        
        Map<String, String> finalMap = new HashMap<String, String>();
        for (String element : someList) {
            
            String commentString = element.trim();
            
            if(commentString.charAt(0) == '#') {
                continue;
            }
            
            String mapKey = element.split("=", 2)[0].trim();
            String mapValue = element.split("=", 2)[1].trim();
            
            finalMap.put(mapKey, mapValue);
        }
        return finalMap;
    }
    
    public static Map<String, String> parseProperties(File someFile) throws IOException {
        Path pathToFile = someFile.toPath();
        
        List<String> lines = Files.readAllLines(pathToFile, Charset.defaultCharset());
        List<String> finalLines = new ArrayList<String>();
        
        for(String line : lines) {
            finalLines.add(line);
        }
        
        return convertListToMap(finalLines);
    }
}
