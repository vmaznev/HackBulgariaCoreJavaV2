import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ReverseGenericCollection {

    public static <T> void reverse(Collection<T> collection) {
        
        Stack<T> collectionStack = new Stack<T>();
        Iterator<T> collectionIterator = collection.iterator();
        
        while(collectionIterator.hasNext()) {
            collectionStack.push(collectionIterator.next());
        }
        
        collection.clear();
        
        while(!(collectionStack.isEmpty())) {
            collection.add(collectionStack.pop());
        }
        
    }
    
    public static void main(String[] arguments) {
        List<Integer> randomArrayList = new ArrayList<Integer>();
        randomArrayList.add(5);
        randomArrayList.add(7);
        randomArrayList.add(11);
        reverse(randomArrayList);
        System.out.println(randomArrayList.toString());
    }
}
