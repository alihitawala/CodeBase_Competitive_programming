package Coding.HEarth;

import java.io.*;
import java.util.*;

/**
 * Created by aliHitawala on 10/11/15.
 */
public class PreInToPost {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String x = reader.readLine();
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (in.hasNextLine()) {
            a.add(Integer.parseInt(in.nextLine()));
        }
        solve(a);
    }
    public static void solve(ArrayList<Integer> A) {
        if (A == null || A.size() == 0)
            return;
        Integer[] a = A.toArray(new Integer[A.size()]);
        Integer[] pre = a.clone();
        Arrays.sort(a);
        Integer[] in = a;
        Node tree = getTree(in, pre, 0, in.length-1, 0, in.length-1);
        postOrder(tree);
    }

    private static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    private static Node getTree(Integer[] in, Integer[] pre, int pre_start, int pre_end, int in_start, int in_end) {
        if (in_start > in_end)
            return null;
        Node root = new Node(pre[pre_start]);
        int i=in_start;
        for (;i<=in_end;i++) {
            if (pre[pre_start].equals(in[i]))
                break;
        }
        int abs = i-in_start;
        root.left = getTree(in, pre, pre_start+1, pre_start+abs, in_start, i-1);
        root.right = getTree(in, pre, pre_start+1+abs, pre_end, i+1, in_end);
        return root;
    }
    static class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }
}
