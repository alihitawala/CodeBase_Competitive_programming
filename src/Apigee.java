/**
 * Created by aliHitawala on 9/30/15.
 */
public class Apigee {

    public static void main(String[] args) {

    }

    public static void mirrorTree (Node root) {
        if(root == null || (root.getRight() == null && root.getLeft() ==null))
            return;
        Node temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);
        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

    static class Node { //naming ?
        private Node right;
        private Node left;
        private int data;

        public Node(int data) {
            this.data = data;
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

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}