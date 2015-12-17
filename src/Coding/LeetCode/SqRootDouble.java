package Coding.LeetCode;

/**
 * Created by aliHitawala on 11/17/15.
 */
public class SqRootDouble {
    public static void main(String[] args) {
        System.out.println(new SqRootDouble().sqRoot(309.0));
    }

    public double sqRoot (Double a) {
        if (a<0)
            return -1;
        if (a==1 || a==0)
            return a;
        double precision = 0.00001;
        double start = 0;
        double end = a > 1 ? a : 1;
        while (end-start > precision) {
            double mid = start + (end-start)/2;
            double sq = mid*mid;
            if (sq == a)
                return mid;
            if (a < sq)
                end = mid;
            else
                start = mid;
        }
        return (start + end)/2;
    }
}
