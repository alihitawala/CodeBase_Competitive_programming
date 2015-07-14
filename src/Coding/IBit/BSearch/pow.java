package Coding.IBit.BSearch;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/7/15.
 */
public class pow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m= in.nextInt();
            int d= in.nextInt();
            System.out.println((_power(n, m, d)));
        }
    }

    private static int _power(int n, int m, int d) {
        int sign = 1;
//        if (n < 0)sign=-1;
        return power(n*sign,m,d);
    }

    private static int power(int n, int m, int d) {
        return (int) powerLong(n,m,d);
    }

    private static long powerLong(long n, long m, long d) {
        if (m == 0) return (int)modulo(1,d);
        if (m == 1) return (int)modulo(n,d);
        long x = modulo(powerLong(n, m / 2, d),d);
        long y = modulo(x*x,d);
        if (m %2 !=0) y=modulo(y*n,d);
        return y;
    }
      
    private static long modulo(long n, long d) {
        if (n>=0) return n%d;
        return modulo(n+d, d);
    }
}
