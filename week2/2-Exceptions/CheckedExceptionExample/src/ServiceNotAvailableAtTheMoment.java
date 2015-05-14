
public class ServiceNotAvailableAtTheMoment extends Exception {

    private static final long serialVersionUID = 1L;

    public ServiceNotAvailableAtTheMoment (String userMessage) {
        super(userMessage);
    }
    
}
