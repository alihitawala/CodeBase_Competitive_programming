package Coding.IBit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/25/15.
 */

public class Spiral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            printArray(solve(n));
        }
    }

    private static ArrayList<ArrayList<Integer>> solve(int n) {
        int[][] b = new int[n][n];
        int i=0,j=0;
        fillArray(b, 0 ,0, n, 1);
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        copyArray(b,a);
        return a;
    }

    private static void copyArray(int[][] b, ArrayList<ArrayList<Integer>> a) {
        for (int[] i : b) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j : i) {
                temp.add(j);
            }
            a.add(temp);
        }
    }

    private static void fillArray(int[][] a, int i, int j, int n, int value) {
        if (n < 1) return;
        if (n==1) {
            a[i][j] = value;
            return;
        }

        int k=j;
        for (;k<n+i;k++) {
            a[i][k] = value++;
        }
        k--;
        int l=i+1;
        for (;l<n+j;l++) {
            a[l][k] = value++;
        }
        k--; l--;
        for (;k>=j;k--) {
            a[l][k] = value++;
        }
        k++; l--;
        for (;l>i;l--) {
            a[l][k] = value++;
        }
        fillArray(a, i+1,j+1,n-2,value);
    }

    private static void printArray(ArrayList<ArrayList<Integer>> solve) {
        for (ArrayList<Integer> i :solve) {
            for (int j : i)
                System.out.print(j + " " );
            System.out.println();
        }
    }
}
