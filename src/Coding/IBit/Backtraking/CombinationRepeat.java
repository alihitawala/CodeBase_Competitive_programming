package Coding.IBit.Backtraking;

import java.util.*;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class CombinationRepeat {

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

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int sum) {
        HashSet<Integer> set = new HashSet<>(a);
        ArrayList<Integer> ar = new ArrayList<>(set);
        Collections.sort(ar);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> holder = new ArrayList<>();
        recursiveCall(ar, 0, sum, holder, result);
        return result;
    }

    private static void recursiveCall(ArrayList<Integer> a, int index, int sum, ArrayList<Integer> holder, ArrayList<ArrayList<Integer>> result) {
        if (sum < 0)
            return;
        if (index == a.size()) {
            if (sum==0) {
                result.add(new ArrayList<>(holder));
            }
        }
        else {
            int t = a.get(index);
            holder.add(t);
            recursiveCall(a, index, sum - t, holder, result);
            holder.remove(holder.size() - 1);
            recursiveCall(a, index + 1, sum, holder, result);
        }
    }
}
