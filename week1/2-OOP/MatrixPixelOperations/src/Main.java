
public class Main {
    public static void main(String[] arguments) {
        Pixel myPixel = new Pixel(20, 30, 40);
        
        System.out.println(myPixel.toString());
        System.out.println();

        Pixel[][] pixelMatrix = {{myPixel, myPixel}, {myPixel, myPixel}, {myPixel, myPixel}};
        Matrix matrix = new Matrix(pixelMatrix);
        
        matrix.setPixel(2, 0, new Pixel(120, 1, 10));
        System.out.println(matrix.toString());
        
        matrix.operate(new BrightnessReduce(3));
        System.out.println(matrix.toString());
        
        matrix.operate(new Grayscale());
        System.out.println(matrix.toString());
    }
}
