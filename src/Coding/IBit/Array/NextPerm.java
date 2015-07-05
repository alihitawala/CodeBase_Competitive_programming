package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/26/15.
 */
public class NextPerm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        nextPerm(a);
        printArray(a);
    }

    private static void nextPerm(ArrayList<Integer> A) {
        int n = A.size();
//        ArrayList<String> a = new ArrayList<String>(n);
//        for (int i : A) {
//            a.add(String.valueOf(i));
//        }
        int maxIndex = -1;
        for (int i=0;i<n-1;i++) {
            if (A.get(i) < A.get(i+1)) {
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            int maxJ = maxIndex+1;
            for (int i = maxIndex+1;i<n;i++) {
                if (A.get(i) > A.get(maxIndex)) {
                    maxJ = i;
                }
            }
            swap(A, maxIndex, maxJ);
        }
        ArrayList<Integer> c = new ArrayList<Integer>(A.subList(maxIndex+1, n));
        Collections.reverse(c);
        for (int i=maxIndex+1, j=0;i<n;i++,j++) {
            A.set(i, c.get(j));
        }
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    private static void printArray(ArrayList<Integer> solve) {
        for (int j : solve)
            System.out.print(j + " " );
        System.out.println();
    }
}
