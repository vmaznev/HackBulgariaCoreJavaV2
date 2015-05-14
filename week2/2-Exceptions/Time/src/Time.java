import java.util.Scanner;

public class Time {
    private int hour, minute, second;
    private int day, month, year;
    
    public Time(int hour, int min, int sec, int day, int month, int year)
    {
        setHours(hour);
        setMinutes(min);
        setSeconds(sec);
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public Time() {
        Scanner timeScan = new Scanner(System.in);
        
        System.out.print("Enter Hours: ");
        setHours(timeScan.nextInt());
        System.out.print("Enter Minutes: ");
        setMinutes(timeScan.nextInt());
        System.out.print("Enter Seconds: ");
        setSeconds(timeScan.nextInt());
        System.out.print("Enter Day: ");
        setDay(timeScan.nextInt());
        System.out.print("Enter Month: ");
        setMonth(timeScan.nextInt());
        System.out.print("Enter Year: ");
        setYear(timeScan.nextInt());
        
        timeScan.close();
        
    }
    
    public void setHours(int hours) {
        if ((hours < 0) || (hours >= 24)) {
            throw new IllegalArgumentException("Invalid Hours...!");   
        }

        this.hour = hours;
    }

    public void setMinutes(int minutes) {
        if ((minutes < 0) || (minutes >= 60)) {
            throw new IllegalArgumentException("Invalid Minutes...!"); 
        }

        this.minute = minutes;
    }

    public void setSeconds(int seconds) {
        if ((seconds < 0) || (seconds >= 60)) {
            throw new IllegalArgumentException("Invalid Seconds...!"); 
        }

        this.second = seconds;
    }

    public void setDay(int day) {
        if ((day <= 0) || (day >= 32)) {
            throw new IllegalArgumentException("Invalid Day...!");     
        }
         
        this.day = day;
    }

    public void setMonth(int month) {
        if ((month <= 0) || (month > 12)) {
            throw new IllegalArgumentException("Invalid Month...!");   
        }

        this.month = month;
    }

    public void setYear(int year) {
        if ((year < 1) || (year > 3000)) {
            throw new IllegalArgumentException("Invalid Year...!");    
        }
           
        this.year = year;
    }
    
    @Override
    public String toString() {        
        String finalString;
        finalString = String.format("%02d:%02d:%02d %02d.%02d.%02d",
                hour, minute, second, day, month, year);
        return finalString;
    }
    
    public static Time now() {
        return TimeFactory.getCurrentTime();
    }
    
}