package Coding.IBit.Tree;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class Flatten {
    public TreeNode flatten(TreeNode a) {
        if (a == null || (a.left == null && a.right == null))
            return a;
        recursiveCall(a);
        return a;
    }

    private TreeNode recursiveCall(TreeNode a) {
        if (a.left == null && a.right == null)
            return a;
        if (a.left == null)
            return recursiveCall(a.right);
        TreeNode temp = a.right;
        a.right = a.left;
        a.left = null;
        TreeNode node = recursiveCall(a.right);
        node.right = temp;
        if (temp == null)
            return node;
        return recursiveCall(temp);
    }
}
