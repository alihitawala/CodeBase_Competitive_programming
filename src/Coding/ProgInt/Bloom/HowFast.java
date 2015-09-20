package Coding.ProgInt.Bloom;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/20/15.
 */
public class HowFast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();
        System.out.println(solve(n, k, t));
    }

    private static int solve(int n, int k, int t) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        int i = 1;
        int time = 0;
        while (a.get(a.size()-1) < n) {
            int prev = a.get(i-1);
            if (a.size() >= k) {
                int last = a.get(i-k);
                int x = 2*(prev - last) + last;
                a.add(x);
            }
            else {
                a.add(2*prev);
            }
            i++;
            time += t;
        }
        return time;
    }
}
