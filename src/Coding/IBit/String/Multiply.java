package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/14/15.
 */
public class Multiply {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = reader.readLine();
            String y = reader.readLine();
            System.out.println(multiply(x, y));
        }
    }

    private static String multiply(String x, String y) {
        if (x.length() > y.length()) {
            String t = x;
            x=y;
            y=t;
        }
        int z = Integer.parseInt(x);
        x = removeZero(x.trim());
        y = removeZero(y.trim());
        String temp = "0";
        while (!x.equals("0")) {
            temp = add(temp, y);
            x = decrement(x);
            x = removeZero(x);
        }
        return temp;
    }

    private static String add(String a, String b) {
        StringBuilder p = new StringBuilder(a).reverse();;
        StringBuilder q = new StringBuilder(b).reverse();
        StringBuilder r = new StringBuilder("");
        Integer carry = new Integer(0);
        int i=0;
        for (;i<p.length() && i<q.length();i++) {
            int n = add(p.charAt(i), q.charAt(i), carry);
            carry = n/10;
            r.append((char)((n%10)+'0'));
        }
        while(i<p.length()) {
            int n = add(p.charAt(i), '0', carry);
            carry = n/10;
            r.append((char)((n%10)+'0'));
            i++;
        }
        while(i<q.length()) {
            int n = add('0', q.charAt(i), carry);
            carry = n/10;
            r.append((char)((n%10)+'0'));
            i++;
        }
        if (carry > 0) {
            r.append((char)(carry+'0'));
        }
        return r.reverse().toString();
    }

    private static int add(char a, char b, Integer carry) {
        int i = add(a, b);
        return i+carry;
    }

    private static int add(char a, char b) {
        int i = a -'0';
        int j = b -'0';
        return i+j;
    }

    private static String decrement(String s) {
        StringBuilder sb= new StringBuilder(s).reverse();
        StringBuilder temp= new StringBuilder("");
        int i=0;
        for (;i<sb.length();i++) {
            if (sb.charAt(i)=='0') {
                temp.append('9');
            }
            else {
                temp.append(subtract(sb.charAt(i), 1));
                i++;
                break;
            }
        }
        while (i<sb.length()) {
            temp.append(sb.charAt(i++));
        }
        return temp.reverse().toString();
    }

    private static char subtract(char a, int b) {
        int t = (a - '0') - b;
        return (char)(t+'0');
    }

    private static String removeZero(String s) {
        int i=0;
        for (;i<s.length();i++) {
            if (s.charAt(i) != '0') break;
        }
        return i== s.length() ? "0" : s.substring(i);
    }
}
