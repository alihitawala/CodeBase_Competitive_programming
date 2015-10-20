package Coding.IBit.Math;

import java.util.Scanner;

/**
 * Created by aliHitawala on 10/8/15.
 */
public class Power2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(new Power2().isPower(n));
    }

    public boolean isPower(int a) {
//        boolean[] p = new boolean[a+1];
//        for (int i = 2; i <= Math.sqrt(a); i++) {
//            if (!p[i]) {
//                for (int j = i*i; j <= a; j+=i) {
//                    p[j] = true;
//                }
//            }
//        }
        if (a == 1)
            return true;
        for (int i=2;i<=Math.sqrt(a) ; i++) {
            int first = 2, last = (int)Math.sqrt(a);
            boolean b_search = binarySearch(a, i, first, last);
            if (b_search)
                return true;
        }
        return false;
    }

    private boolean binarySearch(int a, int i, int low, int high) {
        while (low <=high) {
            int mid = low + (high - low)/2;
            long x = (long) Math.pow(i, mid);
            if (x == a)
                return true;
            else if (a < x) {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return false;
    }
}
