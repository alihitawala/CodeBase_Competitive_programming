package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/17/15.
 */
public class Stock2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(new Stock2().maxProfit(a));
    }

    public int maxProfit(final List<Integer> a) {
        if (a.size() == 1)
            return 0;
        boolean isLocalMin = false;
        int min = 0;
        long result = 0;
        for (int i = 0; i < a.size(); i++) {
            if (i==0 && a.get(i+1) > a.get(i) || (i>0 && i<a.size()-1 && a.get(i-1) >= a.get(i) && a.get(i+1) > a. get(i))) {
                isLocalMin =true;
                min = a.get(i);
            }
            else if (isLocalMin && (((i>0) && i<a.size()-1 && a.get(i-1) <= a.get(i) && a.get(i+1) < a.get(i)) ||
                    i == a.size()-1 && a.get(i-1) <=a.get(i))) {
                long diff = a.get(i) - min;
                result += diff;
                isLocalMin = false;
            }
        }
        return (int)result;
    }
}
