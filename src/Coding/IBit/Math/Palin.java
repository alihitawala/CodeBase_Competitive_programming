package Coding.IBit.Math;

import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class Palin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println((isPalin(n)));
        }
    }

    private static int isPalin(int n) {
        String s=String.valueOf(n);
        for(int i=0,j=s.length()-1;i<j;i++,j--) {
            if (s.charAt(i) != s.charAt(j))
                return 0;
        }
        return 1;
    }
}
