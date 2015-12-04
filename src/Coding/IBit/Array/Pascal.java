package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/24/15.
 */
public class Pascal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            printArray(solve(n));
        }
    }

    private static void printArray(ArrayList<Integer> solve) {
        for (int i :solve) {
            System.out.print(i + " " );
        }
    }

    private static ArrayList<Integer> solve(int i) {
        int value = 1;
        ArrayList<Integer> v = new ArrayList<Integer>();
        for (int j=0;j<=i;j++) {
            v.add(value);
            value = value * (i-j)/(j+1);
        }
        return v;
    }
}
/*
ncr = n!/r!(n-r)!
nc(r+1) = n!/r!
n-r-1 = n-r!/n-r

N-R/R+1
 */
