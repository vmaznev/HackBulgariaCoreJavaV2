
public class Task {
    private float timeRequired;
    private int taskPriority;
    private boolean taskFinished;
    private boolean taskCancelled;
    
    public Task(float timeRequired) {
        this.timeRequired = timeRequired;
        this.taskPriority = 0;
        this.taskFinished = false;
        this.taskCancelled = false;
    }
    
    public Task(float timeRequired, int taskPriority) {
        this.timeRequired = timeRequired;
        this.taskPriority = taskPriority;
        this.taskFinished = false;
        this.taskCancelled = false;
    }
    
    public float getTimeRequired() {
        return this.timeRequired;
    }
    
    public int getTaskPriority() {
        return this.taskPriority;
    }
    
    public void setTaskFinished(boolean taskFinished) {
        this.taskFinished = taskFinished;
    }
    
    public void setTaskCancelled(boolean taskCancelled) {
        this.taskCancelled = taskCancelled;
    }
    
}
