package Coding.IBit.Hashing;

/**
 * Created by aliHitawala on 8/31/15.
 */
public class PuzzleSolution {
    public static void main(String[] args) {
        boolean[] b = new boolean[101];
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <=100 ; j+=i) {
                b[j] = !b[j];
            }
        }
        int count=0;
        for (int i = 1; i <= 100; i++) {
            if (b[i]) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
