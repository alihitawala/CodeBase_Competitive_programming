package Coding.Libo.Sorting;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class Partition {
    static void partition(int[] a) {
        int  p = a[0];
        int i=0, j=a.length-1;
        while (i<j) {
            while (a[i] < p)
                i++;
            while (a[j] > p)
                j--;
            if (i<j)
                swap(a,i,j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        partition(ar);
        printArray(ar);
    }
}
