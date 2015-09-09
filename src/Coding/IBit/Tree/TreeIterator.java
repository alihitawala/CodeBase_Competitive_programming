package Coding.IBit.Tree;

import java.util.Stack;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class TreeIterator {
    Stack<TreeNode> stack = new Stack<>();
    public TreeIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            TreeNode right = temp.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return temp.val;
    }
}
