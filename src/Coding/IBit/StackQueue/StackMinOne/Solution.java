package Coding.IBit.StackQueue.StackMinOne;

import java.util.Stack;

/**
 * Created by aliHitawala on 8/25/15.
 */
public class Solution {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public Solution() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (!minStack.isEmpty() && minStack.peek() > x) {
            minStack.push(x);
        }
        else if (minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        minStack.pop();
        mainStack.pop();
    }

    public int top() {
        if (mainStack.isEmpty())
            return -1;
        return mainStack.peek();
    }

    public int getMin() {
        if (mainStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
