package Coding.IBit.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by aliHitawala on 10/27/15.
 */
public class GroupNumbers {
    public static void main(String[] args) {
//        System.out.println(combinations(3,2));
//        System.out.println(combinations(7,4));
//        int[][] answer = group(7,4);
//        for (int[] a : answer) {
//            for (int i : a)
//                System.out.print(i + " ");
//            System.out.println();
//        }
        int[] test  = {1,2,3,4};
        System.out.println(sum(test, test.length-1, 1));
    }

    public static int sum(int[] a, int len, int h) {
        if (len == -1)
            return 0;
        int x = a[len];
        return x*h + sum(a, len-1, h*10);
    }

    public static int[][] group(int n, int g) {
        int[][] answer = new int[combinations(n-1, g-1)][g];
        int[] t = new int[g];
        count=0;
        solve(n,g,answer, t,0);
        return answer;
    }
    public static int count =0;
    private static void solve(int n, int g, int[][] answer, int[] t, int i) {
        if (g == 1)
        {
            t[i] = n;
            answer[count++] = Arrays.copyOf(t, t.length);
            return;
        }
        for (int j=1;j<=n-g+1;j++) {
            t[i] = j;
            solve(n-j,g-1,answer,t,i+1);
        }
    }

    public static int combinations(int n, int r) {
        int k=0;
        int num = 1;
        for (int i=1;i<=r;i++) {
            num = num * (n-k)/(k+1);
            k++;
        }
        return num;
    }
}
