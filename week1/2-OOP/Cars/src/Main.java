
public class Main {
    public static void main(String[] arguments) {
        Car myBMW = new BMW();
        Car myAudi = new Audi(30);
        Car myVolkswagen = new Volkswagen();
        Car myLamborgini = new Lamborgini();
        
        System.out.println("This Object Is: " + myBMW);
        System.out.println("This Object Is: " + myAudi);
        System.out.println("This Object Is: " + myVolkswagen);
        System.out.println("This Object Is: " + myLamborgini);
    }
}