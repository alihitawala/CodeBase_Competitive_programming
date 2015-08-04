package Coding.ProgInt;

import java.util.Stack;

/**
 * Created by aliHitawala on 8/3/15.
 */
public class InfixToPostFix {
    public static void main(String[] args) {
        String a = "(300+23)*(43-21)/(84+7)";
        System.out.println(convert(a));
    }
    private static int precedenceValue(char operator) {
        switch (operator) {
            case ')':
            case '(':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
        }
        return -1;
    }

    public static String convert(String exp) {
        StringBuilder result = new StringBuilder("");
        Stack<Character> expressionStack = new Stack<>();
        for (int i=0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if (isOperand(c)) {
                result.append(c);
            }
            else {
                result.append(" ");
                int value = precedenceValue(c);
                if (c=='(')
                    expressionStack.push(c);
                else if (c == ')') {
                    while (expressionStack.peek() != '(')
                        result.append(expressionStack.pop());
                    expressionStack.pop();
                }
                else {
                    while(!expressionStack.empty()
                            && expressionStack.peek() >= value && expressionStack.peek() != '(')
                        result.append(expressionStack.pop());
                    expressionStack.push(c);
                }
            }
        }
        while (!expressionStack.empty())
            result.append(" " + expressionStack.pop());
        return result.toString();
    }

    public static boolean isOperand(char exp) {
        return precedenceValue(exp) == -1;
    }
}
