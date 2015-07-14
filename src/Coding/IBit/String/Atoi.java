package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/13/15.
 */
public class Atoi {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = reader.readLine();
            System.out.println(atoi(x));
        }
    }

    private static int atoi(String x) {
        String s = x.trim();
        if (s.length() == 0) return 0;
        char c = s.charAt(0);
        int sign = 1,i=0;
        if (c == '-') {
            sign=-1;
            i++;
        }
        else if (c == '+') {
            sign=1;
            i++;
        }
        int num=0;
        for (;i<s.length();i++) {
            char p = s.charAt(i);
            if (isNumber(p))
            {
                int temp = num*10+number(p);
                if (temp/10 != num)
                    return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                num = temp;
            }
            else break;
        }
        return num*sign;
    }

    private static int number(char c) {
        return c-'0';
    }

    private static boolean isNumber(char c) {
        return c>='0' && c<='9';
    }
}
