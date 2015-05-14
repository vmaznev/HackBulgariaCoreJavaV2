
public class Main {
    public static void main(String[] arguments) {
        User someUser = new User("RandomGuy", "qwerty"); // DatabaseCorruptedException will not be thrown...!
        User someOtherUser = new User("", "1234567"); // DatabaseCorruptedException will be thrown...!
    }
}
