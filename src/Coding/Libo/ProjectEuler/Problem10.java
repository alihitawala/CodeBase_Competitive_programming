package Coding.Libo.ProjectEuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/10/15.
 */
public class Problem10 {
    private static final int LIMIT = 1100000;
    private static boolean[] isComposite = new boolean[LIMIT];
    private static long[] cache = new long[LIMIT];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initCache();
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            int num = in.nextInt();
            long answer = cache[num];
            System.out.println(answer);
        }
    }

    private static void initCache() {
        initializePrime();
        for (int i=2;i<LIMIT;i++) {
            if (isPrime(i))
                cache[i] = cache[i-1] + i;
            else
                cache[i] = cache[i-1];
        }
    }

    private static boolean isPrime(int i) {
        return !isComposite[i];
    }

    private static void initializePrime() {
        for (int i=2;i*i<LIMIT;i++) {
            for (int j=i*i; j<LIMIT;j+=i) {
                isComposite[j] = true;
            }
        }
    }
}
