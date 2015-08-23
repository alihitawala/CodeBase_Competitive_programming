package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/22/15.
 */
public class SearchRotated {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int m = in.nextInt();
        System.out.println(search(a, m));
    }

    public static int search(final List<Integer> a, int b) {
        int n = a.size();
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int aLow = a.get(low);
            int aHigh = a.get(high);
            int aMid = a.get(mid);
            if (aMid == b)
                return mid;
            else if (b < aMid) {
                if (b >= aLow || aMid < aLow)
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {
                if (b <= aHigh || aMid > aHigh)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
