package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class Mice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> A = new ArrayList<Integer>();
            ArrayList<Integer> B = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
                int b = in.nextInt();
                B.add(b);
            }
            System.out.println(new Mice().mice(A, B));
        }
    }

    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int max = 0;
        for (int i = 0; i < a.size(); i++) {
            int c = Math.abs(a.get(i) - b.get(i));
            if (c>max)
                max =c;
        }
        return max;
    }
}
