package Coding.Libo.DP;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/10/15.
 */
public class ModFibo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long firstTerm = in.nextLong();
        long secondTerm = in.nextLong();
        int term = in.nextInt();
        long[] answer = new long[term+1];
        answer[0] = firstTerm;
        answer[1] = secondTerm;
        for (int i=2;i<term;i++) {
            answer[i] = answer[i-1] * answer[i-1] + answer[i-2];
            System.out.println(answer[i]);
        }
        System.out.println(answer[term-1]);
    }
}
