package Coding.IBit.Math;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class FactorialZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println((numberZeroes(n)));
        }
    }

    private static int numberZeroes(int n) {
        int count = 0, fiveFactors=5;
        while ((n/fiveFactors) > 0) {
            count += n/fiveFactors;
            fiveFactors*=5;
        }
        return count;
    }
}
