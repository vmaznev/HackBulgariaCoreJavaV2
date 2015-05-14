import java.util.HashSet;

public interface Statistics {
    float getMean();
    
    float getMedian();
    
    HashSet<Integer> getMode();
    
    int getRange();
} 
