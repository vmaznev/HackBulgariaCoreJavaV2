
public class BrightnessReduce implements MatrixOperation {

    private float factor;
    
    public BrightnessReduce(float factor) {
        this.factor = factor;
    }
    
    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        return new Pixel(matrix[x][y].getRed() / this.factor, matrix[x][y].getGreen() / this.factor,
                matrix[x][y].getBlue() / this.factor);
    }
    
}
