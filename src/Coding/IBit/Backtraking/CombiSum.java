package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class CombiSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int x = in.nextInt();
        System.out.println(combinationSum(a, x));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> holder = new ArrayList<>();
        recursiveCall(a, 0, num, holder, result);
        return result;
    }

    private static void recursiveCall(ArrayList<Integer> a, int index, int num, ArrayList<Integer> holder, ArrayList<ArrayList<Integer>> result) {
        if (index == a.size() && num == 0) {
            ArrayList<Integer> safe = new ArrayList<>(holder);
            Collections.sort(safe);
            if (!checkArrayAlreadyExists(safe, result))
                result.add(safe);
        }
        else if (index == a.size())
            return;
        else {
            recursiveCall(a, index+1, num, holder, result);
            int x = a.get(index);
            holder.add(x);
            recursiveCall(a, index+1, num-x, holder, result);
            holder.remove(holder.size()-1);
        }
    }

    private static boolean checkArrayAlreadyExists(ArrayList<Integer> source, ArrayList<ArrayList<Integer>> target) {
        for (ArrayList<Integer> a : target)
            if(a.equals(source))
                return true;
        return false;
    }
}
