package Coding.ProgInt;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class MaxSum2D {
    public static void main(String[] args) {
        int i = 3;
        int j = 4;
        int[][] a = new int[i][j];
        a[0] = new int[]{1, -1, 3, 4};
        a[1] = new int[]{2, 10, -2, -9};
        a[2] = new int[]{9, 5, -3, -2};
        System.out.println(maxSum(a));
        System.out.println(naiveMethod(a));
    }

    private static int maxSum(int[][] a) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<a.length;i++) {
            for (int j=i;j<a.length;j++) {
                int[] tempSum = new int[a[0].length];
                for (int p=i;p<=j;p++) {
                    for (int q=0;q<a[0].length;q++) {
                        tempSum[q] += a[p][q];
                    }
                }
                int temp = maxSum(tempSum);
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }

    private static int maxSum(int[] a) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : a) {
            if (temp + i > 0) {
                temp += i;
                if (temp > max)
                    max = temp;
            } else {
                temp = 0;
            }
        }
        return max;
    }

    private static int naiveMethod(int[][] a) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[0].length;j++) {
                for (int k=i;k<a.length;k++) {
                    for (int l=j;l<a[0].length;l++) {
                        int temp = 0;
                        for (int p=i;p<=k;p++) {
                            for (int q=j;q<=l;q++) {
                                temp+=a[p][q];
                            }
                        }
                        if (temp > max)
                            max = temp;
                    }
                }
            }
        }
        return max;
    }
}
