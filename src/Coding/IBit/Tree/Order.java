package Coding.IBit.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/9/15.
 */
public class Order {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> h = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            h.add(x);
        }
        ArrayList<Integer> ifront = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            ifront.add(x);
        }
        System.out.println(solve(h, ifront));
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> h, ArrayList<Integer> ifront) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < h.size(); i++) {
            pairs.add(new Pair(h.get(i), ifront.get(i)));
        }
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.height - o2.height;
            }
        });
        for (int i = pairs.size()-1; i >=0 ; i--) {
            Pair pair = pairs.get(i);
            int skip = pair.infront;
            pairs.remove(i);
            pairs.add(i+skip, pair);
        }
        for (Pair p : pairs) {
            result.add(p.height);
        }
        return result;
    }

    static class Pair {
        int height;
        int infront;

        public Pair(int height, int infront) {
            this.height = height;
            this.infront = infront;
        }
    }
}
