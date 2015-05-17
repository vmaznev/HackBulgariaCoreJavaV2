
public class WordCountResult {
    private int lineCount;
    private int wordCount;
    private int characterCount;
    
    public WordCountResult(int lineCount, int wordCount, int characterCount) {
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.characterCount = characterCount;
    }
    
    public int getLineCount() {
        return this.lineCount;
    }
    public int getWordCount() {
        return this.wordCount;
    }
    public int getCharacterCount() {
        return this.characterCount;
    }
    
}