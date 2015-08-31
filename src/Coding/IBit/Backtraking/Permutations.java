package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Permutations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(permute(a));
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] b=new boolean[a.size()];
        recursion(a, list, result, b);
        return result;
    }

    private static void recursion(ArrayList<Integer> a, ArrayList<Integer> list,
                                  ArrayList<ArrayList<Integer>> result, boolean[] b) {
        if (a.size() == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<a.size();i++) {
            if (!b[i]){
                list.add(a.get(i));
                b[i] = true;
                recursion(a, list, result, b);
                b[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
