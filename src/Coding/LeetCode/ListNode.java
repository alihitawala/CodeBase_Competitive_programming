package Coding.LeetCode;

import java.util.List;

/**
 * Created by aliHitawala on 8/22/15.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; next = null; }

    public static ListNode getList(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode prev = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static void print(ListNode listNode) {
        while (listNode != null)
        {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
