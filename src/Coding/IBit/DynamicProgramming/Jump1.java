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
        System.out.println(new Jump1().findHops(a));
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

    public int jump(int[] a) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < a.length; ++i) {
            if (i > last) {
                last = curr;
                if (i > last)
                    return -1;
                ++ret;
            }
            curr = Math.max(curr, i+a[i]);
        }
        return ret;
    }

    public ArrayList<String> findHops(ArrayList<Integer> array) {
        ArrayList<String> hops = new ArrayList<>();
        int lReach = 0, curReach = 0, selIndex = 0;
        int i;
        for (i = 0; i < array.size(); i++) {
            if (i > curReach) break;
            if (i > lReach) {
                lReach = curReach;
                hops.add(String.valueOf(selIndex));
            }
            int sum = i + array.get(i);
            if (sum > curReach) selIndex = i;
            curReach = Math.max(curReach, sum);
        }
        System.out.println(i);
        if (i > lReach && hops.size() > 0 && Integer.parseInt(hops.get(hops.size() - 1)) != selIndex)
            hops.add(String.valueOf(selIndex));

        if (lReach >= array.size() - 1)
            return hops;
        else {
            ArrayList<String> failure = new ArrayList<>();
            failure.add("failure");
            return failure;
        }
    }
}
