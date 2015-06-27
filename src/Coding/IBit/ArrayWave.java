package Coding.IBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/23/15.
 */
public class ArrayWave {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        ArrayList<Integer> contiguousMax = wave(a);
        for (long k : contiguousMax) {
            System.out.println(k);
        }
    }

    private static ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> b = new ArrayList<Integer>(a.size());
        for (int i=0, k =0;i<a.size();i++) {
            if (i % 2 != 0) {
                b.add(a.get(i));
                b.add(a.get(i-1));
            }
        }
        if (a.size() %2 != 0 ) {
            b.add(a.get(a.size()-1));
        }
        return b;
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);

    }
}
