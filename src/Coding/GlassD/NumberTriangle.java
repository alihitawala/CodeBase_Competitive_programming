package Coding.GlassD;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/16/15.
 */
public class NumberTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(calculateMaxPath(a));
    }

    private static int calculateMaxPath(int[][] a) {
        int len = a.length;
        int[][] cache = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i + 1; j++) {
                cache[i][j] = Integer.MIN_VALUE;
            }
        }
        cache[0][0] = a[0][0];
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (a[i+1][j] + cache[i][j] > cache[i+1][j])
                    cache[i+1][j] = a[i+1][j] + cache[i][j];
                if (a[i+1][j+1] + cache[i][j] > cache[i+1][j+1])
                    cache[i+1][j+1] = a[i+1][j+1] + cache[i][j];
            }
        }
        return maxInArray(cache[len-1]);
    }

    private static int maxInArray(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max)
                max = i;
        }
        return max;
    }
}
