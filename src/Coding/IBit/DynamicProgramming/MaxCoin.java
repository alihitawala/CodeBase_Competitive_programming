package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class MaxCoin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(new MaxCoin().maxcoin(a));
    }

    public int maxcoin(ArrayList<Integer> a) {
        int len = a.size();
        int[][] cache = new int[len][len];
        for (int gap = 0; gap < len; gap++) {
            for (int i=0, j=gap;j<len;j++, i++) {
                int x = (i+2 <= j) ? cache[i+2][j] : 0;
                int y = (i+1 <= j-1) ? cache[i+1][j-1] : 0;
                int z = (i <= j-2) ? cache[i][j-2] : 0;
                cache[i][j] = Math.max(a.get(i) + Math.min(x,y), a.get(j) + Math.min(y,z));
            }
        }
        return cache[0][len-1];
    }
}
