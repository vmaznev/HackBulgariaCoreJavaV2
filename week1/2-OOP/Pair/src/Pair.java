
public final class Pair extends Object {
    
    private final Object firstObject;
    private final Object secondObject;
    
    public Pair(Object object1, Object object2) {
        this.firstObject = object1;
        this.secondObject = object2;
    }
    
    @Override
    public String toString() {
        String finalString; 
        
        finalString = this.firstObject.toString() + " " +  this.secondObject.toString();
        
        return finalString;
    }
    
    @Override
    public boolean equals(Object someObject) {
        if(someObject instanceof Pair) {
            Pair otherPair = (Pair) someObject;
            if((this.firstObject.equals(otherPair.firstObject)) &&
                (this.secondObject.equals(otherPair.secondObject))) {
                return true;
            }
        }
        return false;
    }
    
}
