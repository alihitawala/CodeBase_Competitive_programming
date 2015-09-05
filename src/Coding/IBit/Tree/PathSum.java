package Coding.IBit.Tree;

/**
 * Created by alihitawala on 9/4/15.
 */
public class PathSum {
    public int hasPathSum(TreeNode root, int num) {
        return recursiveCall(root, num) ? 1 : 0;
    }

    private boolean recursiveCall(TreeNode root, int num) {
        if (root == null)
            return num==0;
        else {
            boolean result = false;
            int subSum = num - root.val;
            if (subSum == 0 && root.right == null && root.left == null)
                return true;
            if (root.left != null) {
                result = result || recursiveCall(root.left, subSum);
            }
            if (root.right != null) {
                result = result || recursiveCall(root.right, subSum);
            }
            return result;
        }
    }
}
