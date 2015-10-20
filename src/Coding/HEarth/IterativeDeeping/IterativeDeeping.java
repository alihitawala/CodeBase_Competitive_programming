package Coding.HEarth.IterativeDeeping;

import java.util.Stack;

/**
 * Created by aliHitawala on 10/12/15.
 */
public class IterativeDeeping{
    int[][] adj;
    int goal;
    int source;
    public IterativeDeeping(int[][] a, int source, int goal) {
        this.adj = a;
        this.goal = goal;
        this.source = source;
    }

    public int search() {
        int depth = 0;
        for (int i=0;i<adj.length;i++) {
            if(iterative_search(depth))
                break;
            depth++;
        }
        return depth;
    }

    private boolean iterative_search(int depth) {
        System.out.println("Node visited for the depth :: " + depth);
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        boolean[] visited = new boolean[adj.length];
        visited[source] = true;
        System.out.print(source + ", ");
        int currentDepth = 0;
        while(!stack.isEmpty() && depth != currentDepth) {
            int s = stack.pop();
            if (s == goal)
                return true;
            for (int i=0;i<adj.length;i++) {
                if (adj[s][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + ", ");
                }
            }
            currentDepth++;
        }
        System.out.println();
        return false;
    }
}
