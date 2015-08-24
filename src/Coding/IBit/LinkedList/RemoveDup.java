package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/23/15.
 */
public class RemoveDup {

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
        while (p2 != null) {
            if (p1.val == p2.val) {
                ListNode temp = p2.next;
                p1.next = p2.next;
                p2.next = null;
                p2 = temp;
            }
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
