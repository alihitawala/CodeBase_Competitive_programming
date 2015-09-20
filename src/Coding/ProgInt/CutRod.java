package Coding.ProgInt;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/20/15.
 */
public class CutRod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(a));
    }

    private static int solve(int[] a) {
        int len = a.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return a[0];
        int[] cache = new int[len +1];
        for (int i = 0; i < len; i++) {
            int price = a[i];
            for (int j = i+1; j < len+1; j++) {
                cache[j] = Math.max(cache[j], cache[j-1-i] + price);
            }
        }
        return cache[len];
    }
}
