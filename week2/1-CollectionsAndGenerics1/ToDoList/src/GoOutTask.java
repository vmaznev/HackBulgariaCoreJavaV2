
public class GoOutTask extends Task {

    private String taskName = "GoOutTask";
    
    public GoOutTask(float timeRequired) {
        super(timeRequired);
    }
    
    public GoOutTask(float timeRequired, int taskPriority) {
        super(timeRequired, taskPriority);
    }

    @Override
    public String toString() {
        return this.taskName;
    }

}
