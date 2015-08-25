package Coding.IBit.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aliHitawala on 8/24/15.
 */
public class ReorderList {
    /*
    For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
        ListNode.print(reorderList(head1));
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != null && !stack.isEmpty()) {
            ListNode a = temp;
            ListNode b = stack.pop();
            if (a.next == b || a == b) {
                b.next =null;
                break;
            }
            temp = temp.next;
            a.next = b;
            b.next = temp;
        }
        return head;
    }
}

