import java.util.Stack;

public class CheckBracketsExpression {
    
    private static boolean bracketsEquality(String expression) {
        
        Stack<Object> bracketsStack = new Stack<Object>();
        
        if(expression.charAt(0) == ')') {
            return false;
        }
        if(expression.charAt(expression.length() - 1) == '(') {
            return false;
        }
        
        for(int i = 0; i < expression.length(); i++) {
            
            if(expression.charAt(i) == '(') {
                bracketsStack.push(expression.charAt(i));
            }
            
            else if(expression.charAt(i) == ')') {
                bracketsStack.push(expression.charAt(i));
                
                bracketsStack.pop();
                if(bracketsStack.isEmpty()) {
                    return false;
                }
                bracketsStack.pop();
            }
            
        }
        
        if(bracketsStack.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] arguments) {
        System.out.println("Expression Is: " + bracketsEquality("())()"));
        System.out.println("Expression Is: " + bracketsEquality("()()()(()())"));
        System.out.println("Expression Is: " + bracketsEquality("()()())))((())("));
    }
}
