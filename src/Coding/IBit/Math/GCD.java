package Coding.IBit.Math;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m= in.nextInt();
            System.out.println((gcd(n,m)));
        }
    }

    private static int gcd(int n, int m) {
        if (n==1 || m == 1)return 1;
        if (m==0) return n;
        if (n==0) return m;
        if (n == m) return n;
        if (n>m) return gcd(n-m,m);
        if (n<m) return gcd(n,m-n);
        return 0;
    }
}
