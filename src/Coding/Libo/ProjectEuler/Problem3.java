package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/7/15.
 */
public class Problem3 {
    private static final int LIMIT = 100000001;

    private static boolean[] isComposite = generatePrimes(LIMIT);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            long num = in.nextLong();
            long numSRoot = new Double(Math.sqrt((double) num)).longValue();
            long max = 0;
            for (int j=2;j<=numSRoot;j++) {
                if (num%j==0){
                    long temp = num/j;
                    if(isPrime(temp)) {
                        if (temp > max) max = temp;
                    }
                    if (isPrime(j)) {
                        if (j > max) max=j;
                    }
                }
            }
            if (max == 0) max = num;
            System.out.println(max);
        }
    }

    private static boolean isPrime (long n) {
        if (n<LIMIT) return !isComposite[(int)n];
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 ==0 || n % 3 == 0) return false;
        long i = 5;
        while (i*i < n) {
            if (n%i == 0 || n% (i+2) == 0) return false;
            i+=6;
        }
        return true;
    }

    private static boolean [] generatePrimes(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        return isComposite;
    }
}
