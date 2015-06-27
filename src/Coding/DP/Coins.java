package Coding.DP;

/**
 * Created by aliHitawala on 5/10/15.
 */
public class Coins {
    public static void main(String[] args) {
        int totalAmount =99;
        int[] d = {5,3,1};
        int numD = d.length;
        int a[][] = new int[numD+1][totalAmount+1];
        for (int i=0;i<numD+1;i++) {
            a[i][0] = 0;
        }
        for (int i=0;i<totalAmount+1;i++) {
            a[0][i] = 10000;
        }
        for (int i=1;i<numD+1;i++) {
            for (int j=1;j<totalAmount+1;j++) {
                if (d[i-1] > j) {
                    a[i][j] = a[i-1][j];
                }
                else {
                    a[i][j] = Math.min(a[i-1][j], a[i][j-d[i-1]] +1) ;
                }
            }
        }
        System.out.println(a[numD][totalAmount]);
    }
}
