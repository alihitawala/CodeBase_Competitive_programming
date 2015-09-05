package Coding.IBit.Tree;

import java.util.List;

/**
 * Created by alihitawala on 9/4/15.
 */
public class ArrayBST {

    public TreeNode sortedArrayToBST(final int[] a) {
        int length = a.length;
        int mid = length/2;
        TreeNode root = new TreeNode(a[mid]);
        return recursiveCall(a, 0, mid-1, mid+1, length-1, root);
    }

    private TreeNode recursiveCall(int[] a, int leftLow, int leftHigh, int rightLow, int rightHigh, TreeNode root) {
        if (leftHigh >= leftLow) {
            int left = (leftHigh + leftLow) / 2;
            TreeNode leftNode = new TreeNode(a[left]);
            root.left = leftNode;
            recursiveCall(a, leftLow, left-1, left+1, leftHigh, root.left);
        }
        if (rightHigh >= rightLow) {
            int right = (rightHigh + rightLow) / 2;
            TreeNode rightNode = new TreeNode(a[right]);
            root.right = rightNode;
            recursiveCall(a, rightLow, right-1, right+1, rightHigh, root.right);
        }
        return root;
    }
}
