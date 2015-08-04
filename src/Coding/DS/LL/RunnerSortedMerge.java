package Coding.DS.LL;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/25/15.
 */
public class RunnerSortedMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            b.add(x);
        }
        LinkedList head = LinkedListHelper.newList(a);
        LinkedList head2 = LinkedListHelper.newList(b);
        LinkedList merge = LinkedListHelper.sortedMerge(head, head2);
        LinkedListHelper.printList(merge);
    }
}
