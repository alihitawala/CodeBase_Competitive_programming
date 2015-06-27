package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/9/15.
 */
public class Problem9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            int num = in.nextInt();
            long answer = getAnswer(num);
            System.out.println(answer);
        }
    }

    private static long getAnswer(int num) {
        long answer=-1;
        for (int i=1;i<num/3+1;i++) {
            for (int j=i+1;j<num/2+2;j++) {
                int k = num -i-j;
                if (i*i + j*j == k*k) {
                    answer = i*j*k;
                }
            }
        }
        return answer;
    }
}
