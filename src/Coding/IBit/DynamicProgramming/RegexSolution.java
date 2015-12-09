package Coding.IBit.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by aliHitawala on 10/27/15.
 */
public class RegexSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        System.out.println(new RegexSolution().isMatch(s,p));
    }

    public int isMatch(final String s, final String p) {
        return _isMatch(s.toCharArray(),p.toCharArray(),0,0) ? 1 : 0;
    }
    public boolean _isMatch(char[] s, char[] p, int i, int j) {
        if (j >= p.length)
            return i == s.length;
        //next char is not *
        if (j == p.length-1 || (j<p.length-1 && p[j+1] != '*')) {
            return _isMatch(s,p,i+1,j+1) && (s[i] == p[j] || (p[j] == '.' && i < s.length));
        }
        //next char is *
        while (i < s.length && (s[i] == p[j] || p[j] == '.')) {
            if (_isMatch(s, p, i, j+2)) return true;
            i++;
        }
        return _isMatch(s, p, i, j+2);
    }

    public int isMatchDP(final String s, final String p) {
        boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
        d[0][0] = true;
        for (int i = 0; i < p.length(); ++i) {
            char current = p.charAt(i);
            if (current == '*') {
                for (int j = 0; j < s.length(); ++j) {
                    d[j + 1][i + 1] = d[j + 1][i - 1];
                }
                for (int j = 0; j < s.length(); ++j) {
                    if ((p.charAt(i - 1) == '.') || (p.charAt(i - 1) == s.charAt(j))) {
                        d[j + 1][i + 1] = d[j + 1][i + 1] || d[j][i - 1] || d[j][i + 1];
                    }
                }
            } else if (current == '.') {
                for (int j = s.length() - 1; j >= 0; --j) {
                    d[j + 1][i + 1] = d[j][i];
                }
            } else {
                for (int j = 0; j < s.length(); ++j) {
                    if (s.charAt(j) == p.charAt(i)) {
                        d[j + 1][i + 1] = d[j][i];
                    }
                }
            }
        }
        return d[s.length()][p.length()] ? 1 : 0;
    }
}
