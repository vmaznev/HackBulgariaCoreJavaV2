import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class OnOffCollection<T> implements Collection<T> {

    private ArrayList<T> arrayList;
    
    public OnOffCollection() {
        this.arrayList = new ArrayList<T>();
    }
    
    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            return false;
        }
    
        return this.arrayList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.arrayList.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.arrayList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a == null) {
            return null;
        }
        
        return this.arrayList.toArray(a);
    }

    @Override
    public boolean add(T e) {
        if(e == null) {
            return false;
        }
        
        if(this.arrayList.contains(e)) {
            return false;
        }
        
        return this.arrayList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if(o == null) {
            return false;
        }
        
        return this.arrayList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.arrayList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(c == null) {
            return false;
        }
        
        return this.arrayList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.arrayList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.arrayList.retainAll(c);
    }

    @Override
    public void clear() {
        this.arrayList.clear();
    }
    
    public T get(int index) {
        return this.arrayList.get(index);
    }
    
    public static void main(String[] arguments) {
        OnOffCollection<Integer> myCollection = new OnOffCollection<Integer>();
        
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(3);
        myCollection.add(1);
        
        System.out.print("Elements: ");
        for(int i = 0; i < myCollection.size(); i++) {
            System.out.print(myCollection.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("Size: " + myCollection.size());
        
    }

}
