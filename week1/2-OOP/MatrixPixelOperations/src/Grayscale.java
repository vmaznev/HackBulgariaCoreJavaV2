
public class Grayscale implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        return new Pixel(matrix[x][y].getRed() * (float) 0.299, matrix[x][y].getGreen() * (float) 0.587,
                matrix[x][y].getBlue() * (float) 0.144);
    }
    
}