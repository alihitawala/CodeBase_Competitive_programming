package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/6/15.
 */
public class SQRT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            System.out.println(sqrt(x));
        }
    }

    private static int sqrt(int x) {
        long low = 0;
        long high = x/2+1;
        while (low<=high) {
            long mid = low + (high-low)/2;
            long sq = mid *mid;
            if (sq == x) return (int)mid;
            long sq1 = (mid+1)*(mid+1);
            if (sq < x && sq1 > x) return (int)mid;
            if (sq > x) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
