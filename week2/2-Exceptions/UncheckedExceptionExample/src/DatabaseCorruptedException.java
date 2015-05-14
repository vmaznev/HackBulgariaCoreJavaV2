
public class DatabaseCorruptedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseCorruptedException(String userMessage) {
        super(userMessage);
    }
}
