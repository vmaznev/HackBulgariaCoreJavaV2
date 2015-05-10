import java.util.Calendar;

public class TimeFactory {
    public static Time getCurrentTime() {
        Calendar someCalendar = Calendar.getInstance();
        
        return new Time(someCalendar.get(Calendar.HOUR_OF_DAY), someCalendar.get(Calendar.MINUTE), 
                someCalendar.get(Calendar.SECOND), someCalendar.get(Calendar.DAY_OF_MONTH), 
                someCalendar.get(Calendar.MONTH), someCalendar.get(Calendar.YEAR));
    }
}