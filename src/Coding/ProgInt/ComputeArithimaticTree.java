package Coding.ProgInt;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class ComputeArithimaticTree {
    public static void main(String[] args) {
        Tree root = new Tree("+");
        root.setLeft(new Tree("*"));
        root.setRight(new Tree("*"));
        root.getRight().setRight(new Tree("3"));
        root.getRight().setLeft(new Tree("2"));
        root.getLeft().setRight(new Tree("5"));
        root.getLeft().setLeft(new Tree("4"));
        System.out.println(compute(root));
    }
    private static int compute(Tree root) {
        if (root == null) {
            return 0;
        }
        String data = root.getData();
        int result = 0;
        try {
            result = Integer.parseInt(data);
        }
        catch (NumberFormatException ex) {
            if (data.equals("+")) {
                result = compute(root.getLeft()) + compute(root.getRight());
            } else if (data.equals("-")) {
                result = compute(root.getLeft()) - compute(root.getRight());
            } else if (data.equals("/")) {
                result = compute(root.getLeft()) / compute(root.getRight());
            } else if (data.equals("*")) {
                result = compute(root.getLeft()) * compute(root.getRight());
            }
        }
        return result;
    }
}
