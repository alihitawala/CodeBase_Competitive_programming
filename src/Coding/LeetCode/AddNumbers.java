package Coding.LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alihitawala on 9/4/15.
 */
public class AddNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        n = in.nextInt();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            b.add(x);
        }
        ListNode head1 = ListNode.getList(a);
        ListNode head2 = ListNode.getList(b);
        ListNode.print(addTwoNumbers(head1, head2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            temp.next = new ListNode(sum%10);
            carry = sum /10;
            temp = temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        if (l1 != null)
            carry = sumRemaining(temp, l1, carry);
        if (l2 !=null)
            carry = sumRemaining(temp, l2, carry);
        if (carry != 0 && temp.next == null)
            temp.next = new ListNode(carry);
        return head.next;
    }

    private static int sumRemaining(ListNode temp, ListNode l1, int carry) {
        while(l1!=null) {
            int sum = l1.val + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;
            temp = temp.next;
            l1 = l1.next;
        }
        if (carry != 0)
            temp.next = new ListNode(carry);
        return carry;
    }


}
