package Coding.ACM_ICPC;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/9/15.
 */
public class RegexString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        System.out.println(solve(s,p, 0, 0));
    }

    private static boolean solve(String s, String p, int sIndex, int pIndex) {
        if (pIndex >= p.length())
            return sIndex == s.length();
        if ((pIndex < p.length() -1 && p.charAt(pIndex+1) != '*') || pIndex ==p.length()-1) {
            return (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && s.length() != sIndex))
                    && solve(s,p, sIndex+1, pIndex +1);
        }
        while (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && s.length() != sIndex)) {
            if (solve(s, p, sIndex, pIndex + 2)) return true;
            sIndex++;
        }
        return solve(s, p, sIndex, pIndex+2);
    }
}
