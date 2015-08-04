package Coding.ProgInt;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class ArrayEquilibrium {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,9,5,2,-1};
        System.out.println(equilibrium(a));
    }

    private static int equilibrium(int[] a) {
        int left = 0;
        int right = sumArray(a);
        for (int i=0;i<a.length;i++) {
            right -= a[i];
            if (left == right) return i;
            left += a[i];
        }
        return -1;
    }

    private static int sumArray(int[] a) {
        int total = 0;
        for (int i:a) {
            total+= i;
        }
        return total;
    }
}
