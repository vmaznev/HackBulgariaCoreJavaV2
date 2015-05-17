import java.io.File;

public class ReduceFilePath {
    
    public static String reduceFilePath(String filePath) {
        return new File(filePath).toPath().normalize().toString();
    }
    
    public static void main(String[] arguments) {
        System.out.println(reduceFilePath("/etc/../etc/../etc/../"));
        System.out.println(reduceFilePath("/srv/./././././"));
        System.out.println(reduceFilePath("/home//radorado/code/./hackbulgaria/week0/../"));
        
    }
}