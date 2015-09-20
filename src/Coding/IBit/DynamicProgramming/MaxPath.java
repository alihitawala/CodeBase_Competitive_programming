package Coding.IBit.DynamicProgramming;

/**
 * Created by aliHitawala on 9/17/15.
 */
public class MaxPath {

    private int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.left.left = new TreeNode(-300);
        root.left.right = new TreeNode(-400);
        System.out.println(new MaxPath().maxPathSum(root));
    }
    public int maxPathSum(TreeNode a) {
        max = Integer.MIN_VALUE;
        int val = _recursiveCall(a);
        return max > val ? max : val;
    }

    private int _recursiveCall(TreeNode a) {
        if (a == null)
            return Integer.MIN_VALUE;
        if (a.right == null && a.left == null)
            return a.val;
        int val = 0, l=Integer.MIN_VALUE, r=Integer.MIN_VALUE;
        if (a.right == null) {
            l = _recursiveCall(a.left);
            val+=l;
        }
        else if (a.left == null) {
            r = _recursiveCall(a.right);
            val+=r;
        }
        else {
            l = _recursiveCall(a.left);
            r = _recursiveCall(a.right);
            val +=l+r;
        }
        val+=a.val;
        if (val > max)
            max = val;
        if (a.val > max)
            max = a.val;
        return Math.max((Math.max(l,r) + a.val), a.val);
    }


}
