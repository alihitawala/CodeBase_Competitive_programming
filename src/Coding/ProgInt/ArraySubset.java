package Coding.ProgInt;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 7/29/15.
 */
public class ArraySubset {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        allSubset(a);
    }

    private static void allSubset(int[] a) {
        if (a.length == 0)
            return;
        ArrayList<Integer> b = new ArrayList<Integer>();
        _allSubset(a, 0, b);
    }

    private static void _allSubset(int[] a, int index, ArrayList<Integer> b) {
        if (index == a.length) {
            print(b);
            return;
        }
        b.add(a[index]);
        _allSubset(a, index + 1, b);
        b.remove(b.size() - 1);
        _allSubset(a, index + 1, b);
    }

    private static void print(ArrayList<Integer> a) {
        System.out.print("{");
        for (int i : a) {
            System.out.print(i);
        }
        System.out.print("}");
        System.out.println();
    }
}
