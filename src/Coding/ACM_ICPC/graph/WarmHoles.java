package Coding.ACM_ICPC.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/9/15.
 */
public class WarmHoles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int w = in.nextInt();
                Edge e = new Edge(x,y,w);
                edges.add(e);
            }
            boolean isNegativeCycle = isNegativeCycleExists(edges, n);
            String result = isNegativeCycle ? "possible" : "not possible";
            System.out.println(result);
        }
    }

    private static boolean isNegativeCycleExists(List<Edge> a, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 20000;
        }
        dist[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : a) {
                if (dist[e.v] > dist[e.u] + e.w) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        for (Edge e : a) {
            if (dist[e.v] > dist[e.u] + e.w) {
                return true;
            }
        }
        return false;
    }

    static class Edge {
        int v;
        int u;
        int w;

        public Edge(int u, int v, int w) {
            this.v = v;
            this.u = u;
            this.w = w;
        }
    }
}
