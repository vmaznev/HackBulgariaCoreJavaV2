
public class SleepTask extends Task {
    
    private String taskName = "SleepTask";
    
    public SleepTask(float timeRequired) {
        super(timeRequired);
    }
    
    public SleepTask(float timeRequired, int taskPriority) {
        super(timeRequired, taskPriority);
    }

    @Override
    public String toString() {
        return this.taskName;
    }

}
