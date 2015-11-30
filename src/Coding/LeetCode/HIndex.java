package Coding.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/30/15.
 */
public class HIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a[j] = x;
        }
        System.out.println(new HIndex().hIndex(a));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int j=0;
        for (int i=citations.length-1;i>=0;i--) {
            if (citations[i] >=j+1)
                j++;
            else
                return j;
        }
        return citations.length;
    }
}
