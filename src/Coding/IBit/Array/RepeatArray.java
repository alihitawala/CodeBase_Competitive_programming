package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class RepeatArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            List<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println(new RepeatArray().repeatedNumber(A));
        }
    }

    public int repeatedNumber(final List<Integer> A) {
        boolean[] cache = new boolean[A.size()+1];
        for (int i : A) {
            if(cache[i]) return i;
            cache[i] = true;
        }
        return 0;
    }
}
