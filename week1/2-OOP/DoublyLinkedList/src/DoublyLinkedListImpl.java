
public class DoublyLinkedListImpl implements DoublyLinkedList {

    int sizeCounter;
    private ListNode head;
    private ListNode tail;
    
    public DoublyLinkedListImpl() {
        this.sizeCounter = 0;
        head = null;
        tail = null;
    }
    
    @Override
    public void addBeginning(int node) {
        ListNode newListNode = new ListNode(node);
        
        if(this.head == null) {
            this.tail = newListNode;
        }
        else {
            this.head.previous = newListNode;
        }
        newListNode.next = this.head;
        this.head = newListNode;
        this.sizeCounter = this.sizeCounter + 1;
        
    }

    @Override
    public void addEnd(int node) {
        ListNode newListNode = new ListNode(node);;
        
        if(this.head == null) {
            this.head = newListNode; 
        }
        else {
            this.tail.next = newListNode;
        }
        newListNode.previous = this.tail;
        this.tail = newListNode;
        this.sizeCounter = this.sizeCounter + 1;
    }
    
    @Override
    public void remove(int node) {
        if((node < 0) || (node > this.sizeCounter - 1)) {
            System.out.println("Bad Index...!");
        }
        else {
            ListNode removeNode = this.head;
            ListNode beforeNode;
            ListNode afterNode;
            int currentIndex = 0;
            
            while(currentIndex < node) {
                removeNode = removeNode.next;
                currentIndex++;
            }
            
            if(removeNode == this.head) {
                this.head = removeNode.next;
            }
            if(removeNode == this.tail) {
                this.tail = removeNode.previous;
            }
            
            if(removeNode.previous != null) {
                beforeNode = removeNode.previous;
                
                beforeNode.next = removeNode.next;
            }
            if(removeNode.next != null) {
                afterNode = removeNode.next;
                
                afterNode.previous = removeNode.previous;
            }
            
            removeNode = null;
            
            this.sizeCounter = this.sizeCounter - 1;
            
        }
            
    }

    @Override
    public int size() {
        return this.sizeCounter;
    }

    @Override
    public ListNode get(int index) {
        if((index < 0) || (index > this.sizeCounter - 1)) {
            System.out.println("Bad Index...!");
            return null;
        }
        
        ListNode ourNode = this.head;
        int currentIndex = 0;
        
        while(currentIndex < index) {
            ourNode = ourNode.next;
            currentIndex++;
        }
        
        return ourNode;
    }

    @Override
    public ListNode getHead() {
        ListNode listHead = this.head;
        
        while(listHead.previous != null) {
            listHead = listHead.previous;
        }
        
        return listHead;
    }

    @Override
    public ListNode getTail() {
        ListNode listTail = this.tail;
        
        while(listTail.next != null) {
            listTail = listTail.next;
        }
        
        return listTail;
    }
    
    public String toString() {
        String finalString = "";
        ListNode current = this.head;
        while(current != null) {
            finalString = finalString + current.toString();
            current = current.next;
            
        }
        
        return finalString;
    }

    @Override
    public void clear() {
        ListNode currentNode = this.head.next;
        ListNode tempNode = currentNode;
        this.head = null;
        
        while(currentNode.next != null) {
            tempNode = currentNode.next;
            currentNode = currentNode.next;
            tempNode = null;
        }
        
        currentNode = null;
        tempNode = null;
        this.tail = null;
        sizeCounter = 0;
        
    }

    @Override
    public boolean isEmpty() {
        return this.tail == null;
    }
    
}
