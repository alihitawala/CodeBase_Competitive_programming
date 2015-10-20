package Coding.IBit.Tree;

import java.util.LinkedList;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class TreeRunner {
    public static void main(String[] args) {
        Tree.Node root = new Tree.Node(10);
        root.setLeft(new Tree.Node(8));
        root.setRight(new Tree.Node(60));
        root.getRight().setRight(new Tree.Node(90));
        root.getRight().setLeft(new Tree.Node(50));
        Tree tree = new Tree(root);
        tree.inorderTraversal();
        System.out.println(tree.countNodes());
        treeIdentical();
        System.out.println(tree.height());
        tree.mirrorTree().inorderTraversal();
        levelOrder(root);
    }

    private static void treeIdentical() {
        Tree.Node root = new Tree.Node(10);
        root.setLeft(new Tree.Node(8));
        root.setRight(new Tree.Node(60));
        root.getRight().setRight(new Tree.Node(90));
        root.getRight().setLeft(new Tree.Node(50));
        Tree tree = new Tree(root);
        Tree tree2 = new Tree(root);
        System.out.println(Tree.isTreeIdentical(tree, tree2));
    }
    public static void levelOrder (Tree.Node root) {
        if (root == null)
            return;
        LinkedList<Tree.Node> q = new LinkedList<Tree.Node>();
        q.addLast(root);
        while (!q.isEmpty()) {
            Tree.Node t = q.removeFirst();
            System.out.print(t.getData() + " ");
            if (t.getLeft() != null)
                q.addLast(t.getLeft());
            if (t.getRight() != null)
                q.addLast(t.getRight());
        }

    }
    int findCeil (long t[], long first, int l, int h)
    {
        int ceilIndex = l;
        for (int i = l+1; i <= h; i++)
            if (t[i] > first && t[i] < t[ceilIndex])
                ceilIndex = i;
        return ceilIndex;
    }
}