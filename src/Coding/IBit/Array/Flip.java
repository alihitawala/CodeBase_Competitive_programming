package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/8/15.
 */
public class Flip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(new Flip().flip(s));
    }
    public ArrayList<Integer> flip(String a) {
        int[] cache = new int[a.length()];
        ArrayList<Integer> result = new ArrayList<>();
        cache[0] = a.charAt(0) == '1' ? 0 :1;
        int max = cache[0];
        int lastIndex = cache[0] == 1 ? 0 : -1;
        for (int i = 1; i < a.length(); i++) {
            cache[i] = cache[i-1] + (a.charAt(i) == '0' ? 1: -1);
            cache[i] = cache[i] < 0 ? 0 : cache[i];
            if (max < cache[i]) {
                max = cache[i];
                lastIndex = i;
            }
        }
        if (lastIndex == -1)
            return result;
        int startIndex = 0;
        int count = 0;
        for (int i=lastIndex;i>=0;i--) {
            count += a.charAt(i) == '0' ? 1 : -1;
            if (max == count && a.charAt(i) =='0') {
                startIndex = i;
            }
        }
        result.add(startIndex+1);
        result.add(lastIndex+1);
        return result;
    }
}
