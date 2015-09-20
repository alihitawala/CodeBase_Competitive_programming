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
            System.out.println(solve4(a));
        }
    }
    private static long[][] cache;
    private static long solve(int[][] a) {
        int x = a.length;
        int y = a[0].length;
        cache = new long[x][y];
        boolean[][] b = new boolean[x][y];
        return solve3(a, 0, 0, b);
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
    private static long solve2(int[][] a, int i, int j, int sum, boolean[][] b) {
        if (i==a.length-1 && j == a[0].length-1)
            return sum + a[i][j];
        if (i < 0 || i >= a.length || j < 0 || j >=a[0].length) {
            return Integer.MAX_VALUE;
        }
        sum += a[i][j];
        b[i][j] = true;
        long up=Integer.MAX_VALUE, down=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        if (i>0 && !b[i-1][j]) {
            if (cache[i-1][j] > 0)
                up = cache[i-1][j] + sum - a[i][j];
            else
                up = solve2(a, i - 1, j, sum, b);
        }
        if (j>0 && !b[i][j-1]) {
            if (cache[i][j-1] > 0)
                left = cache[i][j-1] + sum - a[i][j];
            else
                left = solve2(a, i, j - 1, sum, b);
        }
        if (i!=a.length-1 && !b[i+1][j]) {
            if (cache[i+1][j] > 0)
                down = cache[i+1][j] + sum - a[i][j];
            else
                down = solve2(a, i + 1, j, sum, b);
        }
        if (j!=a[0].length-1 && !b[i][j+1]) {
            if (cache[i][j+1] > 0)
                right = cache[i][j+1] + sum - a[i][j];
            else
                right = solve2(a, i, j + 1, sum, b);
        }
        b[i][j]=false;
        cache[i][j] =  Math.min(Math.min(up, down), Math.min(left, right)) - sum + a[i][j];
        return cache[i][j] + sum - a[i][j];
    }
    private static long solve3(int[][] a, int i, int j, boolean[][] b) {
        if (i==a.length-1 && j == a[0].length-1) {
            cache[i][j] = a[i][j];
            return a[i][j];
        }
        if (i < 0 || i >= a.length || j < 0 || j >=a[0].length) {
            return Integer.MAX_VALUE;
        }
        b[i][j] = true;
        long up=Integer.MAX_VALUE, down=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        if (i>0 && !b[i-1][j]) {
            if (cache[i-1][j] > 0)
                up = cache[i-1][j];
            else
                up = solve3(a, i - 1, j, b);
        }
        if (j>0 && !b[i][j-1]) {
            if (cache[i][j-1] > 0)
                left = cache[i][j-1];
            else
                left = solve3(a, i, j - 1, b);
        }
        if (i!=a.length-1 && !b[i+1][j]) {
            if (cache[i+1][j] > 0)
                down = cache[i+1][j];
            else
                down = solve3(a, i + 1, j, b);
        }
        if (j!=a[0].length-1 && !b[i][j+1]) {
            if (cache[i][j+1] > 0)
                right = cache[i][j+1];
            else
                right = solve3(a, i, j + 1, b);
        }
        b[i][j]=false;
        cache[i][j] =  Math.min(Math.min(up, down), Math.min(left, right)) + a[i][j];
        return cache[i][j];
    }

    private static long solve4(int[][] a) {
        int [][] temp = new int[a.length][a[0].length];
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                temp[i][j] = count;
                count++;
            }
        }
        int totalLength = a.length * a[0].length;
        int[][] adjMatrix = new int[totalLength+1][totalLength+1];
        for (int i = 0; i < totalLength + 1; i++) {
            for (int j = 0; j < totalLength + 1; j++) {
                adjMatrix[i][j] = -1;
            }
        }
        adjMatrix[0][1] = a[0][0];
        adjMatrix[1][0] = a[0][0];
        a[0][0] = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int t = (i*a[0].length) + j+1;
                if (i!=0) {
                    adjMatrix[t][temp[i-1][j]] = a[i-1][j];
                }
                if (j!=0) {
                    adjMatrix[t][temp[i][j-1]] = a[i][j-1];
                }
                if (i<a.length-1) {
                    adjMatrix[t][temp[i+1][j]] = a[i+1][j];
                }
                if (j<a[0].length-1) {
                    adjMatrix[t][temp[i][j+1]] = a[i][j+1];
                }
            }
        }
        return (long) solve(adjMatrix, 0);
    }

    private static double solve(int[][] adMatrix, int num) {
        int V = adMatrix.length;
        double[][] distTo = new double[V][V];

        // initialize distances to infinity
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
                distTo[v][w] = Double.POSITIVE_INFINITY;
            }
        }
        for (int v = 0; v < adMatrix.length; v++) {
            for (int i = 0; i < adMatrix.length; i++) {
                if (adMatrix[v][i] > -1)
                    distTo[v][i] = adMatrix[v][i];
            }
        }
        // Floyd-Warshall updates
        for (int i = 0; i < V; i++) {
            // compute shortest paths using only 0, 1, ..., i as intermediate vertices
            for (int v = 0; v < V; v++) {
                for (int w = 0; w < V; w++) {
                    if (v == w || v == i || w == i)
                        continue;
                    if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
                        distTo[v][w] = distTo[v][i] + distTo[i][w];
                    }
                }
            }
        }
        return distTo[0][V-1];
    }
}
/*
0 3 0 0 0
0 3 0 9 0
0 7 0 5 0
0 0 0 2 5
 */
