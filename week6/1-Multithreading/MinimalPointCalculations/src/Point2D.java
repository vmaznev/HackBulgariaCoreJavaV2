
public class Point2D {
    private Integer x;
    private Integer y;
    
    public Point2D(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }

    public double getDistance(Point2D point) {
        double distanceX = point.getX() - this.getX();
        double distanceY = point.getY() - this.getY();
        
        double resultDistance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        return resultDistance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2D other = (Point2D) obj;
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "] ";
    }
}
