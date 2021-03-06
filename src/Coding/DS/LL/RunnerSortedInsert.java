package Coding.DS.LL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/24/15.
 */
public class RunnerSortedInsert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x = in.nextInt();
            a.add(x);
        }
        int data = in.nextInt();
        LinkedList head = LinkedListHelper.newList(a);
        LinkedListHelper.printList(head);
        LinkedListHelper.printList(LinkedListHelper.sortedInsert(head, LinkedListHelper.newNode(data)));
    }
}
