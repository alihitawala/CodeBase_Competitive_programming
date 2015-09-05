package Coding.IBit.Tree;

import java.util.Map;

/**
 * Created by alihitawala on 9/4/15.
 */
public class Balanced {

    boolean isBalanced = true;

    private int recursive(TreeNode root, int h) {
        if (!isBalanced)
            return 0;
        if (root == null)
            return 0;
        int left = recursive(root.left, h);
        int right = recursive(root.right, h);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode a) {
        if (a == null)
            return true;
        isBalanced = true;
        recursive(a, 0);
        return isBalanced;
    }
}
