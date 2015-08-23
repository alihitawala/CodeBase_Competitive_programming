package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class StrstrKMP {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = in.next();
            String y = in.next();
            System.out.println(strStr(x,y));
        }
    }

    public static int strStr(final String s, final String sub) {
        int n = s.length();
        int m = sub.length();
        int[] prefix = prefixFunction(sub);
        int q=0;
        for (int i = 0; i < n; i++) {
            while (q>0 && sub.charAt(q) != s.charAt(i))
                q=prefix[q-1];
            if (sub.charAt(q) == s.charAt(i))
                q++;
            if(q==m)
                return (i-m+1);
        }
        return -1;
    }

    private static int[] prefixFunction(String p) {
        int m = p.length();
        int[] a = new int[m];
        a[0] = 0;
        int k=0;
        for (int q=1;q<m;q++) {
            while (k>0 && p.charAt(k) != p.charAt(q)) {
                k = a[k-1];
            }
            if (p.charAt(k) == p.charAt(q))
                k++;
            a[q]=k;
        }
        return a;
    }
}
