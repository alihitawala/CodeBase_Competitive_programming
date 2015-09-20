package Coding.ACM_ICPC.graph;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/14/15.
 */
public class NumberMaze_FW {
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
