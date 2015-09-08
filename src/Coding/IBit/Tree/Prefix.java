package Coding.IBit.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class Prefix {

    public static void main(String[] args) {
        Prefix p = new Prefix();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        System.out.println(p.prefix(a));
    }

    public ArrayList<String> prefix(ArrayList<String> a) {
        ArrayList<SortNode> result = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();
        Node node = new Node();
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            insertString(node, s, i);
        }
        getValues(result, node);
        Collections.sort(result, new Comparator<SortNode>() {
            @Override
            public int compare(SortNode o1, SortNode o2) {
                return o1.seq-o2.seq;
            }
        });
        for(SortNode sortNode : result) {
            r.add(sortNode.string);
        }
        return r;
    }

    private void getValues(ArrayList<SortNode> result, Node node) {
        if (node == null)
            return;
        if (node.prefix != null) {
            SortNode sn = new SortNode(node.prefix, node.seq);
            result.add(sn);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.nodes[i] != null) {
                getValues(result, node.nodes[i]);
            }
        }
    }

    private void insertString(Node node, String s, int seq) {
        Node[] nodes = node.nodes;
        int index = getIndex(s, 0);
        int j = 1;
        if(nodes[index] != null) {
            Node temp = nodes[index];
            Node prevTemp = nodes[index];
            int i = 0;
            while (temp != null && temp.string == null) {
                i = getIndex(s, j++);
                prevTemp = temp;
                temp = temp.nodes[i];
            }
            if (temp == null) {
                prevTemp.nodes[i] = new Node();
                prevTemp.nodes[i].string = s;
                prevTemp.nodes[i].prefix = s.substring(0,j);
                prevTemp.nodes[i].seq = seq;
            }
            else {
                String oldString = temp.string;
                int oldSeq = temp.seq;
                temp.string = null;
                temp.prefix = null;
                while (s.charAt(j) == oldString.charAt(j)) {
                    i = getIndex(s, j++);
                    temp.nodes[i] = new Node();
                    temp = temp.nodes[i];
                }
                i = getIndex(s, j);
                temp.nodes[i] = new Node();
                temp.nodes[i].string = s;
                temp.nodes[i].prefix = s.substring(0, j + 1);
                temp.nodes[i].seq = seq;
                i = getIndex(oldString, j);
                temp.nodes[i] = new Node();
                temp.nodes[i].string = oldString;
                temp.nodes[i].prefix = oldString.substring(0, j + 1);
                temp.nodes[i].seq = oldSeq;
            }
        }
        else {
            nodes[index] = new Node();
            nodes[index].string = s;
            nodes[index].prefix = s.substring(0,j);
            nodes[index].seq = seq;
        }
    }

    private int getIndex(String s, int charIndex) {
        char ch = s.charAt(charIndex);
        int i = (int)ch - 'a';
        return i;
    }
    static class Node {
        Node[] nodes = new Node[26];
        String string;
        String prefix;
        int seq;
    }
    static class SortNode {
        String string;
        int seq;

        public SortNode(String string, int seq) {
            this.string = string;
            this.seq = seq;
        }
    }
}
