package Coding.IBit.Tree;


import java.util.LinkedList;

/**
 * Created by alihitawala on 9/5/15.
 */
public class NextPointer2 {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        LinkedList<TreeLinkNode> queue1 = new LinkedList<>();
        LinkedList<TreeLinkNode> queue2 = new LinkedList<>();
        queue1.push(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                TreeLinkNode prev = null;
                while(!queue1.isEmpty()) {
                    TreeLinkNode temp = queue1.removeFirst();
                    if (temp.left != null)
                        queue2.addLast(temp.left);
                    if (temp.right != null)
                        queue2.addLast(temp.right);
                    if (prev != null)
                        prev.next = temp;
                    prev = temp;
                }
            }
            else if (!queue2.isEmpty()) {
                TreeLinkNode prev = null;
                while(!queue2.isEmpty()) {
                    TreeLinkNode temp = queue2.removeFirst();
                    if (temp.left != null)
                        queue1.addLast(temp.left);
                    if (temp.right != null)
                        queue1.addLast(temp.right);
                    if (prev != null)
                        prev.next = temp;
                    prev = temp;
                }

            }
        }
    }
}
