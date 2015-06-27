package ZoomCar;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/21/15.
 */
public class CC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (int i=0;i<t;i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            long a[] = new long[(int)n];
            for (int j=0;j<n;j++) {
                a[j]=in.nextLong();
            }
            String s = solve(a,k);
            System.out.println(s);
        }
    }

    private static String solve(long[] a, long k) {
        boolean ifOdd = ifOdd(a);
        if (ifOdd) return "even";
        if (k==1) return "odd";
        else return "even";
    }

    private static boolean ifOdd(long[] a) {
        boolean result = false;
        for (long anA : a) {
            if (anA % 2 != 0) {
                result = !result;
            }
        }
        return result;
    }
}
