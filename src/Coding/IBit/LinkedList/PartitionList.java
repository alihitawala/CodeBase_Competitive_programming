package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/24/15.
 */
public class PartitionList {
    /*
    For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int x = in.nextInt();
        ListNode head1 = ListNode.getList(a);
        ListNode.print(partition(head1, x));
    }

    public static ListNode partition(ListNode head, int b) {
        if (head == null | head.next == null)
            return head;
        ListNode fakeNode = new ListNode(Integer.MIN_VALUE);
        fakeNode.next = head;
        ListNode p1 = fakeNode;
        ListNode p2 = fakeNode.next;
        while (p2 != null && p2.val < b) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2 != null) {
            ListNode temp = p2.next;
            p2.next = null;
            while (temp != null) {
                if (temp.val < b) {
                    ListNode r = temp.next;
                    ListNode s = p1.next;
                    p1.next = temp;
                    p1 = p1.next;
                    temp.next = s;
                    temp = r;
                }
                else {
                    ListNode r = temp.next;
                    p2.next = temp;
                    p2 = p2.next;
                    temp.next = null;
                    temp = r;
                }
            }
        }
        return fakeNode.next;
    }
}
