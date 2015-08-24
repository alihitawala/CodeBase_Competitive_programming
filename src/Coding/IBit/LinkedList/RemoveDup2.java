package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/23/15.
 */
public class RemoveDup2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        ListNode head1 = ListNode.getList(a);
        ListNode.print(removeDup(head1));
    }

    private static ListNode removeDup(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newList = null;
        ListNode newHead = null;
        boolean dup = false;
        while (p2 != null) {
            p1.next = null;
            if (p1.val == p2.val) {
                dup = true;
            }
            else {
                if (dup) {
                    dup = false;
                } else {
                    if (newList == null) {
                        newList = p1;
                        newHead = p1;
                    }
                    else {
                        newList.next = p1;
                        newList = newList.next;
                    }
                }
            }
            p1 = p2;
            p2 = p2.next;
        }
        if (!dup) {
            p1.next = null;
            if (newList == null) {
                newHead = p1;
            }
            else {
                newList.next = p1;
            }
        }
        return newHead;
    }
}
// 1 1