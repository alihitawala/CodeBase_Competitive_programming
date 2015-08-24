package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/23/15.
 */
public class ReverseListMod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int p = in.nextInt();
        int q = in.nextInt();
        ListNode head1 = ListNode.getList(a);
        ListNode.print(reverseBetween(head1, p, q));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null ||head.next == null)
            return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode temp = fakeHead;
        for (int i =0;i<m-1;i++)
            temp = temp.next;
        int hops = n-m+1;
        ListNode start = temp;
        ListNode end = temp.next;
        ListNode p = temp.next;

        ListNode q = temp.next.next;
        for (int i=0;i<hops;i++) {
            p.next = temp;
            temp = p;
            p = q;
            if (q !=null)
                q = q.next;
        }
        start.next = temp;
        end.next = p;
        return fakeHead.next;
    }
}
