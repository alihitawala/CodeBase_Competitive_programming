package Coding.IBit.Hashing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Fraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int deno = in.nextInt();
            System.out.println(solution(num, deno));
        }
    }

    private static String solution(int numerator, int denominator) {
        long n = numerator, d = denominator;
        // zero numerator
        if (n == 0) return "0";

        StringBuilder res = new StringBuilder("");
        // determine the sign
        if (n < 0 ^ d < 0) res.append('-');

        // remove sign of operands
        n = Math.abs(n); d = Math.abs(d);

        // append integral part
        res.append(String.valueOf((n / d)));

        // in case no fractional part
        if (n % d == 0) return res.toString();

        res.append('.');

        HashMap<Integer, Integer> map = new HashMap<>();

        // simulate the division process
        for (long r = n % d; r!=0; r %= d) {

            // meet a known remainder
            // so we reach the end of the repeating part
            if (map.containsKey((int)r)) {
                // insert '(' at the start position where we first saw the remainder
                res.insert(map.get((int)r), "(");
                res.append(')');
                break;
            }

            // the remainder is first seen
            // remember the current position for it
            map.put((int)r, res.length());

            r *= 10;

            // append the quotient digit
            res.append((char)('0' + (r / d)));
        }

        return res.toString();
    }

//    private static String getSecondPart(String s) {
//        String[] split = s.split("\\.");
//        s = split[1];
//        int p1 = 0;
//        int p2 = 1;
//        String secondPart = "";
//        if (s.length() == 100) {
//            while (true) {
//                while (p2 < s.length()) {
//                    if (s.charAt(p1) == s.charAt(p2)) {
//                        break;
//                    } else {
//                        p2++;
//                    }
//                }
//                String temp = s.substring(0, p2);
//                String stemp = s.substring(p2, 2 * p2);
//                if (temp.equals(stemp)) {
//                    secondPart = temp;
//                    break;
//                } else if (p2 >= s.length())
//                    break;
//            }
//            s = split[0] + '.' + "(" + secondPart + ")";
//        }
//        else
//            s = split[0] + '.' + split[1];
//        return s;
//    }
}
