package Coding.IBit.Tree;

/**
 * Created by alihitawala on 9/5/15.
 */
public class SumPathAll {
    private static final int MOD = 1003;
    public int sumNumbers(TreeNode a) {
        if (a==null)
            return 0;
        return recursiveCall(a, 0);
    }

    private int recursiveCall(TreeNode a, int sum) {
        sum = (sum*10 + a.val) % MOD;
        if (a.left == null && a.right == null) {
            return sum;
        }
        int temp = 0;
        if (a.left != null) {
            temp = (temp + recursiveCall(a.left, sum)) % MOD;
        }
        if (a.right != null)
            temp = (temp + recursiveCall(a.right, sum)) % MOD;
        return temp;
    }
}
