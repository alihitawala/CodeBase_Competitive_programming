package Coding.IBit.Tree;

/**
 * Created by alihitawala on 9/4/15.
 */
public class Symmetric {
    public int isSymmetric(TreeNode a) {
        return symmetric(a.left, a.right) ? 1 : 0;
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val== right.val && symmetric(left.right, right.left) && symmetric(left.left, right.right);
    }
}
