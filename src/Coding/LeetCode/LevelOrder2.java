package Coding.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alihitawala on 9/5/15.
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrderBottom(TreeNode a) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null)
            return result;
        LinkedList<TreeNode> queue1 = new LinkedList();
        LinkedList<TreeNode> queue2 = new LinkedList();
        queue1.addLast(a);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.removeFirst();
                    list.add(node.val);
                    if (node.left != null)
                        queue2.addLast(node.left);
                    if (node.right != null)
                        queue2.addLast(node.right);
                }
                result.add(list);
            }
            else if (!queue2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.removeFirst();
                    list.add(node.val);
                    if (node.left != null)
                        queue1.addLast(node.left);
                    if (node.right != null)
                        queue1.addLast(node.right);
                }
                result.add(list);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
