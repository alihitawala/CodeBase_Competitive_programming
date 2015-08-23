package Coding.IBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class SingleXor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int x = in.nextInt();
                a.add(x);
            }
            System.out.println(singleNumber(a));
        }
    }

    public static int singleNumber(final List<Integer> a) {
        int num=a.get(0);
        for (int i=1;i<a.size();i++) {
            num=num^a.get(i);
        }
        return num;
    }
}
