
public class StudyForAlgebraTask extends Task {

    private String taskName = "StudyForAlgebraTask";
    
    public StudyForAlgebraTask(float timeRequired) {
        super(timeRequired);
    }
    
    public StudyForAlgebraTask(float timeRequired, int taskPriority) {
        super(timeRequired, taskPriority);
    }

    @Override
    public String toString() {
        return this.taskName;
    }
    
}
