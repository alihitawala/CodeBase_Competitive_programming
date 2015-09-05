package Coding.IBit.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alihitawala on 9/5/15.
 */
public class Preorder_noRec {
    public List<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a==null)
            return result;
        boolean done = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        return result;
    }
}
