package Coding.IBit.Array;

import java.util.*;

/**
 * Created by aliHitawala on 6/28/15.
 */
//not optimal solution
public class MaxGap {
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
            System.out.println(new MaxGap().maximumGap(A));
        }
    }

    public int maximumGap(final List<Integer> A) {
        Collections.sort(A);
        int maxDist = 0;
        int prev = A.get(0);
        for (int i : A) {
            int temp = i - prev;
            if (maxDist < temp) maxDist=temp;
            prev = i;
        }
        return maxDist;
    }
}
