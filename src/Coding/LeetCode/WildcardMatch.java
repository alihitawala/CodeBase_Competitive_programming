package Coding.LeetCode;

/**
 * Created by aliHitawala on 11/18/15.
 */
public class WildcardMatch {
    public boolean match(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int i=0;
        int j=0;
        int starIndex = -1;
        int iIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            }
            else if (starIndex != -1) {
                j = starIndex +1;
                i = iIndex + 1;
                iIndex++;
            }
            else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*')
            j++;
        return j == p.length();
    }
}
