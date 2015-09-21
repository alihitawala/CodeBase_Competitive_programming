package Coding.ProgInt.Bloom;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/21/15.
 */
public class MoneyBag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(a));
    }

    private static int solve(int[] a) {
        int len = a.length;
        int[][] cache = new int[len+1][len+1];
        for (int gap = 0; gap < len; gap++) {
            for (int i = 0, j = gap; j<len; i++, j++) {
                int x = 0, y=0;
                if (i+1 <=j && a[i+1] > a[j]) {
                    if (i+2 <= j)
                        x = cache[i+2][j];
                }
                else if (i+1 <= j){
                    if (i+1 <= j-1)
                        x = cache[i+1][j-1];
                }
                if (i <= j-1 && a[i] > a[j-1]) {
                    if (i+1 <= j-1)
                        y = cache[i+1][j-1];
                }
                else if (i <= j-1)
                    if (i <= j-2)
                        y = cache[i][j-2];
                cache[i][j] = Math.max(a[i]+x, a[j]+y);
            }
        }
        return cache[0][len-1];
    }
}
