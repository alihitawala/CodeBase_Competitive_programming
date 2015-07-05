package Coding.IBit.Tree;

import java.util.List;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Tree (Node root) {
        this.root = root;
    }

    public void inorderTraversal() {
        Node temp = root;
        _inorderTraversal(temp);
    }

    private void _inorderTraversal(Node temp) {
        if (temp == null) return;
        _inorderTraversal(temp.left);
        System.out.println(temp.data);
        _inorderTraversal(temp.right);
    }

    public int countNodes() {
        Node temp = root;
        return _countNodes(temp);
    }

    private int _countNodes(Node temp) {
        if (temp == null) return 0;
        return _countNodes(temp.left) + 1 + _countNodes(temp.right);
    }

    public static boolean isTreeIdentical(Tree t1, Tree t2) {
        return _isTreeIdentical(t1.getRoot(), t2.getRoot());
    }

    private static boolean _isTreeIdentical(Node root1, Node root2) {
        return root1 == null && root2 == null
                || !(root1 == null || root2 == null)
                && root1.getData() == root2.getData()
                && _isTreeIdentical(root1.left, root2.left)
                && _isTreeIdentical(root1.right, root2.right);
    }

    public int height() {
        Node temp = root;
        return _height(temp);
    }

    private int _height(Node temp) {
        if (temp == null)
            return 0;
        int h1 = _height(temp.left);
        int h2 = _height(temp.right);
        return Math.max(h1, h2) +1;
    }

    public Tree mirrorTree() {
        Node temp = root;
        return new Tree(_mirrorTree(temp));
    }

    private Node _mirrorTree(Node temp) {
        if (temp == null)
            return null;
        Node newNode = new Node(temp.data);
        newNode.setLeft(_mirrorTree(temp.right));
        newNode.setRight(_mirrorTree(temp.left));
        return newNode;
    }

    static class Node {
        private Node right;
        private Node left;
        private int data;

        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
}
