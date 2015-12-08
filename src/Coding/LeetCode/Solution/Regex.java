package Coding.LeetCode.Solution;

/**
 * Created by aliHitawala on 11/18/15.
 */
public class Regex {
    public int isMatch(final String s, final String p) {
        return solve(s,p,0,0) ? 1 : 0;
    }

    private static boolean solve(String s, String p, int sIndex, int pIndex) {
        if (pIndex >= p.length())
            return sIndex == s.length();
        if ((pIndex < p.length() -1 && p.charAt(pIndex+1) != '*') || pIndex ==p.length()-1) {
            return (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && s.length() != sIndex))
                    && solve(s,p, sIndex+1, pIndex +1);
        }
        while (s.length() != sIndex && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.')) {
            if (solve(s, p, sIndex, pIndex + 2)) return true;
            sIndex++;
        }
        return solve(s, p, sIndex, pIndex+2);
    }
}
