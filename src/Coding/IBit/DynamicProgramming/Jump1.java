package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/12/15.
 */
public class Jump1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(new Jump1().canJump(a));
    }

    public int canJump(ArrayList<Integer> a) {
        if (a.isEmpty())
            return 0;
        int till = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (till == 0)
                return 0;
            int value = a.get(i);
            till--;
            if (till < value)
                till = value;
        }
        return 1;
    }
}
