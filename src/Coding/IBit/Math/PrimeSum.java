package Coding.IBit.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeSum {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(new PrimeSum().primesum(a));
    }
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> X = new ArrayList<Integer>();
        int squareroot = (int)Math.sqrt(a);
        boolean[] A = new boolean[a+1];

        for (int i = 0; i<=a; i++) {
            A[i] = true;
        }

        for (int i = 2; i <= squareroot; i++) {
            if (A[i]) {
                for (int j = i*i; j <= a; j+=i) {
                    A[j] = false;
                }
            }
        }
        for (int i = 2; i <= a/2; i++) {
            if (A[i] && A[a-i]) {
                X.add(i);
                X.add(a-i);
                break;
            }
        }

        return X;
    }
}
