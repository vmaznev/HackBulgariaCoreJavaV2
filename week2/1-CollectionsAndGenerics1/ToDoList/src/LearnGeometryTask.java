
public class LearnGeometryTask extends Task {

    private String taskName = "LearnGeometryTask";
    
    public LearnGeometryTask(float timeRequired) {
        super(timeRequired);
    }
    
    public LearnGeometryTask(float timeRequired, int taskPriority) {
        super(timeRequired, taskPriority);
    }

    @Override
    public String toString() {
        return this.taskName;
    }

}
