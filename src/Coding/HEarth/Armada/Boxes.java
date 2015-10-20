package Coding.HEarth.Armada;

import java.util.Scanner;

/**
 * Created by aliHitawala on 10/11/15.
 */
public class Boxes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long l = in.nextLong();
            long b = in.nextLong();
            long h = in.nextLong();
            System.out.println(solve(l,b,h));
        }
    }

    private static double solve(long l, long b, long h) {
        long[] a = new long[3];
        a[0] = l;
        a[1] = b;
        a[2] = h;
        int minIndex = -1;
        if (a[0] < a[1])
            if (a[0] < a[2])
                minIndex=0;
            else
                minIndex=2;
        else
            if (a[1] < a[2])
                minIndex=1;
            else
                minIndex=2;
        return a[minIndex]/2.0;
//        if (minIndex == 0)
//            return Math.min(l,b)/2.0;
//        else if (minIndex == 1)
//            return Math.min(h,b)/2.0;
//        else
//            return Math.min(l,h)/2.0;
    }
}
