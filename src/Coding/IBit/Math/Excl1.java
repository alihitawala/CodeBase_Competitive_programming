package Coding.IBit.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class Excl1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int s = in.nextInt();
            System.out.println((numberTitle(s)));
        }
    }

    private static String numberTitle(int s) {
        char c = s%26 == 0 ? 'Z' : (char) ((s%26) + 'A' -1);
        if ((s/26) == 0 || s == 26) {
            return c+"";
        }
        if (s%26 !=0)
            return numberTitle((s/26)) + c;
        else
            return numberTitle((s/26)-1) + c;
    }

    private static int number(String s) {
        int value = s.charAt(0) - 'A' +1;
        if (s.length() == 1) {
            return value;
        }
        else {
            return ((int)Math.pow(26, s.length()-1)) * value + number(s.substring(1));
        }
    }
}
