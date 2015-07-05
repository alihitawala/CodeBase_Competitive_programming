package Coding.IBit.Tree;

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
}