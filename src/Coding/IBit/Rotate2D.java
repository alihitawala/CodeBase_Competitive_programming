package Coding.IBit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/25/15.
 */
public class Rotate2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for (int j=0;j<n;j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int k=0;k<n;k++) {
                    temp.add(in.nextInt());
                }
                a.add(temp);
            }
            rotate(a);
            printArray(a);
        }

    }
    public static void rotate(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<n;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<n;j++) {
                temp.add(A.get(n-j-1).get(i));
            }
            b.add(temp);
        }
        A.clear();
        for (int i=0;i<n;i++) {
            ArrayList<Integer> temp = b.get(i);
            A.add(temp);
        }
    }


    private static void printArray(ArrayList<ArrayList<Integer>> solve) {
        for (ArrayList<Integer> i :solve) {
            for (int j : i)
                System.out.print(j + " " );
            System.out.println();
        }
    }
}
