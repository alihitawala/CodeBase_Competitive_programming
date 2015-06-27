package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/7/15.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            long num = in.nextLong();
            long multiplesThree = multipleSum(num-1, 3);
            long multiplesFive = multipleSum(num-1, 5);
            long multiplesFiveTeen = multipleSum(num-1, 15);
            long answer = multiplesFive - multiplesFiveTeen + multiplesThree;
            System.out.println(answer);//1001
        }
    }

    private static long multipleSum(long num, long multiplier) {
        long numberOfMultiples = num/multiplier;
        long last = num - (num % multiplier);
        return sumAP(multiplier, last, numberOfMultiples);
    }

    private static long sumAP(long a, long last, long n) {
        long temp = a+last;
        if (n %2 == 0) n/=2;
        else if (temp % 2 == 0) temp/=2;
        return n*temp;
    }
}
