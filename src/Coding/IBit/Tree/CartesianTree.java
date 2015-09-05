package Coding.IBit.Tree;

import java.util.ArrayList;

/**
 * Created by alihitawala on 9/4/15.
 */
public class CartesianTree {
    public TreeNode buildTree(ArrayList<Integer> a) {
        if (a.size() == 0)
            return null;
        return recursiveCall(a, 0, a.size()-1);
    }

    private TreeNode recursiveCall(ArrayList<Integer> a, int start, int end) {
        if(start>end)
            return null;
        int i = maxIndex(a, start, end);
        TreeNode root = new TreeNode(a.get(i));
        if (start == end) {
            return root;
        }
        root.left = recursiveCall(a, start, i-1);
        root.right = recursiveCall(a, i+1, end);
        return root;
    }

    private int maxIndex(ArrayList<Integer> a, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i <=end ; i++) {
            if (a.get(i) > max) {
                max = a.get(i);
                index = i;
            }
        }
        return index;
    }


}
