import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestPoint {
    
    private static final double MAX_POSSIBLE_DISTANCE = Double.MAX_VALUE;
    
    public static List<Point2D> generatePoints() {
        List<Point2D> myList = new ArrayList<Point2D>();
        
        for(int i = 0; i < 100_000; i++) {
            myList.add(new Point2D((int)(Math.random() * 10_000), (int)(Math.random() * 10_000)));
        }
        
        return myList;
    }
        
    private static void doCalculations(List<Point2D> inPoints, int indexFrom, int indexTo, Map<Point2D, Point2D> outMap) {
        for(int i = indexFrom; i < indexTo; i++) {
            Point2D ourPoint = inPoints.get(i);
            Point2D nearestPoint = null;
            double closestPointDistance = MAX_POSSIBLE_DISTANCE;
            
            for(int j = 0; j < inPoints.size(); j++) {
                Point2D temp = inPoints.get(j);
                
                double pointDistance = ourPoint.getDistance(temp);
                
                if(pointDistance < closestPointDistance) {
                    closestPointDistance = pointDistance;
                    nearestPoint = temp;
                }
                
            }
            
            outMap.put(ourPoint, nearestPoint);
        }
    }
    
    public static Map<Point2D, Point2D> getNearestPoints(final List<Point2D> generatedPoints) throws InterruptedException {
        final Map<Point2D, Point2D> finalMap = new HashMap<Point2D, Point2D>();
        
         // With 4 threads it executes almost two times faster than with 2 threads...!
        
        System.out.println("2 THREADS RUNNING...!");
        
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                NearestPoint.doCalculations(generatedPoints, 0, 50_000, finalMap);
            }
        });
        
        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                NearestPoint.doCalculations(generatedPoints, 50_000, 100_000, finalMap);
            }
        });
        
        
        T1.start();
        T2.start();
        
        T1.join();
        T2.join();
        
        return finalMap;
    }
}
