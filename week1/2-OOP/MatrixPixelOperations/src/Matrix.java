
public class Matrix {
    
    private Pixel[][] matrix;
    
    public Matrix(Pixel[][] matrix){
        this.matrix = matrix;
    }
    
    public void operate(MatrixOperation op) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = op.withPixel(i, j, matrix);
            }
        }
    }
    
    public void setPixel(int x, int y, Pixel pixel) {
        this.matrix[x][y] = pixel;
    }
    
    public Pixel getPixel(int x, int y) {
        return matrix[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                sb.append(getPixel(i, j).toString());
                sb.append(" | ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}
