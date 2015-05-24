import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static SimpleJUnit junitObject = new SimpleJUnit();
    
    private static List<Method> sortMethodList() {
        List<Method> executable = new ArrayList<>();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();

        Method[] allMethods = junitObject.getClass().getMethods();

        for(Method method : allMethods) {
            if(method.isAnnotationPresent(Before.class)) {
                beforeMethods.add(method);
            }
            else if(method.isAnnotationPresent(Execute.class)) {
                executable.add(method);
            }
            else if(method.isAnnotationPresent(After.class)) {
                afterMethods.add(method);
            }
        }

        List<Method> finalList = new ArrayList<Method>();
        for (Method method : executable) {
            finalList.addAll(beforeMethods);
            finalList.add(method);
            finalList.addAll(afterMethods);
        }
        
        return finalList;
    }
    
    private static void invokeMethods() {
        for (Method method : Main.sortMethodList()) {
            try {
                method.invoke(junitObject);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
    public static void main(String[] arguments) {
        Main.invokeMethods();
    }
}
