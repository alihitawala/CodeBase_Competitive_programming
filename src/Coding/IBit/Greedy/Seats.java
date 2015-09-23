package Coding.IBit.Greedy;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class Seats {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            System.out.println(new Seats().seats(a));
        }
    }

    private static final int MOD = 10000003;
    public int seats(String a) {
        int result = 0;
        int numCross = 0;
        for (int i = 0; i < a.length(); i++) 
            if (a.charAt(i) == 'x')
                numCross++;
        int left = 0;
        int right = numCross;
        int j=0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'x') {
                left++;
                right--;
            }
            else if (a.charAt(i) == '.') {
                if (left > right)
                    result= (result+right)%MOD;
                else
                    result = (result + left) %MOD;
            }
        }
        return result;
    }
}
