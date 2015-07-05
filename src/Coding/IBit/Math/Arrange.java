package Coding.IBit.Math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class Arrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j=0;j<n;j++) {
                int temp = in.nextInt();
                a.add(temp);
            }
            arrange(a);
            printArray(a);
        }
    }

    private static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i=0;i<a.size();i++) {
            int x = a.get(a.get(i));
            int y = x%n;
            int z = y*n;
            a.set(i, a.get(i) + z);
        }
        for (int i=0;i<a.size();i++) {
            a.set(i, a.get(i)/n);
        }
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j,temp);
    }

    private static void printArray(ArrayList<Integer> solve) {
        for (int j : solve)
            System.out.print(j + " " );
    }
}
