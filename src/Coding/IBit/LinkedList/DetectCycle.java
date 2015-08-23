package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/22/15.
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next;
        System.out.println(detectCycle(head).val);
//        ListNode.print(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode a) {
        if (a==null || a.next == null)
            return null;
        ListNode slow = a;
        ListNode fast = a;
        while (slow != null && fast != null && fast.next != null) {
            slow=slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return getNode(slow, a);
        }
        return null;
    }

    private static ListNode getNode(ListNode slow, ListNode a) {
        ListNode p1 = slow, p2 = slow;
        int k =1;
        while (p1.next != p2) {
            p1 = p1.next;
            k++;
        }
        p1 = a;
        p2 = a;
        for (int i=0;i<k;i++)
            p2=p2.next;
        while (p1!=p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
