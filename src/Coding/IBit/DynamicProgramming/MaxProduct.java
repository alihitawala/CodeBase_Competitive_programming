package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/11/15.
 */
public class MaxProduct {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(maxProduct(a));
    }
    private static final int MOD = 1000007;

    public static int maxProduct(final List<Integer> a) {
        int max_positive=1,min_negative=1;
        int max_so_far = 1;
        if (isAllElementZeroOrNegative(a))
            return 0;
        for (int i = 0; i < a.size(); i++) {
            int item = a.get(i);
            if (item > 0) {
                max_positive = max_positive * item;
                min_negative = Math.min(min_negative * item, 1);
            }
            else if (item == 0) {
                min_negative=1;
                max_positive=1;
            }
            else {
                int temp = max_positive;
                max_positive = Math.max(min_negative*item, 1);
                min_negative = temp * item;
            }
            if (max_so_far < max_positive)
                max_so_far = max_positive;
        }
        return max_so_far;
    }

    private static boolean isAllElementZeroOrNegative(List<Integer> a) {
        int count = 0;
        for (int i: a) {
            if (i > 0)
                return false;
            else if (i < 0) {
                count++;
                if (count > 1)
                    return false;
            }
            else if (count > 0)
                count--;
        }

        return count < 2;
    }
}
