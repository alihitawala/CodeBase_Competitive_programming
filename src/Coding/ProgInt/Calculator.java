package Coding.ProgInt;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 8/3/15.
 */
public class Calculator {
    public static void main(String[] args) {
        String a = "(300+23)*(43-21)/(84+7)";
        String b = "(4+8)*(6-5)/((3-2)*(2+2))";
        System.out.println(calculate(a));
        System.out.println(calculate(b));
    }

    private static double calculate(String infixExp) {
        String exp = InfixToPostFix.convert(infixExp);
        Stack<Double> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(exp);
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.length() > 1 || InfixToPostFix.isOperand(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            }
            else {
                stack.push(computePost(stack, token.charAt(0)));
            }
        }
        return stack.pop();
    }

    private static double computePost(Stack<Double> stack, char operator) {
        double value1 = stack.pop();
        double value2 = stack.pop();
        switch (operator) {
            case '+':
                return value1+value2;
            case '-':
                return value2-value1;
            case '*':
                return value1*value2;
            case '/':
                return value2/value1;
            default:
                throw new RuntimeException("This operator is not supported!");
        }
    }
}
