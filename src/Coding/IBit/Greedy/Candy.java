package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class Candy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println(new Candy().candy(A));
        }
    }
    public int candy(ArrayList<Integer> a) {
        int count = 0;
        int len = a.size();
        int[] cache = new int[len];
        cache[0] = 1;
        for (int i = 1; i < a.size(); i++) {
            int x = a.get(i);
            if (x > a.get(i-1))
                cache[i] = cache[i-1] +1;
            else
                cache[i] = 1;
        }
        for (int i = len-2; i >=0 ; i--) {
            int x = a.get(i);
            if (x > a.get(i+1))
                cache[i] = Math.max(cache[i], cache[i+1]+1);
        }
        for (int i = 0; i < a.size(); i++) {
            count += cache[i];
        }
        return count;
    }

    static class RatingPair {
        int num;
        int rating;

        public RatingPair(int num, int rating) {
            this.num = num;
            this.rating = rating;
        }
    }
}
