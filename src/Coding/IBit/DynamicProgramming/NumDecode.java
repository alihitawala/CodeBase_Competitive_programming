package Coding.IBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/12/15.
 */
public class NumDecode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            String s = in.next();
            System.out.println(new NumDecode().numDecodings(s));
        }
    }

    private static Map<Integer, Integer> decodes;
    public int numDecodings(String a) {
        int[] cache = new int[a.length()];
        cache[0] = getDecoding(a.charAt(0)-'0');
        if (cache[0] == 0)
            return 0;
        for (int i = 1; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c != '0') {
                cache[i] = cache[i-1];
                if (a.charAt(i-1) != '0') {
                    int num = (a.charAt(i - 1)-'0') * 10 + (a.charAt(i) - '0');
                    if (i < 2)
                        cache[i] += getDecoding(num);
                    else {
                        cache[i] += getDecoding(num)*cache[i-2];
                    }
                }
            }
            else {
                if (a.charAt(i-1) != '1' && a.charAt(i-1) != '2')
                    return 0;
                if (i < 2)
                    cache[i] = 1;
                else {
                    cache[i] = cache[i-2];
                }
            }
        }
        return cache[a.length()-1];
    }

    private int getDecoding(int i) {
//        int i = c-'0';
        if (i > 26 || i < 1)
            return 0;
        return 1;
    }
}
