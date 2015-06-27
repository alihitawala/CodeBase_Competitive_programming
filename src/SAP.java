import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aliHitawala on 5/3/15.
 */
public class SAP {
    private boolean[] marked;
    private int[] steps;
    private Digraph digraph;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        digraph = G;
    }

    private void clearState() {
        marked = new boolean[digraph.V()];
        steps = new int[digraph.V()];
    }

    private void bfs(int source) {
        marked[source] = true;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : digraph.adj(v)) {
                if (!marked[w]) {
                    steps[w] = steps[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }

        }
    }

    private void initMultiNodeBfs() {
        marked = new boolean[digraph.V()];
        steps = new int[digraph.V()];
        for (int i=0; i<this.steps.length;i++)
        {
            steps[i] = Integer.MAX_VALUE;
        }
    }

    private void bfsMultiNode(int source) {
        boolean[] m = new boolean[digraph.V()];
        marked[source] = true;
        m[source] = true;
        steps[source] = 0;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : digraph.adj(v)) {
                if (!m[w]) {
                    steps[w] = steps[w] < steps[v]+1 ? steps[w] : steps[v] + 1;
                    marked[w] = true;
                    m[w] = true;
                    queue.enqueue(w);
                }
            }

        }
    }

    private ShortestPath bfsSecondNode(int source) {
        boolean[] m = new boolean[digraph.V()];
        int [] s = new int[digraph.V()];
        m[source] = true;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            if (this.marked[v]) {
                return new ShortestPath(this.steps[v] + s[v], v);
            }
            for (int w : digraph.adj(v)) {
                if (!m[w]) {
                    s[w] = s[v] + 1;
                    m[w] = true;
                    queue.enqueue(w);
                }
            }
        }
        return ShortestPath.INIT_SHORTEST_PATH;
    }

    private ShortestPath shortestPath(int v, int w) {
        this.clearState();
        this.bfs(v);
        return this.bfsSecondNode(w);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        return this.shortestPath(v,w).getPathLength();
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        return this.shortestPath(v,w).getCommonAncestorNode();
    }

    private ShortestPath shortestPathMultiNode(Iterable<Integer> v, Iterable<Integer> w) {
        this.initMultiNodeBfs();
        for (Integer x : v) {
            this.bfsMultiNode(x);
        }
        int minLength = Integer.MAX_VALUE;
        ShortestPath result = ShortestPath.INIT_SHORTEST_PATH;
        for (Integer y : w) {
            ShortestPath path = this.bfsSecondNode(y);
            if (path.getPathLength() != -1 && path.getPathLength() < minLength) {
                minLength = path.getPathLength();
                result = path;
            }
        }
        return result;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        return shortestPathMultiNode(v,w).getPathLength();
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        return shortestPathMultiNode(v,w).getCommonAncestorNode();
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In("digraph1.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}