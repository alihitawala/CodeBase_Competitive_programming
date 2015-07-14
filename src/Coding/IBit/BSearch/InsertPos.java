package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/5/15.
 */
public class InsertPos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j=0;j<n;j++) {
                int temp = in.nextInt();
                a.add(temp);
            }
            int num = in.nextInt();
            System.out.println(insertLocation(a, num));
        }
    }

    private static int insertLocation(ArrayList<Integer> a, int num) {
        int n = a.size();
        int low = 0;
        int high = n-1;
        if (num < a.get(low)) return low;
        if (num > a.get(high)) return n;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int midValue=a.get(mid);
            if (midValue == num) return mid;
            if (midValue>num && (mid == 0 || a.get(mid-1) < num)) return mid;
            if (midValue > num) high=mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
