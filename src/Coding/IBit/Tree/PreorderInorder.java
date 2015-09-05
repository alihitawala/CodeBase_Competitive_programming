package Coding.IBit.Tree;

import java.util.ArrayList;

/**
 * Created by alihitawala on 9/4/15.
 */
public class PreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return recursiveCall(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode recursiveCall(int[] preorder, int preOrderStart, int preOrderEnd,
                                   int[] inorder, int inorderStart, int inorderEnd) {
        if (preOrderStart > preOrderEnd)
            return null;
        int rootValue = preorder[preOrderStart];
        TreeNode root = new TreeNode(rootValue);
        int index = inorderIndex(inorder, inorderStart, inorderEnd, rootValue);
        int diff = index - inorderStart;
        root.left = recursiveCall(preorder, preOrderStart+1, preOrderStart+diff,
                inorder, inorderStart, inorderStart+diff-1);
        root.right = recursiveCall(preorder, preOrderStart + 1+diff, preOrderEnd,
                inorder, inorderStart + 1 + diff,inorderEnd);
        return root;
    }

    private int inorderIndex(int[] inorder, int inorderStart, int inorderEnd, int rootValue) {
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootValue)
                return i;
        }
        throw new RuntimeException("Value not present");
    }
}
