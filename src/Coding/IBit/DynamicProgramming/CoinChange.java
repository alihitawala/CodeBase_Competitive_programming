package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/11/15.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int b = in.nextInt();
        System.out.println(coinchange2_optimized(a, b));
    }
    private static final int MOD = 1000007;

    public static int coinchange2(ArrayList<Integer> a, int n) {
        int b[][] = new int[a.size()+1][n+1];
        for (int i = 0; i < a.size()+1; i++) {
            b[i][0] = 1;
        }
        for (int i = 1; i < a.size() + 1; i++) {
            int coinValue = a.get(i-1);
            for (int j = 1; j < n+1; j++) {
                int p=0;
                if (j - coinValue >-1)
                    p = b[i][j-coinValue];
                b[i][j] = (b[i-1][j]+p)%MOD;
            }
        }
        return b[a.size()][n];
    }

    public static int coinchange2_optimized(ArrayList<Integer> a, int n) {
        int b[] = new int[n+1];
        b[0]=1;
        for (int i = 0; i < a.size(); i++) {
            int coinValue = a.get(i);
            for (int j = coinValue; j < n+1; j++) {
                b[j] += b[j-coinValue];
            }
        }
        return b[n];
    }
}
