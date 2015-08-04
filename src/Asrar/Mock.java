package Asrar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/25/15.
 */
public class Mock {

    public static ArrayList<ArrayList<Integer>> one (ArrayList<ArrayList<Integer>> a) {
        int n =a.size();
        int m = a.get(0).size();

        for (int j=0;j<n;j++) {
            ArrayList<Integer> temp = a.get(j);
            for (int k=0;k<m;k++) {
                if (a.get(j).get(k) == 1)
                {
                    a.set(j,new ArrayList<Integer>());
                }
            }
            a.add(temp);
        }

        return a;
    }

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
            printArray(one(a));
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
