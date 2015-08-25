package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/24/15.
 */
public class SwapPairs {
    /*
    For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        ListNode head1 = ListNode.getList(a);
        ListNode.print(swapPairs(head1));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        head = q;
        ListNode r = q.next;
        while (p != null && q != null) {
            q.next = p;
            if (r != null && r.next != null) {
                p.next = r.next;
                p = r;
                q = r.next;
                r = r.next.next;
            }
            else if (r == null){
                p.next=null;
                p = null;
            }
            else {
                p.next=r;
                p = null;
            }
        }
        return head;
    }
}
