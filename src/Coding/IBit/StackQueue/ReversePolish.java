package Coding.IBit.StackQueue;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aliHitawala on 8/25/15.
 */
public class ReversePolish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        System.out.println(evalRPN(a));
    }

    public static int evalRPN(ArrayList<String> a) {
        Stack<String> stack = new Stack();
        for (String s : a) {
            try {
                int i = Integer.parseInt(s);
                stack.push(String.valueOf(i));
            }
            catch (Exception e) {
                int i = evaluate(stack, s.charAt(0));
                stack.push(String.valueOf(i));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static int evaluate(Stack<String> stack, char c) {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        switch (c) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;
    }

}
