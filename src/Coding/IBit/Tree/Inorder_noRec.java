package Coding.IBit.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alihitawala on 9/5/15.
 */
public class Inorder_noRec {
    public List<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a==null)
            return result;
        boolean done = false;
        TreeNode current = a;
        Stack<TreeNode> stack = new Stack<>();
        while(!done) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                if (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    result.add(node.val);
                    current = node.right;
                } else
                    done = true;
            }
        }
        return result;
    }
}
