
public class Car {
    
    @Override
    public String toString() {
        String className;
        className = this.getClass().getName();
        
        String[] classNameArray =  className.split("[.]");
        className = classNameArray[classNameArray.length - 1];
        
        return className;
    }
    
}
