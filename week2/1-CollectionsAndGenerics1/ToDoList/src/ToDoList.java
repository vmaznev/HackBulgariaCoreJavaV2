import java.util.PriorityQueue;

public class ToDoList {
    private float timeRemaining;
    private PriorityQueue<Task> myTasks;
    
    public ToDoList(float timeRemaining) {
        this.timeRemaining = timeRemaining;
        this.myTasks = new PriorityQueue<Task>(new ToDoListComparator());
    }
    
    public void add (Task t) {
        this.myTasks.add(t);
        this.setTimeRemaining(this.getTimeRemaining() - t.getTimeRequired());
    }
    
    public void markFinished (Task t) {
        t.setTaskFinished(true);
        this.setTimeRemaining(this.getTimeRemaining() - t.getTimeRequired());
    }
    
    public void markCancelled (Task t) {
        t.setTaskCancelled(true);
        this.setTimeRemaining(this.getTimeRemaining() + t.getTimeRequired());
    }
    
    public Task getTop() {
        return this.myTasks.peek();
    }
    
    public boolean canFinish() {
        if(this.getTimeRemaining() > 0) {
            return true;
        }
        return false;
    }
    
    public float getTimeNeeded() {
        float timeNeeded = 0;
        
        for(Task task : myTasks) {
            timeNeeded = timeNeeded + task.getTimeRequired();
        }
        
        return timeNeeded;
    }
    
    public float getTimeRemaining() {
        return timeRemaining;
    }
    
    public void setTimeRemaining(float timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
        
}
