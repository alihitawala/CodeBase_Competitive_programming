package Coding.ACM_ICPC;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class Restaurant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int  n = in.nextInt();
            if (n == 0)
                return;
            int sum = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                a[i] = x;
                sum+=x;
            }
            System.out.println(solve(a, sum, n));
        }

    }

    private static long solve(int[] a, int sum, int n) {
        long result = 0;
        //with all n sum = i
        result += remaining(n, sum-1);
        int k=0;
        for (int i = 0; i < a.length-1; i++) {
            int x = a[i];
            k++;
            for (int j = 0; j < x; j++) {
                result += remainingSum(n-k, sum-j);
            }
            sum-=x;
        }
        return result+1;
    }

    private static long remainingSum(int n, int sum) {
        long result = 0;
        result += binomial(n+sum-1, sum);
        return result;
    }

    private static long remaining(int n, int sum) {
        long result = 0;
        for (int i = 0; i <= sum; i++) {
            if (i == 0)
                result += 1;
            else
                result += binomial(n+i-1, i);
        }
        return result;
    }

    static long binomial(final int N, final int K) {
        long ret = 1;
        for (int k = 0; k < K; k++) {
            ret = ret * (N-k)/(k+1);
        }
        return ret;
    }

}
