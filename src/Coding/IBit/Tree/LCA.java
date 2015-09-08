package Coding.IBit.Tree;

/**
 * Created by aliHitawala on 9/7/15.
 */
public class LCA {

    public int lca(TreeNode a, int val1, int val2) {
        TreeNode node = findLCA(a, val1, val2);
        isX = false;
        isY = false;
        return node == null ? -1 : node.val;
    }
    boolean isX = false;
    boolean isY = false;
    private TreeNode recursiveCall(TreeNode a, int x, int y) {
        if (a == null)
            return null;
        if (a.val == x) {
            isX = true;
            return a;
        }
        if (a.val == y) {
            isY = true;
            return a;
        }
        TreeNode left = recursiveCall(a.left, x, y);
        TreeNode right = recursiveCall(a.right, x, y);
        if (left !=null && right != null)
            return a;
        return left != null ? left : right;
    }

    private TreeNode findLCA(TreeNode root, int x, int y) {
        TreeNode node = recursiveCall(root, x, y);
        if (isY && isX || isX && find(node, y) || isY && find(node, x))
            return node;
        return null;
    }

    private boolean find(TreeNode node, int key) {
        if (node == null)
            return false;
        if (node.val == key || find(node.left, key) || find(node.right, key))
            return true;
        return false;
    }
}
