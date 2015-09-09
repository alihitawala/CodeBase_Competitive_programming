package Coding.ACM_ICPC.graph;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class AllPairShort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = 0;
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x == 0 && y == 0)
                break;
            boolean[][] adMatrix = new boolean[101][101];
            Set<Integer> set = new HashSet<>();
            while (true) {
                adMatrix[x][y] = true;
                set.add(x);
                set.add(y);
                x = in.nextInt();
                y = in.nextInt();
                if (x == 0 && y==0)
                    break;
            }
            int num = set.size();
            tc++;
            Double avg = solve(adMatrix, num);
            DecimalFormat numberFormat = new DecimalFormat("#.000");
            System.out.println("Case " + tc + ": average length between pages = " + numberFormat.format(avg) + " clicks");
        }
    }

    private static double solve(boolean[][] adMatrix, int num) {
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
                if (adMatrix[v][i])
                    distTo[v][i] = 1;
            }
        }
        // Floyd-Warshall updates
        for (int i = 0; i < V; i++) {
            // compute shortest paths using only 0, 1, ..., i as intermediate vertices
            for (int v = 0; v < V; v++) {
                for (int w = 0; w < V; w++) {
                    if (v==w || v==i || w==i)
                        continue;
                    if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
                        distTo[v][w] = distTo[v][i] + distTo[i][w];
                    }
                }
            }
        }
        double sum = 0;
        for (int i = 0; i < V; i++) {
            // compute shortest paths using only 0, 1, ..., i as intermediate vertices
            for (int v = 0; v < V; v++) {
                if (distTo[i][v] != Double.POSITIVE_INFINITY) {
                    sum+=distTo[i][v];
                }
            }
        }
        double combinations = binomial(num, 2) * 2;
        return sum/combinations;
    }

    static long binomial(final int N, final int K) {
        long ret = 1;
        for (int k = 0; k < K; k++) {
            ret = ret * (N-k)/(k+1);
        }
        return ret;
    }
}
