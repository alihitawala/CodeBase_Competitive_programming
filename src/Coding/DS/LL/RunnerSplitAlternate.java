package Coding.DS.LL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/24/15.
 */
public class RunnerSplitAlternate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        LinkedList head = LinkedListHelper.newList(a);
        ArrayList<LinkedList> split = LinkedListHelper.split(head);
        LinkedListHelper.printList(split.get(0));
        LinkedListHelper.printList(split.get(1));
    }
}
