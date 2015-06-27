package Coding.CodeChef.Misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliHitawala on 2/1/15.
 */
class MinStack {
    private List<Integer> stack = new ArrayList<Integer>();
    private List<Integer> minStackList = new ArrayList<Integer>();
    public void push(int x) {
        stack.add(x);
        if (minStackList.size() == 0 || minStackList.get(minStackList.size()-1) > x)
        {
            minStackList.add(x);
        }
        else
        {
            minStackList.add(minStackList.get(minStackList.size()-1));
        }
    }

    public void pop() {
        if (this.top() < 0)
            return;
        stack.remove(this.top());
        minStackList.remove(this.top());
    }

    public int top() {
        return stack.size()-1;
    }

    public int getMin() {
        return minStackList.get(this.top());
    }
}
