package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/23/15.
 */
public class Majority {
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
            System.out.println(new Majority().majorityElement(A));
        }
    }

    public int majorityElement(final List<Integer> a) {
        int majority = a.get(0);
        int count = 1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) == majority)
                count++;
            else if (count == 1)
                majority = a.get(i);
            else
                count--;
        }
        return majority;
    }
}
