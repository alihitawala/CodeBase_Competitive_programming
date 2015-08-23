package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/22/15.
 */
public class AddNum {
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


    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        int num = a.val + b.val;
        int carry = num / 10;
        num = num % 10;
        ListNode head = new ListNode(num);
        ListNode temp = head;
        a= a.next;
        b= b.next;
        while (a!= null && b !=null) {
            num = a.val+b.val+carry;
            carry = num / 10;
            num = num%10;
            ListNode newNode = new ListNode(num);
            temp.next = newNode;
            temp = newNode;
            a= a.next;
            b= b.next;
        }
        while (a != null) {
            num = a.val + carry;
            carry = num /10;
            num = num %10;
            ListNode newNode = new ListNode(num);
            temp.next = newNode;
            temp = newNode;
            a= a.next;
        }
        while (b != null) {
            num = b.val + carry;
            carry = num /10;
            num = num %10;
            ListNode newNode = new ListNode(num);
            temp.next = newNode;
            temp = newNode;
            b= b.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }
}
