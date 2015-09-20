package Coding.ACM_ICPC.graph;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/14/15.
 */
public class NumberMaze_Dijk {
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
        return solve(adjMatrix, 0);
    }

    private static long solve(int[][] adMatrix, int num) {
        return dijkstra(adMatrix, 0);
    }
    private static long dijkstra(int[][] graph, int src)
    {
        int V = graph.length;
        long[] dist = new long[V];
        boolean[] inSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            inSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistanceVertex(dist, inSet);
            inSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!inSet[v] && graph[u][v] != -1 && dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        return dist[V-1];
    }
    private static int minDistanceVertex(long dist[], boolean inSet[])
    {
        long min = Integer.MAX_VALUE;
        int min_index =0;

        for (int v = 0; v < dist.length; v++)
            if (!inSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
}