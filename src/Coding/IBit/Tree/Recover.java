package Coding.IBit.Tree;

import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class Recover {
    TreeNode first, middle, last, prev;
    public ArrayList<Integer> recoverTree(TreeNode a) {
        if (a == null)
            return null;
        first = middle= last = prev= null;
        checkBST(a);
        ArrayList<Integer> result = new ArrayList<>();
        if (last != null && first != null) {
            result.add(last.val);
            result.add(first.val);
        }
        else {
            result.add(middle.val);
            result.add(first.val);
        }
        return result;
    }

    private void checkBST(TreeNode a) {
        if (a == null)
            return;
        checkBST(a.left);
        if (prev!=null && a.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = a;
            }
            else
                last = a;
        }
        prev = a;
        checkBST(a.right);
    }

//
//    private TreeNode checkBST(TreeNode a, int minValue, int maxValue) {
//        if (a == null)
//            return null;
//        if (a.val < minValue || a.val > maxValue)
//            return a;
//        TreeNode n = null;
//        if (a.left != null) {
//            n = checkBST(a.left, minValue, a.val);
//        }
//        TreeNode m = null;
//        if (a.right != null) {
//            m = checkBST(a.right, a.val, maxValue);
//        }
//        if (m == null && n == null)
//            return null;
//        else if (m != null && n != null) {
//            pair.x = m.val;
//            pair.y = n.val;
//            return null;
//        }
//        else if (m == null)
//    }
//
//    static class Pair {
//        int x;
//        int y;
//    }
}
