package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class MaxSum {
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
            System.out.println(getMaxSum(A));
        }

    }

    private static long getMaxSumNonContiguous(long[] a) {
        long max = 0;
        for (long i : a) {
            if (i>0)
                max+=i;
        }
        return max;
    }

    private static long getMaxSumContiguous(long[] a) {
        long currentMax = 0;
        long temp=0;
        for (long i : a) {
            temp += i;
            if (temp < 0)
                temp = 0;
            else if (temp > currentMax) currentMax = temp;
        }
        return currentMax;
    }

    private static int getMaxSum(final List<Integer> A) {
        if (isAllNegative(A)) {
            return getMaxElement(A);
        }
        int currentMax = 0;
        int temp=0;
        for (long i : A) {
            temp += i;
            if (temp < 0)
                temp = 0;
            else if (temp > currentMax) currentMax = temp;
        }
        return currentMax;
    }

    private static boolean isAllNegative(List<Integer> A) {
        for (int a : A) {
            if (a >= 0 )
            {
                return false;
            }
        }
        return true;
    }

    private static int getMaxElement(List<Integer> A) {
        int max=Integer.MIN_VALUE;
        for (int i:A){
            if (i > max)
                max = i;
        }
        return max;
    }
}
