package Coding.IBit.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/17/15.
 */
public class Regex_v2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        System.out.println(new Regex_v2().isMatch(s,p));
    }
    public int isMatch(final String s, final String p) {
        String x = p;
        while(x.contains("**")) {
            x = x.replaceAll("\\*\\*", "\\*");
        }
        boolean t = _isMatch(s, x);
        return t ? 1 : 0;
    }
    public boolean _isMatch(String s, String p) {

        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] result = new boolean[n][m];

        result[0][0] = true;
        for( int i = 1; i < n; i++){
            result[i][0] = p.charAt(i - 1) == '*' && result[i - 2][0];
        }
        for( int j = 1; j < m; j++){
            result[0][j] = s.charAt(j - 1) == '*' && result[0][j - 2];
        }
        for( int i = 1; i < n; i++ ){
            for( int j = 1; j < m; j++ ){
                if(p.charAt(i-1) == '*')
                    result[i][j] = match(s.charAt(j-1),p.charAt(i-2)) ? (result[i][j-1]||result[i-2][j]) : result[i-2][j];
                else
                    result[i][j] = match(s.charAt(j - 1), p.charAt(i - 1)) && result[i - 1][j - 1];
            }
        }
        return result[n-1][m-1];
    }

    boolean match(char a, char b){
        if(a == '.' || b == '.')
            return true;
        else
            return a == b;
    }
}
