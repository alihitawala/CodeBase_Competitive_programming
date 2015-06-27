package Coding.Libo.Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class ClosestNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        Arrays.sort(a);
        int diff=Integer.MAX_VALUE;
        for (int i =0 ;i<n-1;i++) {
            int temp = a[i+1] - a[i];
            if (temp < diff) {
                diff = temp;
            }
        }
        for (int i =0 ;i<n-1;i++) {
            int temp = a[i+1] - a[i];
            if (temp == diff) {
                System.out.print(a[i] + " " + a[i+1] + " ");
            }
        }
    }
}
