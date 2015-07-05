package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class RepeatedNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            List<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            printArray(repeatedNumber(A));
        }
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int xorAll = 0;
        for (int i=1;i<=A.size();i++) {
            xorAll^=i;
            xorAll^=A.get(i-1);
        }
        int bit = ( xorAll & ~(xorAll-1) );
//        int bit = 1 << (lastMisMatchBit-1);
        int setBit = 0;
        int unSetBit = 0;
        for (int i=1;i<=A.size();i++) {
            int value = A.get(i-1);
            if ((i & bit) > 0) {
                setBit^=i;
            }
            else {
                unSetBit^=i;
            }
            if ((value & bit) >0) {
                setBit^=value;
            }
            else {
                unSetBit^=value;
            }
        }
        for (int i:A) {
            if (i==setBit) {
                solution.add(setBit);
                solution.add(unSetBit);
                break;
            }
            else if (i== unSetBit) {
                solution.add(unSetBit);
                solution.add(setBit);
                break;
            }
        }
        return solution;
    }

    public static ArrayList<Integer> repeatedNumber_first(final List<Integer> A) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        for (int i : A) {
            int num = A.get(Math.abs(i)-1);
            if (num < 0) {
                solution.add(Math.abs(i));
            }
            else {
                A.set(Math.abs(i)-1, -num);
            }
        }
        for (int i=0;i<A.size();i++) {
            if (A.get(i) > 0) {
                solution.add(i+1);
                break;
            }
        }
        return solution;
    }


    private static void printArray(ArrayList<Integer> solve) {
        for (int i :solve) {
            System.out.print(i + " " );
        }
    }

}
