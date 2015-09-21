import java.util.Scanner;

/**
 * Created by aliHitawala on 9/20/15.
 */
public class AliceBob {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(a));
    }

    private static int solve(int[] a) {
        return recursion(a, 0, a.length-1, true);
    }

    private static int recursion(int[] a, int i, int j, boolean turn) {
        if (i == j && turn)
            return a[i];
        else if(i==j)
                return 0;
        else if (i+1 == j && turn)
            return Math.max(a[i], a[j]);
        else if (i+1 == j)
            return Math.min(a[i], a[j]);
        return turn ? Math.max(a[i] + recursion(a, i+1, j, !turn), a[j] + recursion(a, i, j-1, !turn)) :
                a[i]>a[j] ? recursion(a, i+1, j, !turn) : recursion(a, i, j-1, !turn);
    }
}
