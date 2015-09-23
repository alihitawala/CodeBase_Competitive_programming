package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class Bulb {
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
            System.out.println(new Bulb().bulbs(A));
        }
    }

    public int bulbs(ArrayList<Integer> a) {
        int turn = 0;
        for (Integer i : a) {
            if (turn % 2 == 0 && i == 0 || (turn % 2 != 0 && i == 1)) {
                turn++;
            }
        }
        return turn;
    }
}
