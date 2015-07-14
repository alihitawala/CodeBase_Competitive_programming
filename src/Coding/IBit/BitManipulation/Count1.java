package Coding.IBit.BitManipulation;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class Count1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println((numSetBits(n)));
        }
    }
    public static int numSetBits(long A) {
        int count=0;
        while(A>0) {
            A&=(A-1);
            count++;
        }
        return count;
    }
}
