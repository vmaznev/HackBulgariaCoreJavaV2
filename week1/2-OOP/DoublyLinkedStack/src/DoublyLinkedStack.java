
public class DoublyLinkedStack implements Stack {
    
    private DoublyLinkedListImpl linkedList = new DoublyLinkedListImpl();
        
    public DoublyLinkedStack(int maxSize) {}
    
    @Override
    public void push(Object object1) {

        if (this.duplicatedElements(object1)) {
            System.out.println("Stack Already Contains <" + object1 + ">...!");
            System.out.println("Item Won't Be Added...!");  
        }
        
        else {
            linkedList.addEnd((int)object1);
        }
    }

    @Override
    public Object pop() {
        
        if (linkedList.size() == 0) {
            throw new NullPointerException("EMPTY STACK...!");
        }
        
        ListNode elementToPop = linkedList.getTail();
        linkedList.remove(linkedList.size() - 1);
        return elementToPop;
    }

    @Override
    public Object peek() {
        return linkedList.getTail();
    }

    @Override
    public int length() {
        return linkedList.size();
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void printElements() {
        System.out.print("Current Elements: ");
        for(int i = 0; i < this.linkedList.size(); i++) {
            System.out.print(this.linkedList.get(i));
        }
        System.out.println();
    }

    @Override
    public boolean duplicatedElements(Object object1) {
        for(int i = 0; i < this.linkedList.size(); i++) {   
            if(object1.equals(this.linkedList.get(i).data)) {
                return true;
            }
        }
        return false;
    }
    
}
