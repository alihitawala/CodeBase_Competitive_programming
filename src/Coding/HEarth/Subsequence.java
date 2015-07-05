package Coding.HEarth;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class Subsequence {
    private static long total = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        new Subsequence().solution(s, 0, "", 0);
        System.out.println(total);
    }

    private void solution(String s, long sum, String included, int index) {
        if (index == s.length()) {
            System.out.println(included);
            if (sum % 3 == 0 && included.length() !=0
                    && Integer.parseInt(included.charAt(included.length()-1) + "") %2 ==0) {
                total++;
            }
            return;
        }
        int temp = Integer.parseInt(s.charAt(index)+"");
        solution(s, sum+temp, included+temp, index+1);
        solution(s, sum, included, index+1);
    }

}
