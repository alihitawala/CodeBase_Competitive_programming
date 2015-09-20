package Coding.DS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/11/15.
 */
public class Sieve {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int num = in.nextInt();
            System.out.println(new Sieve().primesum(num));
        }
    }

    public ArrayList<Integer> primesum(int A) {
        if (A < 4)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        initPrimes();
        if (!b[2] && !b[A-2]) {
            result.add(2);
            result.add(A-2);
        }
        else {
            for (int i = 3; i <= A / 2; i+=3) {
                if (!b[i] && !b[A - i]) {
                    result.add(i);
                    result.add(A - i);
                }
            }
        }
        return result;
    }

    private static final int MAX = 1000000;
    private static boolean[] b = new boolean[MAX];
    private void initPrimes(){
        b[0] = true;
        b[1] = true;
        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (!b[i]) {
                for (int j = i*i; j < MAX; j+=i) {
                    b[j] = true;
                }
            }
        }
    }
}
