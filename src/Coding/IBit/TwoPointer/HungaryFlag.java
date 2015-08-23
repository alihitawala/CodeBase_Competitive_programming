package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class HungaryFlag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        sortColors(a);
    }

    public static void sortColors(ArrayList<Integer> a) {
        int i = 0;
        int j = a.size();
        for (int k=0;k<j;) {
            int x = a.get(k);
            if (x == 0) {
                swap(a, i, k);
                i++;
                k++;
            }
            else if (x == 2) {
                j--;
                swap(a, j, k);
            }
            else
                k++;
        }
        print(a);
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    private static void print(ArrayList<Integer> intersect) {
        for (int i: intersect) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
