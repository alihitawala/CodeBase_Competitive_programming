/**
 * Created by aliHitawala on 5/4/15.
 */
class ShortestPath {
    int pathLength;
    int commonAncestorNode;
    public final static ShortestPath INIT_SHORTEST_PATH = new ShortestPath(-1, -1);

    ShortestPath(int pathLength, int commonAncestorNode) {
        this.pathLength = pathLength;
        this.commonAncestorNode = commonAncestorNode;
    }

    public int getPathLength() {
        return pathLength;
    }

    public int getCommonAncestorNode() {
        return commonAncestorNode;
    }
}

