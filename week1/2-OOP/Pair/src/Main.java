
public class Main {
    public static void main(String[] arguments) {
        Pair somePair = new Pair("hello", 5);
        Pair someOtherPair = new Pair("hello", 5);
        
        System.out.println("First Pair: " + somePair.toString());
        System.out.println("Other Pair: " + someOtherPair.toString());
        System.out.println("Equal? --> " + somePair.equals(someOtherPair));
    }
}
