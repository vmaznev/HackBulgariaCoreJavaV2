
public interface DoublyLinkedList {
    void addBeginning(int node);
    
    void addEnd(int node);
    
    void remove(int node);
    
    int size();
    
    ListNode get(int index);
    
    ListNode getHead();
    
    ListNode getTail();
    
    public void clear();
    
    public boolean isEmpty();
}
