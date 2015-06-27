package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/7/15.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            long num = in.nextLong();
            long b = 1;
            long c = 2, d;
            long sum = 0;
            while(c < num) {
                sum += c;
                d = b+(c << 0x01);
                c = d+b+c;
                b = d;
            }
            System.out.println(sum);
        }
    }
}
