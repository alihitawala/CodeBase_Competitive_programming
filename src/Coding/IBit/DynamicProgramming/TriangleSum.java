package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/25/15.
 */
public class TriangleSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x =in.nextInt();
                temp.add(x);
            }
            a.add(temp);
        }
        System.out.println(new TriangleSum().maximumTotal(a));
    }

    public int minimumTotal2(ArrayList<ArrayList<Integer>> a) {
        int[] cache = new int[a.size()];
        for (int i=0;i<a.size();i++) {
            for (int j=i;j>=0;j--) {
                int temp =a.get(i).get(j);
                if (i==0)
                    cache[i] = temp;
                else if (j==0)
                    cache[j] = temp + cache[j];
                else if (j == i)
                    cache[i] = temp + cache[i-1];
                else
                    cache[j] = Math.min(cache[j], cache[j-1])+temp;
            }
        }
        return getMin(cache);
    }

    public int maximumTotal(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] h = new int[m][n];

        h[m - 1][n - 1] = Math.max(1 - a.get(m-1).get(n-1), 1);

        for (int i = m - 2; i >= 0; i--) {
            h[i][n - 1] = Math.max(h[i + 1][n - 1] - a.get(i).get(n-1), 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            h[m - 1][j] = Math.max(h[m - 1][j + 1] - a.get(m-1).get(j), 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(h[i + 1][j] - a.get(i).get(j), 1);
                int right = Math.max(h[i][j + 1] - a.get(i).get(j), 1);
                h[i][j] = Math.min(right, down);
            }
        }

        return h[0][0];
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[][] cache = new int[a.size()][a.size()];
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<i+1;j++) {
                int temp =a.get(i).get(j);
                if (i==0)
                    cache[i][j] = temp;
                else if (j==0)
                    cache[i][j] = temp + cache[i-1][j];
                else if (j == i)
                    cache[i][j] = temp + cache[i-1][j-1];
                else
                    cache[i][j] = Math.min(cache[i-1][j], cache[i-1][j-1])+temp;
            }
        }
        return getMin(cache[a.size()-1]);
    }

    private int getMin(int[] a) {
        int min = Integer.MAX_VALUE;
        for(int i:a) {
            if (i <min)
                min = i;
        }
        return min;
    }
}
