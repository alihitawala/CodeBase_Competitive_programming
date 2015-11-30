package Coding.LeetCode;

import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 11/14/15.
 */
public class IsNumber {
    public static void main(String[] args) {
        System.out.println(new IsNumber().isNumber("0.."));
    }
    public boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty())
            return false;
        s = s.trim();
        if (s.endsWith("e"))
            return false;
        String[] p = s.split("e");
        int plen = p.length;
        if (plen > 2)
            return false;
        if (plen==1) {
            return checkNumberWithDecimal(p[0]);
        }
        else if (plen == 2) {
            return checkNumberWithDecimal(p[0]) && checkNumber(p[1]);
        }
        return false;
    }
    private boolean checkNumberWithDecimal(String s) {
        if (s == null || s.isEmpty())
            return false;
        StringTokenizer tokenizer = new StringTokenizer(".");
        tokenizer.countTokens();
        String[] p = s.split("\\.");
        int plen = p.length;
        if (plen > 2)
            return false;
        if (plen==1) {
            return checkNumber(p[0]);
        }
        else if (plen ==2){
            return checkNumber(p[0]) && checkNumber(p[1]);
        }
        return false;
    }
    private boolean checkNumber(String s) {
        if (s == null || s.isEmpty())
            return false;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }
}
