import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindBrokenLinks {
    public static void findBrokenLinks(Path somePath) throws IOException {
        if(!(somePath.toFile().exists())) {
            throw new InvalidPathException("Path Not Found...!", "Invalid Path...");
        }
        
        for(File file : somePath.toFile().listFiles()) {
            if(file.isDirectory()) {
                findBrokenLinks(file.toPath());
            }
            else {
                if(Files.isSymbolicLink(file.toPath())) {
                    if(Files.readSymbolicLink(file.toPath()) == null) {
                        System.out.println(somePath.toFile() + " Is A Bad Link...!");
                    }
                }
            }
        }
    }
    
    public static void main(String[] arguments) throws IOException {
        findBrokenLinks(Paths.get("F:\\Games"));
        System.out.println("Terminated...!");
    }
}