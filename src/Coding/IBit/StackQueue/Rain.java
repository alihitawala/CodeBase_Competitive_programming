package Coding.IBit.StackQueue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/26/15.
 */
public class Rain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(findWater(a));
    }

    private static int findWater(ArrayList<Integer> a)
    {
        int n = a.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;
        left[0] = a.get(0);
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], a.get(i));
        right[n-1] = a.get(n-1);
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], a.get(i));
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > a.get(i))
                water += min - a.get(i);
        }
        return water;
    }
}