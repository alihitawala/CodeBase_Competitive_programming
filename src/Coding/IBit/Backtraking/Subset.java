package Coding.IBit.Backtraking;

import java.util.*;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class Subset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(subsets(a));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> holder = new ArrayList<>();
        Collections.sort(a);
        recursiveCall(a, 0, holder, result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int sa = a.size();
                int sb = b.size();
                for (int i=0;i<Math.min(sa,sb);i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(sa,sb);
            }
        });
        return result;
    }

    private static void recursiveCall(ArrayList<Integer> a, int index, ArrayList<Integer> tillNow, ArrayList<ArrayList<Integer>> result) {
        if (index == a.size())
        {
            ArrayList<Integer> safe = new ArrayList<>(tillNow);
            result.add(safe);
        }
        else {
            recursiveCall(a, index + 1, tillNow, result);
            tillNow.add(a.get(index));
            recursiveCall(a, index + 1, tillNow, result);
            tillNow.remove(tillNow.size() - 1);
        }
    }
}
