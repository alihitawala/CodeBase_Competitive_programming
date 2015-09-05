package Coding.IBit.Tree;

import java.util.ArrayList;

/**
 * Created by alihitawala on 9/4/15.
 */
public class PostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        return recursiveCall(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode recursiveCall(int[] postOrder, int postOrderStart, int postOrderEnd,
                                   int[] inorder, int inorderStart, int inorderEnd) {
        if (postOrderStart > postOrderEnd)
            return null;
        int rootValue = postOrder[postOrderEnd];
        TreeNode root = new TreeNode(rootValue);
        int index = inorderIndex(inorder, inorderStart, inorderEnd, rootValue);
        int diff = index - inorderStart;
        root.left = recursiveCall(postOrder, postOrderStart, postOrderStart+diff-1,
                inorder, inorderStart, inorderStart+diff-1);
        root.right = recursiveCall(postOrder, postOrderStart+diff, postOrderEnd-1,
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
