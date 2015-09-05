package Coding.IBit.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alihitawala on 9/5/15.
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        recursiveCall(root, sum, temp, result);
        return result;
    }

    private void recursiveCall(TreeNode root, int sum, ArrayList<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;
        int subSum = sum - root.val;
        if (subSum == 0 && root.left == null && root.right == null)
        {
            temp.add(root.val);
            result.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if (root.left != null) {
            temp.add(root.val);
            recursiveCall(root.left, subSum, temp, result);
            temp.remove(temp.size()-1);
        }
        if (root.right != null) {
            temp.add(root.val);
            recursiveCall(root.right, subSum, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
