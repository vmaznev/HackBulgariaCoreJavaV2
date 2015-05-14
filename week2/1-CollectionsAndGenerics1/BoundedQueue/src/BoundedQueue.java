import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BoundedQueue<T> implements Queue<T> {

    private AbstractQueue<T> myQueue;
    private int limit;
    
    public BoundedQueue(int limit) {
        this.myQueue = new PriorityQueue<T>();
        this.limit = limit;
    }
    
    @Override
    public int size() {
        return this.myQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.myQueue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            return false;
        }
        
        return this.myQueue.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.myQueue.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.myQueue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a == null) {
            return null;
        }
        
        return this.myQueue.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return this.myQueue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.myQueue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(c == null) {
            return false;
        }
        
        return this.myQueue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.myQueue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null) {
            return false;
        }
        
        return this.myQueue.retainAll(c);
    }

    @Override
    public void clear() {
        this.myQueue.clear();
    }

    @Override
    public boolean add(T e) {
        if(e == null) {
            return false;
        }
        
        if(this.myQueue.size() == this.limit) {
            this.myQueue.remove();
        }
        
        return this.myQueue.add(e);
    }

    @Override
    public boolean offer(T e) {
        if(e == null) {
            return false;
        }
        
        if(this.myQueue.size() == this.limit) {
            this.myQueue.remove();
        }
        
        return this.myQueue.offer(e);
    }

    @Override
    public T remove() {
        return this.myQueue.remove();
    }

    @Override
    public T poll() {
        return this.myQueue.poll();
    }

    @Override
    public T element() {
        return this.myQueue.element();
    }

    @Override
    public T peek() {
        return this.myQueue.peek();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> myIterator = this.myQueue.iterator();
        
        sb.append("[");
        while(myIterator.hasNext()) {
            sb.append(myIterator.next() + " ");
        }
        sb.append("]");
        
        sb.replace(sb.length() - 2, sb.length() - 1, "");
        
        return sb.toString();
    }
    
    public static void main(String[] arguments) {
        BoundedQueue<Integer> bondedQueue = new BoundedQueue<Integer>(3);   
        bondedQueue.offer(1);
        bondedQueue.offer(2);
        bondedQueue.offer(3);
        bondedQueue.offer(4);
        bondedQueue.offer(5);
        System.out.println("Elements: " + bondedQueue);
    }
    
}
