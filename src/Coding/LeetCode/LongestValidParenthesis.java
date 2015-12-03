package Coding.LeetCode;

import java.util.Stack;

/**
 * Created by aliHitawala on 11/18/15.
 */
public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new Node(i, true));
            }
            else if (stack.isEmpty() || !stack.peek().isOpen) {
                stack.push(new Node(i, false));
            }
            else {
                Node n = stack.pop();
                int left;
                if (stack.isEmpty())
                    left = 0;
                else
                    left = stack.peek().i;
                int temp = i-left+1;
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }

    static class Node {
        int i;
        boolean isOpen;

        public Node(int i, boolean isOpen) {
            this.i = i;
            this.isOpen = isOpen;
        }
    }
}
