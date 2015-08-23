package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class LongestPalindrome {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = in.next();
            System.out.println(longestPalindrome(x));
        }
    }
    public static String longestPalindrome(String a) {
        String s1 = oddPalin(a);
        String s2 = evenPalin(a);
        return s1.length()>s2.length() ? s1 : s2;
    }

    private static String evenPalin(String a) {
        int n=a.length();
        int max=0;
        String result = "";
        for (int i=0;i<n-1;i++) {
            int p=i,q=i+1;
            int count=0;
            while(p>=0 && q<n && a.charAt(p)==a.charAt(q)) {
                count++;
                p--;
                q++;
            }
            if (count>max) {
                max = count;
                result = a.substring(p+1,q);
            }
        }
        return result;
    }

    private static String oddPalin(String a) {
        int n = a.length();
        int max=0;
        String result = "";
        for (int i=0;i<n;i++) {
            int p=i,q=i;
            int count=0;
            while(p>=0 && q<n && a.charAt(p)==a.charAt(q)) {
                count++;
                p--;
                q++;
            }
            if (count>max) {
                max = count;
                result = a.substring(p+1,q);
            }
        }
        return result;
    }
}
