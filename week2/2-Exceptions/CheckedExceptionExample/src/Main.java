
public class Main {
    
    public static void useService() throws ServiceNotAvailableAtTheMoment {
        throw new ServiceNotAvailableAtTheMoment("Service Broke Down! Please Try Again Later...!");
    }
    
    public static void main(String[] arguments) throws ServiceNotAvailableAtTheMoment {
        useService();
    }
}
