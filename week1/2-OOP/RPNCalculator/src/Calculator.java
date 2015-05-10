import java.util.Stack;

public class Calculator {
    
    private static double factorial(double n) {
        if(n == 0) {
            return 1.0;
        }
        else {
            return n * factorial(n - 1);
        }
    }
    
    private static int tokenPriority(char token) {
        
        if(token == '#' || token == '(') {
            return -1;
        }
        else if(token == '!') {
            return 3;
        }
        else if((token == '^') || (token == '*') || (token == '/')) {
            return 1;
        }
        else if((token == '+') || (token == '-')) {
            return 0;
        }
        
        throw new IllegalArgumentException("No Such Token: " + token + "...!");
    }
    
    private static String cleanExpression(String expression) {
        expression = expression.replaceAll("\\s+","");
        return expression;
    }
    
    private static String convertExpressionToPostfix(String expression) {
        
        expression = cleanExpression(expression);
        
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        
        stack.push('#'); // Beginning Token...! (So We Don't Peek() At Empty Stack)
        
        for(int i = 0; i < expression.length(); i++) {
            
            if(Character.isDigit(expression.charAt(i))) {
                result.append(expression.charAt(i));
                
                while(i + 1 < expression.length()) {
                    if(Character.isDigit(expression.charAt(i + 1))) {
                        result.append('?'); // Indicates If The Number Isn't With Just One Digit...!
                        result.append(expression.charAt(i + 1));
                        i++;
                    }
                    else {
                        break;
                    }
                }
                
                continue;
            }
            
            if(expression.charAt(i) == ')') {
                
                while(!(stack.peek().equals('('))) {
                    result.append(stack.pop());
                }
                stack.pop();
                
                continue;
            }

            if((expression.charAt(i) == '(') || (tokenPriority(expression.charAt(i)) > tokenPriority(stack.peek())) ) {
                stack.push(expression.charAt(i));
            } 
            else {
                while (tokenPriority(expression.charAt(i)) <= tokenPriority(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(expression.charAt(i));
            }
        }
        
        while(!(stack.isEmpty())) {
            result.append(stack.pop());
        }
        
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
    
    public static String calculaterWithRPN(String expression) {
        
        expression = cleanExpression(convertExpressionToPostfix(expression));
        
        Stack<String> result = new Stack<String>();
        
        for(int i = 0; i < expression.length(); i++) {
            
            if(Character.isDigit(expression.charAt(i))) {
                
                if(expression.length() == i + 1) {
                    result.push(String.valueOf(Double.valueOf(expression)));
                    return result.pop();
                }
                
                else {
                    
                    if(expression.charAt(i + 1) == '?') {
                        
                        int tempPosition = i + 1;
                        String finalNumber = expression.charAt(tempPosition-1) + "";
                        
                        while(true) {
                            if(expression.charAt(tempPosition) == '?') {
                                finalNumber = finalNumber + "" + expression.charAt(tempPosition+1);
                            }
                            else {
                                result.push(finalNumber);
                                finalNumber = "";
                                i = tempPosition - 1;
                                break;
                            }
                            tempPosition = tempPosition + 2;
                        }
                    }
                    
                    else {
                        result.push(String.valueOf(expression.charAt(i)));
                    }
                }
            }
            
            else {
                Double tempVariable = Double.valueOf(result.pop());
                
                if(expression.charAt(i) == '+') {
                    result.push(String.valueOf(Double.valueOf(result.pop()) + tempVariable));
                }
                else if(expression.charAt(i) == '-') {
                    result.push(String.valueOf(Double.valueOf(result.pop()) - tempVariable));
                }
                else if(expression.charAt(i) == '*') {
                    result.push(String.valueOf(Double.valueOf(result.pop()) * tempVariable));
                }
                else if(expression.charAt(i) == '/') {
                    result.push(String.valueOf(Double.valueOf(result.pop()) / tempVariable));
                }
                else if(expression.charAt(i) == '^') {
                    result.push(String.valueOf(Math.pow(Double.valueOf(result.pop()), tempVariable)));
                }
                else if(expression.charAt(i) == '!') {
                    result.push(String.valueOf(factorial(tempVariable)));
                }
            }
            
        }
                
        return result.pop();
    }
     
}
