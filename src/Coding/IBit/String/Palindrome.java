package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class Palindrome {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String n = reader.readLine();
            System.out.println((new Palindrome().isPalin(n)));
        }
    }

    private int isPalin(String s) {
        int start = 0;
        int n = s.length();
        int end = n-1;
        while (true) {
            Character a = s.charAt(start), b = s.charAt(end);
            while ((a < 'a' || a > 'z') && (a< 'A' || a>'Z') && (a<'0' || a > '9')) {
                start++;
                if (start >= n) break;
                a = s.charAt(start);
            }
            while ((b < 'a' || b > 'z') && (b< 'A' || b>'Z')&& (b<'0' || b> '9')) {
                end--;
                if (end < 0) break;
                b = s.charAt(end);
            }
            if (start > end || (start == end && (a.toString().toUpperCase().equals(b.toString().toUpperCase())))) return 1;
            if (!a.toString().toUpperCase().equals(b.toString().toUpperCase())) break;
            start++;end--;
        }
        return 0;
    }
}
