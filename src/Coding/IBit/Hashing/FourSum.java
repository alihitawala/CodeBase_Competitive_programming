package Coding.IBit.Hashing;

import java.util.*;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class FourSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            Integer x =in.nextInt();
            a.add(x);
        }
        int x = in.nextInt();
        System.out.println(fourSum(a, x));
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                Pair p =new Pair(i,j);
                if (map.containsKey(sum)) {
                    map.get(sum).add(p);
                }
                else {
                    List<Pair> pair = new ArrayList<>();
                    pair.add(p);
                    map.put(sum, pair);
                }
            }
        }
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = b-(a.get(i) + a.get(j));
                if (map.containsKey(sum)) {
                    List<Pair> pairs = map.get(sum);
                    for (Pair p : pairs) {
                        Set<Integer> ans = new HashSet<>();
                        ans.add(p.x);
                        ans.add(p.y);
                        ans.add(i);
                        ans.add(j);
                        if (ans.size() < 4)
                            continue;
                        ArrayList<Integer> an = new ArrayList<>(ans);
                        for (int k = 0; k < 4; k++) {
                            int value = a.get(an.get(k));
                            an.set(k, value);
                        }
                        Collections.sort(an);
                        result.add(an);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                for (int i = 0; i < a.size(); i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size()-1;) {
            int j = i+1;
            ArrayList<Integer> p = result.get(i);
            ArrayList<Integer> q = result.get(j);
            int k=0;
            for (; k < 4; k++) {
                if (!p.get(k).equals(q.get(k)))
                    break;;
            }
            if (k==4)
                result.remove(j);
            else {
                i=j;
            }
        }
        return result;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
