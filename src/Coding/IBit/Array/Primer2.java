package Coding.IBit.Array;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class Primer2 {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(5);
        in.add(10);
        in.add(2);
        in.add(1);
        printArray(performOps(in));

    }
    static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }



    private static void printArray(ArrayList<Integer> solve) {
        for (int i :solve) {
            System.out.print(i + " " );
        }
    }

}
