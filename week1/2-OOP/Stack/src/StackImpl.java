
public class StackImpl implements Stack {
    
    private int maxSize;
    private Object[] stackArray;
    private int topStack;
    
    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new Object[maxSize];
        topStack = -1;
    }

    @Override
    public void push(Object object1) {
        if (this.duplicatedElements(object1)) {
            System.out.println("Stack Already Contains <" + object1 + ">...!");
            System.out.println("Item Won't Be Added...!");
            
        }
        else {
            this.stackArray[++topStack] = object1;
        }
    }

    @Override
    public Object pop() {
        return this.stackArray[topStack--];
    }
    
    @Override
    public Object peek() {
        return this.stackArray[topStack];
    }

    @Override
    public int length() {
        return this.maxSize;
    }

    @Override
    public void clear() {
        for(int i = this.topStack; i >= 0; i--) {
            this.stackArray[i] = null;
            topStack--;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.topStack == -1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isFull() {
        if((this.topStack + 1)== this.maxSize) {
            return true;
        }
        return false;
    }
    
    @Override
    public void printElements() {
        if(this.topStack >= 0) {
            System.out.print("Current Elements: ");
            for(int i = 0; i <= this.topStack; i++) {
                System.out.print(this.stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean duplicatedElements(Object object1) {
        for(int i = 0; i <= this.topStack; i++) {
            if(stackArray[i].equals(object1)) {
                return true;
            }
        }
        return false;
    }
}
