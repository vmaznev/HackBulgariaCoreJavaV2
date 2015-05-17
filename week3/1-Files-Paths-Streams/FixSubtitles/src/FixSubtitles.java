import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// This will result in actually bugging the "bad" subtitles, because my OS fixes them automatically...!

public class FixSubtitles {
    public static void fixEncoding(Path filePath) throws IOException {
        Path someFilePath = Paths.get("../../1-Files-Paths-StreamsUSAGE/lost.s04e11.hdtv.xvid-2hd.html");
        List<String> lines = Files.readAllLines(filePath, Charset.forName("Windows-1251"));
        Files.write(someFilePath, lines, StandardCharsets.UTF_8);
    }
    
    public static void main(String[] arguments) throws IOException {
        Path someFilePath = Paths.get("../../1-Files-Paths-StreamsUSAGE/lost.s04e11.hdtv.xvid-2hd.srt");
        fixEncoding(someFilePath);
    }
    
}