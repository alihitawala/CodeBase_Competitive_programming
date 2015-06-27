package Coding.Libo.DP;

import sun.net.www.content.audio.x_aiff;

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
            boolean isAllNegative = true;
            long[] a = new long[n];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt();
                if (a[j] >= 0) isAllNegative = false;
            }
            if (isAllNegative) {
                long max = getMaxElement(a);
                System.out.println(max+ " " + max);
            }
            else {
                long contiguousMax = getMaxSumContiguous(a);
                long nonContiguousMax = getMaxSumNonContiguous(a);
                System.out.println(contiguousMax + " " + nonContiguousMax);
            }
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

    private static long getMaxElement(long[] a) {
        long max=Long.MIN_VALUE;
        for (long i:a){
            if (i > max)
                max = i;
        }
        return max;
    }
}
