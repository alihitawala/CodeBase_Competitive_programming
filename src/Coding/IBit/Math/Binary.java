package Coding.IBit.Math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/2/15.
 */
public class Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(binary(n));
    }

    private static String binary(int n) {
        StringBuilder result = new StringBuilder("");
        while (n != 0) {
            if (n%2 == 0) {
                result.append("0");
            }
            else {
                result.append("1");
            }
            n/=2;
        }
        return result.reverse().toString();
    }
}
