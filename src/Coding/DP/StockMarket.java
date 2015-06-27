package Coding.DP;

/**
 * Created by aliHitawala on 5/16/15.
 */
public class StockMarket {

    public static void main(String[] args) {
        int[] a = {5,2,4,6,-2,3,6,8,9};
        int min = a[0];
        int max = a[0];
        int diff_max = -1;
        for (int i : a) {
            if (i < min) {
                min = i;
                max = i;
            } else if (i > max) {
                max = i;
                if ((max - min) > diff_max) {
                    diff_max = max-min;
                }
            }
        }
        if (diff_max > 0)
            System.out.println(diff_max);
    }
}
