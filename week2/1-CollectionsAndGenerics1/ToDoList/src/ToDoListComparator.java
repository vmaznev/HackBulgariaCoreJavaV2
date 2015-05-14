import java.util.Comparator;

public class ToDoListComparator implements Comparator<Task> {
    
    @Override
    public int compare(Task o1, Task o2) {
        if(o1.getTaskPriority() > o2.getTaskPriority()) {
            return -1;
        }
        else if(o1.getTaskPriority() < o2.getTaskPriority()) {
            return 1;
        }
        return 0;
    }
}
