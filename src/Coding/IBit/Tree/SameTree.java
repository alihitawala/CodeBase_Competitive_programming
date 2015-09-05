package Coding.IBit.Tree;

/**
 * Created by alihitawala on 9/4/15.
 */
public class SameTree {

    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a==null && b==null)
            return true;
        else if (a==null || b==null)
            return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
