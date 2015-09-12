package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/12/15.
 */
public class Stock1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(new Stock1().maxProfit(a));
    }
    public int maxProfit(final List<Integer> a) {
        int min = a.get(0);
        int max = a.get(0);
        int diff = 0;
        for (int i = 1; i < a.size(); i++) {
            int item = a.get(i);
            if (item > max) {
                max = item;
            }
            else if (item < min) {
                min = item;
                max = item;
            }
            if (diff < (max-min))
                diff = max-min;
        }
        return diff;
    }
}
