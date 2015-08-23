package Coding.ProgInt;

/**
 * Created by aliHitawala on 8/6/15.
 */
public class LSP_Product {
    public static void main(String[] args) {
        double[] a = {0,2,0};
        System.out.println(LSP(a));
    }

    private static double LSP(double[] a) {
        double max=1,tempMaxPositive=1,tempMaxNegative=1, maxPositive=0, maxNegative=0;
        for (double i : a) {
            if (i > 0) {
                tempMaxPositive = tempMaxPositive * i;
                if (tempMaxNegative != 1)
                    tempMaxNegative = tempMaxNegative * i;
            } else if (i < 0) {
                if (tempMaxNegative != 1) {
                    double temp = tempMaxPositive;
                    tempMaxPositive = tempMaxNegative * i;
                    tempMaxNegative = temp * i;
                } else {
                    tempMaxNegative = tempMaxPositive * i;
                    tempMaxPositive = 1;
                }
            }
            else {
                tempMaxNegative=1;
                tempMaxPositive=1;
            }
            if (tempMaxNegative < maxNegative)
                maxNegative = tempMaxNegative;
            if (tempMaxPositive > maxPositive)
                maxPositive = tempMaxPositive;
            if (tempMaxPositive < 0)
                tempMaxPositive = 1;
        }
        return maxPositive;
    }
}
