package Coding.IBit.BitManipulation;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class Reverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println(Long.toBinaryString(n));
            System.out.println(Long.toBinaryString(reverseBit(n)));
            System.out.println(Long.toBinaryString(reverse(n)));
            System.out.println((reverse(n)));
        }
    }
    private static int reverseBit (int a) {
        int result = 0;
        while (a != 0) {
            result = (result << 1) | (a&1);
            a>>=1;
        }
        return result;
    }
    public static long reverse(long A) {
        long n=0;
        A = ((A& 0xAAAAAAAA) >>1) | ((A& 0x55555555)<<1);
        A = ((A& 0xCCCCCCCC) >>2) | ((A& 0x33333333)<<2);
        A = ((A& 0xF0F0F0F0) >>4) | ((A& 0x0F0F0F0F)<<4);
        A = ((A& 0xFF00FF00) >>8) | ((A& 0x00FF00FF)<<8);
        A = ((A& 0xFFFF0000) >>16) | ((A& 0x0000FFFF)<<16);
        return A;
    }
}
