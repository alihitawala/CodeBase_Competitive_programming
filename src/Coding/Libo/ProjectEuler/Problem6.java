package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/9/15.
 */
public class Problem6 {
    private static final int LIMIT = 1000001;
    private static final int CAP = 10001;
    private static long[] cache = new long[LIMIT];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initializeCache();
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            int num = in.nextInt();
            long answer = cache[num];
            System.out.println(answer);
        }
    }

    private static void initializeCache() {
        long answer = 0;
        for (int i=1;i<CAP;i++) {
            for (int j=1;j<i;j++) {
                answer+=2*i*j;
            }
            cache[i] = answer;
        }
    }
}
