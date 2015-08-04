package Coding.ProgInt;


import java.util.Stack;

/**
 * Created by aliHitawala on 8/4/15.
 */
public class HistogramMaxArea {
    public static void main(String[] args) {
        int[] a = {2,4,2,1};
        int[] b = {4,7,6,7,8};
        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
    }
    private static int maxArea(int[] a) {
        Stack<Building> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<a.length;i++) {
            if (stack.isEmpty() || stack.peek().height < a[i]) {
                stack.push(new Building(a[i], i));
            }
            else if (stack.peek().height > a[i]) {
                while (!stack.isEmpty() && stack.peek().height > a[i]) {
                    Building poped = stack.pop();
                    int value = poped.height * (i-poped.index);
                    if (value>max)
                        max=value;
                }
                if (stack.isEmpty() || stack.peek().height != a[i])
                    stack.push(new Building(a[i], i));
            }
        }
        while (!stack.isEmpty()) {
            int i=a.length;
            Building poped = stack.pop();
            int value = poped.height * (i-poped.index);
            if (value>max)
                max=value;
        }
        return max;
    }

    static class Building {
        int height;
        int index;

        public Building(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
/*
4 5 6 7 8
 */

