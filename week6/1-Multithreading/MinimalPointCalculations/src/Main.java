import java.util.List;

public class Main {
    public static void main(String[] arguments) throws InterruptedException {
        
        long startTime = System.currentTimeMillis();
        
        final List<Point2D> points = NearestPoint.generatePoints();
        NearestPoint.getNearestPoints(points);

        System.out.println("IT TOOK: " + ((System.currentTimeMillis() - startTime) / 1000) + " SECONDS...!");
    }
}
