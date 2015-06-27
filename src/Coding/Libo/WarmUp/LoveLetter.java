package Coding.Libo.WarmUp;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class LoveLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t ;
        t = in.nextInt();
        String s[] = new String[t];
        for (int i=0;i<t;i++) {
            s[i] = in.next();
        }
        for (int i=0;i<t;i++) {
            int start = 0, end=s[i].length()-1;
            int count =0;
            while (start<end) {
                int x = s[i].charAt(start) - 'a';
                int y = s[i].charAt(end) - 'a';
                count += Math.abs(x-y);
                start++;end--;
            }
            System.out.println(count);
        }
    }
}
