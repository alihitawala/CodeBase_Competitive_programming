package Coding.IBit.Heap;

import Coding.IBit.LinkedList.ListNode;

import java.util.*;

/**
 * Created by aliHitawala on 9/1/15.
 */
public class MergeKList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<ListNode> lists = new ArrayList<>();
        for(int j=0;j<t;j++){
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int x =in.nextInt();
                a.add(x);
            }
            ListNode head1 = ListNode.getList(a);
            lists.add(head1);
        }
        ListNode.print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i <a.size(); i++) {
            ListNode list = a.get(i);
            while (list != null) {
                if (map.containsKey(list.val))
                {
                    map.put(list.val, map.get(list.val) + 1);
                }
                else
                    map.put(list.val, 1);
                list = list.next;
            }
        }
        if (map.isEmpty())
            return null;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                ListNode n = new ListNode(val);
                temp.next = n;
                temp = temp.next;
            }
        }
        return head.next;
    }
}
