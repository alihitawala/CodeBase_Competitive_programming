package Coding.IBit.Hashing;

import Coding.IBit.Array.IBit;

import java.util.*;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class Equals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            Integer x =in.nextInt();
            a.add(x);
        }
        System.out.println(equal(a));
    }

    public static ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Pair> map = new HashMap<>();
        final ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tempResults = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                if (map.containsKey(sum)) {
                    Pair old = map.get(sum);
                    if (old.x < i && old.y != j && old.y != i)
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(old.x);
                        temp.add(old.y);
                        temp.add(i);
                        temp.add(j);
                        tempResults.add(temp);
                    }
                }
                else
                    map.put(sum, new Pair(i,j));
            }
        }
        Collections.sort(tempResults, new Comparator<ArrayList<Integer>>() {
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
        return tempResults.isEmpty() ? result : tempResults.get(0);
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
