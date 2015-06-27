package Coding.Libo.ProjectEuler;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/9/15.
 */
public class Problem8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            int length = in.nextInt();
            int window = in.nextInt();
            String num = in.next();
            long answer = getProduct(num, window);
            System.out.println(answer);
        }
    }

    private static long getProduct(String s, int window) {
        if (window < 1) return 0;
        long max = 0, tempMax =1;
        for (int i=0,j=0;j<s.length() && i <s.length();) {
            int digit = Integer.parseInt(s.charAt(j) + "");
            if (digit ==0) {i=j+1;j++;tempMax=1;}
            else {
                tempMax*=digit;
                if (j-i+1 == window) {
                    if (tempMax > max) max = tempMax;
                    int removeDigit = Integer.parseInt(s.charAt(i)+ "");
                    tempMax /=removeDigit;
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
