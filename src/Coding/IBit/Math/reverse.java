package Coding.IBit.Math;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class reverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println((reverse(n)));
        }
    }

    private static int reverse(int n) {
        int sign = n <0?-1:1;
        n = Math.abs(n);
        long result = 0;
        while(n != 0) {
            result = result*10 + n%10;
            n/=10;
        }
        if (result > Integer.MAX_VALUE) return 0;
        if (sign < 0 && -result < Integer.MIN_VALUE) return 0;
        return (int)result*sign;
    }
}
