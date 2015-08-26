package Coding.IBit.StackQueue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aliHitawala on 8/25/15.
 */
public class Histogram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Pair> stack = new Stack<>();
        int answer = 0;
        int i = 0;
        for (; i < a.size(); i++) {
            int x = a.get(i);
            if (i==0 || x >= a.get(i-1) || stack.isEmpty()) {
                Pair p = new Pair(x, i);
                stack.push(p);
            }
            else {
                int temp = getValue(stack, x, i);
                if (temp > answer)
                    answer = temp;
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Pair p = stack.pop();
                int temp = p.num * (i - p.index);
                if (temp > answer)
                    answer = temp;
            }
        }
        return answer;
    }

    private static int getValue(Stack<Pair> stack, int currentValue, int index) {
        int max = 0;
        int indexSmallest = index;
        while (!stack.isEmpty() && currentValue <= stack.peek().num) {
            Pair p = stack.pop();
            int temp = p.num * (index - p.index);
            if (temp > max)
                max = temp;
            indexSmallest = p.index;
        }
        stack.push(new Pair(currentValue, indexSmallest));
        return max;
    }

    static class Pair {
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
