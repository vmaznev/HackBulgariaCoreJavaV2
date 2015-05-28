import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> implements Queue<T> {

    private LinkedList<T> linkedList;
    private int blockingQueueSize;
    
    public BlockingQueue(int blockingQueueSize) {
        this.blockingQueueSize = blockingQueueSize;
        this.linkedList = new LinkedList<T>();
    }
    
    @Override
    public int size() {
        return this.linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.linkedList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.linkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.linkedList.toArray();
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        return this.linkedList.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return this.linkedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.linkedList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.linkedList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.linkedList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.linkedList.retainAll(c);
    }

    @Override
    public void clear() {
        this.linkedList.clear();
    }

    @Override
    public boolean add(T e) {
        return this.linkedList.add(e);
    }

    @Override
    public boolean offer(T e) {
        synchronized (this.linkedList) {
            while (this.linkedList.size() == blockingQueueSize) {
                try {
                    this.linkedList.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            
            boolean result = this.linkedList.offer(e);
            this.linkedList.notifyAll();
            return result;            
        }
    }

    @Override
    public T remove() {
        return this.linkedList.remove();
    }

    @Override
    public T poll() {
        synchronized(this.linkedList) {
            while (this.linkedList.size() == 0) {
                try {
                    this.linkedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            this.linkedList.notifyAll();
            return this.linkedList.poll();
        }
    }

    @Override
    public T element() {
        return this.linkedList.element();
    }

    @Override
    public T peek() {
        return this.linkedList.peek();
    }
    
}
