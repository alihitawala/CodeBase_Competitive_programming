package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/17/15.
 */
public class Adjacent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x =in.nextInt();
                temp.add(x);
            }
            a.add(temp);
        }
        System.out.println(new Adjacent().adjacent(a));
    }

    public int adjacent(ArrayList<ArrayList<Integer>> a) {
        int n = a.get(0).size();
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            int top = a.get(0).get(i);
            int bottom = a.get(1).get(i);
            int max = Math.max(top, bottom);
            if (i == 2)
                cache[i] = Math.max(Math.max(max, max + cache[i-2]), cache[i-2]);
            else if (i>2)
                cache[i] = Math.max(Math.max(Math.max(Math.max(max, max + cache[i-2]), cache[i-2]), cache[i-3] + max), cache[i-3]);
            else
                cache[i] = max;
        }
        return maxArray(cache);
    }

    private int maxArray(int[] cache) {
        int max = Integer.MIN_VALUE;
        for (int i : cache) {
            if (i > max)
                max = i;
        }
        return max;
    }
}
