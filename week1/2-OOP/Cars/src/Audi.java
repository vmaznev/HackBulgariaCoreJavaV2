
public class Audi extends Car {
    private int mileage;
    
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public Audi(int mileage) {
        this.setMileage(mileage);
    }
    
    @Override
    public String toString() {
        String finalString = "";
        String className = super.toString();
        
        finalString = className + ": " + this.mileage + " mileage";
        
        return finalString;
    }   
}
