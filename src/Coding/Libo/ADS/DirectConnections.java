package Coding.Libo.ADS;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/13/15.
 */
public class DirectConnections {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (long i=0;i<t;i++) {
            int n = in.nextInt();
            long d[] = new long[n];
            long p[] = new long[n];
            for (int j=0;j<n;j++)
                d[j]  = in.nextLong();
            for (int j=0;j<n;j++)
                p[j]  = in.nextLong();
            System.out.println(solve(d, p, n));
        }
    }

    private static long solve(long[] d, long[] p, int length) {
        long sum = 0;
        for (int i=0;i<length;i++) {
            for (int j=i+1;j<length;j++) {
                sum = (sum + (Math.abs(d[i] - d[j]) * Math.max(p[i], p[j])) % MOD) % MOD;
            }
        }
        return sum;
    }
}
/*
2
3
1 3 6
10 20 30
5
5 55 555 55555 555555
3333 333 333 33 35
 */
