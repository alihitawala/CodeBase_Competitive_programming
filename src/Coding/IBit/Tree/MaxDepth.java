package Coding.IBit.Tree;

/**
 * Created by alihitawala on 9/5/15.
 */
public class MaxDepth {
    public int maxDepth(TreeNode a) {
        if (a==null)
            return 0;
        return recursiveCall(a, 0);
    }

    private int recursiveCall(TreeNode a, int num) {
        if (a.left == null && a.right == null)
            return num+1;
        int maxLeft=0, maxRight=0;
        if (a.left != null)
            maxLeft = recursiveCall(a.left, num+1);
        if (a.right != null)
            maxRight = recursiveCall(a.right, num+1);
        return Math.max(maxLeft, maxRight);
    }
}
