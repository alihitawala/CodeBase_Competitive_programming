package Coding.ACM_ICPC.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/9/15.
 */
public class NumberMaze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = in.nextInt();
                }
            }
            System.out.println(solve(a));
        }
    }

    private static int solve(int[][] a) {
        int x = a.length;
        int y = a[0].length;
        boolean[][] b = new boolean[x][y];
        return solve2(a, 0, 0, 0, b);
//        int x = a.length;
//        int y = a[0].length;
//        int[][] cache = new int[x+1][y+1];
//        for (int i = 0; i < x + 1; i++) {
//            cache[i][0] = 10000;
//        }
//        for (int i = 0; i < y + 1; i++) {
//            cache[0][i] = 10000;
//        }
//        cache[1][1] = a[0][0];
//        for (int i = 1; i < x + 1; i++) {
//            for (int j = 1; j < y + 1; j++) {
//                if (i==1 && j==1)
//                    continue;
//                cache[i][j] = Math.min(cache[i-1][j], cache[i][j-1]) + a[i-1][j-1];
//            }
//        }
//        return cache[x][y];
    }
    private static int solve2(int[][] a, int i, int j, int sum, boolean[][] b) {
        if (i==a.length-1 && j == a[0].length-1)
            return sum + a[i][j];
        if (i < 0 || i >= a.length || j < 0 || j >=a[0].length) {
            return Integer.MAX_VALUE;
        }
        sum += a[i][j];
        b[i][j] = true;
        int up=Integer.MAX_VALUE, down=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        if (i>0 && !b[i-1][j])
            up = solve2(a, i-1, j, sum, b);
        if (j>0 && !b[i][j-1])
            left = solve2(a, i, j-1, sum, b);
        if (i!=a.length-1 && !b[i+1][j])
            down = solve2(a, i+1, j, sum, b);
        if (j!=a[0].length-1 && !b[i][j+1])
            right = solve2(a, i, j+1, sum, b);
        b[i][j]=false;
        return Math.min(Math.min(up, down), Math.min(left, right));
    }
}
