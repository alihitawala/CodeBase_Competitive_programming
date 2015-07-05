package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class SetZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for (int j=0;j<n;j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int k=0;k<m;k++) {
                    temp.add(in.nextInt());
                }
                a.add(temp);
            }
            new SetZero().setZeroes(a);
            printArray(a);
        }
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int column = A.get(0).size();
        boolean isRowZero = false;
        boolean isColumnZero = false;
        for (int i=0;i<column;i++)
            if (A.get(0).get(i) == 0)
                isRowZero = true;
        for (int i=0;i<row;i++)
            if (A.get(i).get(0) == 0)
                isColumnZero = true;
        for (int i=1;i<row;i++)
            for (int j=1;j<column;j++)
                if (A.get(i).get(j) == 0) {
                    A.get(i).set(0, 0);
                    A.get(0).set(j, 0);
                }
        for (int i=1;i<row;i++)
            for (int j=1;j<column;j++)
                if (A.get(i).get(0) == 0 || A.get(0).get(j) == 0) {
                    A.get(i).set(j, 0);
                }

        for (int i=0;i<column && isRowZero;i++)
            A.get(0).set(i,0);
        for (int i=0;i<row && isColumnZero;i++)
            A.get(i).set(0,0);
    }

    private static void printArray(ArrayList<ArrayList<Integer>> solve) {
        for (ArrayList<Integer> i :solve) {
            for (int j : i)
                System.out.print(j + " " );
            System.out.println();
        }
    }
}
