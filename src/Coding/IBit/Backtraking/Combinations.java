package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Combinations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            int y =in.nextInt();
            System.out.println(combine(x, y));
        }
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        recursion(n,0,k,0, list, result);
        return result;
    }

    private static void recursion(int n, int num, int k, int tillNow,
                                  ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (tillNow == k && num <= n) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        else if (num > n)
        {
            return;
        }
        list.add(num+1);
        recursion(n, num + 1, k, tillNow + 1, list, result);
        list.remove(list.size() - 1);
        recursion(n, num + 1, k, tillNow, list, result);
    }
}
