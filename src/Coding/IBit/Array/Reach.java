package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/7/15.
 */
public class Reach {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> X = new ArrayList<Integer>();
            ArrayList<Integer> Y = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int x = in.nextInt();
                int y = in.nextInt();
                X.add(x);
                Y.add(y);
            }
            System.out.println(new Reach().coverPoints(X, Y));
        }
    }
    public int coverPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.size() == 0)
            return 0;
        int length = x.size();
        int a = x.get(0);
        int b = y.get(0);
        int result = 0;
        for (int i = 1; i < length; i++) {
            int cur_a = x.get(i);
            int cur_b = y.get(i);
            int abs_x = Math.abs(a - cur_a);
            int abs_y = Math.abs(b-cur_b);
            result += Math.max(abs_x,abs_y);
            a = cur_a;
            b = cur_b;
        }
        return result;
    }
}
