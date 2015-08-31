package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Subset2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(subsetsWithDup(a));
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(a);
        recursion(a, 0, list, result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int p = a.size();
                int q = b.size();
                for (int i = 0; i < Math.min(p, q); i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return p - q;
            }
        });
        eliminateDuplicate(result);
        return result;
    }

    private static void eliminateDuplicate(ArrayList<ArrayList<Integer>> result) {
        for (int i = 0; i < result.size()-1;) {
            int j = i+1;
            ArrayList<Integer> a = result.get(i);
            ArrayList<Integer> b = result.get(j);
            int p = a.size();
            int q = b.size();
            if (p != q) {
                i=j;
                continue;
            }
            int k=0;
            for (; k < p; k++) {
                if (!a.get(k).equals(b.get(k)))
                    break;
            }
            if (k == p) {
                result.remove(j);
            } else {
                i=j;
            }
        }
    }

    private static void recursion(ArrayList<Integer> a, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (index == a.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        recursion(a, index+1, list, result);
        list.add(a.get(index));
        recursion(a, index + 1, list, result);
        list.remove(list.size()-1);
    }
}
