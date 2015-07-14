package Coding.IBit.String;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/10/15.
 */
public class ValidNumber {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String n = in.next();
            System.out.println(new ValidNumber().getSolution(n));
        }
    }

    private int getSolution(String n) {
        String s = n.trim();
        boolean result = true;
        int start = 0;
        boolean eOccurred = false;
        char specialChar = 'a';
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (eOccurred && (c=='e' || c=='.')) return 0;
            if(c == 'e' || c == '.') {
                String t = (c == '.' && i==0) ? "0" : s.substring(start, i);
                result = isValidNumber(t, specialChar);
                if (!result) break;
                start=i+1;
                eOccurred = c=='e';
                specialChar = c;
            }
        }
        if (start == s.length()) result=false;
        else {
            result = isValidNumber(s.substring(start, s.length()),specialChar);
        }
        return result ? 1: 0;
    }

    private boolean isValidChar(char c) {
        return (c>='0' && c<='9');
    }

    private boolean isValidNumber(String s, char c) {
        if (s.length() == 0) return false;
        if ((s.length() == 1 || c == '.') && s.charAt(0) == '-') return false;
        int i=0;
        if (s.charAt(0) == '-') i++;
        for (;i<s.length();i++) {
            if (!isValidChar(s.charAt(i)))
                return false;
            }
        return true;
    }
}
