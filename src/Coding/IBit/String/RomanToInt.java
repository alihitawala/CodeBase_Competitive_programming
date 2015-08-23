package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class RomanToInt {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = reader.readLine();
            System.out.println(romanToInt(x));
        }
    }

    private static int romanToInt(String s) {
        int number = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (i != s.length()-1) {
                char d = s.charAt(i + 1);
                if (RomanNumber.getPriority(c, d) < 0) {
                    number += (RomanNumber.getValue(d) - RomanNumber.getValue(c));
                    i++;
                }
                else {
                    number += RomanNumber.getValue(c);
                }
            }
            else {
                number += RomanNumber.getValue(c);
            }
        }
        return number;
    }

    static class RomanNumber {
        static Integer getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            throw new RuntimeException("Not Supported");
        }

        static int getPriority(char a, char b) {
            return getValue(a).compareTo(getValue(b));
        }
    }
}
