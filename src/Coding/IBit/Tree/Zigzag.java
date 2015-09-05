package Coding.IBit.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by alihitawala on 9/5/15.
 */
public class Zigzag {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(a);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
                result.add(list);
            }
            else if (!stack2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
                result.add(list);
            }
        }
        return result;
    }
}
