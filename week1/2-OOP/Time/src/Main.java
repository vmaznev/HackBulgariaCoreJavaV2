
public class Main {
    public static void main(String[] arguments) {
        Time myTime = new Time(14, 56, 18, 28, 3, 2015);
        Time newMyTime = new Time();
        
        System.out.println("The Time You Entered From The Code Is: " + myTime.toString());        
        System.out.println("The Time You Entered From The Console Is: " + newMyTime.toString());
        System.out.println("The Current Time Is: " + Time.now());
    }
}