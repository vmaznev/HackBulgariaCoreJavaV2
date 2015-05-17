import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleTextFileCompression {
    
    public static void compress(Path filePath) throws IOException {
        
        FileUtils fileUtils = FileUtils.getInstance();
        String allContent = fileUtils.readFrom(filePath);
        
        Map<String, Integer> myMap = new LinkedHashMap<String, Integer>();
        
        String[] allWords = allContent.split("\\W+");
        int currentWordIndexInHashMap = 0;
        String[] allNonWords = allContent.split("\\w+");
        int nonWordsIndex = 1; // There is nothing before the first word...!
                
        StringBuilder compressedText = new StringBuilder();
        
        for(String currentWord : allWords) {
            
            if(!(myMap.containsKey(currentWord))) {
                myMap.put(currentWord, currentWordIndexInHashMap);
                compressedText.append("~" + (currentWordIndexInHashMap));
                currentWordIndexInHashMap++;
            }
            else {
                compressedText.append("~" + myMap.get(currentWord));
            }
            
            compressedText.append(allNonWords[nonWordsIndex]);
            nonWordsIndex++;
        }
                
        StringBuilder wordsCopy = new StringBuilder();
        
        for(Entry<String, Integer> entry : myMap.entrySet()) {
            wordsCopy.append(entry.getKey());
            wordsCopy.append(";");
        }
        
        System.out.println();
        
        fileUtils.writeTo(new File("../../1-Files-Paths-StreamsUSAGE/CompressionWords.txt"), wordsCopy.toString());
        
        File newFile = new File("../../1-Files-Paths-StreamsUSAGE/CompressedTextFile.txt");
        fileUtils.writeTo(newFile, compressedText.toString());
    }
    
    public static void decompress(Path filePath, Path mapFilePath) throws IOException {
        
        FileUtils fileUtils = FileUtils.getInstance();
        String wordsCopy = fileUtils.readFrom(mapFilePath).trim();
        String[] allWords = wordsCopy.split(";");
        int currentWordIndexInHashMap = 0;
        
        Map<Integer, String> myMap = new LinkedHashMap<Integer, String>();
        
        for(int i = 0; i < allWords.length; i++) {
            myMap.put(currentWordIndexInHashMap, allWords[i]);
            currentWordIndexInHashMap++;
        }
        
        String compressedContent = fileUtils.readFrom(filePath);
        String[] allDigits = compressedContent.split("\\D+");
        int allDigitsIndex = 1; // There is no digit before the first non-digit...!
        String[] allNonWords = compressedContent.split("~\\d+");
        int nonWordsIndex = 1; // There is nothing before the first regex..!
        
        StringBuilder decompressedText = new StringBuilder();
        
        for(int i = 0; i < allNonWords.length - 1; i++) {
            
            
            decompressedText.append(myMap.get((Integer.parseInt(allDigits[allDigitsIndex]))));
            allDigitsIndex++;
            decompressedText.append(allNonWords[nonWordsIndex]);
            nonWordsIndex++;
        }
        
        fileUtils.writeTo(new File("../../1-Files-Paths-StreamsUSAGE/DecompressedTextFile.txt"), decompressedText.toString());
        
    }
}