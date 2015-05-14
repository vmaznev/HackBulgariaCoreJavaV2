
public class Main {
    
    public final static float sleepTime = 8.0f;
    
    public static void main(String[] arguments) {
        
        
        ToDoList todo = new ToDoList(21);
        
        todo.add(new StudyForAlgebraTask(2, 10));
        todo.add(new LearnGeometryTask(2, 7));
        todo.add(new GoOutTask(1.5f));
        todo.add(new SleepTask(sleepTime, 5));
        
        if(todo.canFinish()) {
            System.out.println("Woohoo...!");
            System.out.println();
        }
        else {
            System.out.println("I Am... Screwed...!");
            System.out.println();
        }
        
        System.out.println("Highest Priority Task: " + todo.getTop());
        System.out.println("Time Needed To Finish Everything: " + todo.getTimeNeeded());
        System.out.println("Remaining Free Time: " + todo.getTimeRemaining());
    }
}
