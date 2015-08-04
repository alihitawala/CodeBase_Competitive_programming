package Coding.DS.Tree;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class Tree {
    private String  data;
    private Tree left;
    private Tree right;

    public Tree(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
