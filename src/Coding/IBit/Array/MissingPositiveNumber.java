package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class MissingPositiveNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println(new MissingPositiveNumber().firstMissingPositive(A));
        }
    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        for (int i=0;i<A.size();i++) {
            int temp = A.get(i);
            while (temp > 0 && temp <= A.size()) {
                int t = A.get(temp-1);
                A.set(temp-1, 0);
                temp = t;
            }
        }
        for (int i=0;i<A.size();i++) {
            if (A.get(i) != 0) {
                return i+1;
            }
        }
        return A.size()+1;
    }
}
