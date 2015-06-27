package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/9/15.
 */
public class Problem5 {
    private static final int LIMIT = 100;
    private static final int ELEMENTS = 41;
    private static boolean[] isComposite = new boolean[LIMIT];
    private static long[] cache = new long[ELEMENTS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initializePrimes();
        initializeCache();
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            int num = in.nextInt();
            long answer = cache[num];
            System.out.println(answer);
        }
    }

    private static void initializeCache() {
        long num = 1;
        for (int i=1;i<ELEMENTS;i++ ) {
            if (num%i == 0);
            else if (isPrime(i)) num*=i;
            else if (i % 2 == 0) num *=2;
            else if (i % 3 == 0) num*=3;
            cache[i] = num;
        }
    }

    private static boolean isPrime(int i) {
        return !isComposite[i];
    }

    private static void initializePrimes() {
        for (int i= 2;i*i<LIMIT;i++) {
            if (!isComposite[i]) {
                for (int j=i*i;j<LIMIT;j+=i) {
                    isComposite[j]=true;
                }
            }
        }
    }
}
