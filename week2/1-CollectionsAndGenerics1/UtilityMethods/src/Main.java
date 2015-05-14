import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] arguments) {
        
        // >>>>> RotateCollection <<<<<
        
        List<String> someStrings = new ArrayList<String>();
        
        someStrings.add("one");
        someStrings.add("two");
        someStrings.add("three");
        someStrings.add("four");
        someStrings.add("five");
        someStrings.add("six");
        someStrings.add("seven");
        
        UtilityMethods.rotate(someStrings, -3);
        
        System.out.println("RotateCollection...!");
        System.out.println(someStrings);
        System.out.println();
        
        // >>>>> FirstUniqueElement <<<<<
        
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);
        System.out.println("FirstUniqueElement...!");
        System.out.println(UtilityMethods.firstUnique(ints));
        System.out.println();
        
        // >>>>> DuplicatingElementsInSets <<<<<
        
        Set<Integer> firstSet = new HashSet<Integer>();
        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(3);
        firstSet.add(4);
        firstSet.add(5);
        
        Set<Integer> secondSet = new HashSet<Integer>();
        secondSet.add(4);
        secondSet.add(5);
        secondSet.add(6);
        
        Set<Integer> thirdSet = new HashSet<Integer>();
        thirdSet.add(5);
        thirdSet.add(6);
        thirdSet.add(7);
        thirdSet.add(8);
        
        System.out.println("DuplicatingElementsInSets...!");
        System.out.println(UtilityMethods.duplicatingElements(firstSet, secondSet, thirdSet));
        System.out.println();
        
        // >>>>> ConvertHashMap <<<<<
        
        HashMap<Integer, String> daysOfTheWeek = new HashMap<Integer, String>();

        daysOfTheWeek.put(1, "Monday");
        daysOfTheWeek.put(2, "Tuesday");
        daysOfTheWeek.put(3, "Wednesday");
        daysOfTheWeek.put(4, "Thursday");
        daysOfTheWeek.put(5, "Friday");
        daysOfTheWeek.put(6, "Saturday");
        daysOfTheWeek.put(7, "Sunday");
        
        String result = UtilityMethods.hashMapToString(daysOfTheWeek);
        
        System.out.println("ConvertHashMap...!");
        System.out.println(result);
        System.out.println();
        
        // >>>>> CountWordOccurrences <<<<<
        
        System.out.println("CountWordOccurrences...!");
        System.out.println(UtilityMethods.countWordOccurrences("Ninjas are all over the place! We are all going to die!"));
        System.out.println();
        
    }
}
