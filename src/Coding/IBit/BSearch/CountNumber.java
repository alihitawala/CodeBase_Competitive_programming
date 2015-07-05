package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/5/15.
 */
public class CountNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int m = in.nextInt();
        System.out.println(count(a, m));
    }

    private static int count(ArrayList<Integer> a, int n) {
        int start = _b_search_min(a, n);
        int end = start == -1 ? -1 : _b_search_max(a, n);
        if (end == -1) return 0;
        return end-start+1;
    }

    private static int _b_search_max(ArrayList<Integer> a, int n) {
        int low = 0;
        int high = a.size()-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int midValue = a.get(mid);
            if (midValue == n && (mid == a.size()-1 || a.get(mid+1) > midValue)) return mid;
            else if (midValue > n) high = mid-1;
            else low=mid+1;
        }
        return -1;
    }

    private static int _b_search_min(ArrayList<Integer> a, int n) {
        int low = 0;
        int high = a.size()-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int midValue = a.get(mid);
            if (midValue == n && (mid == 0 || a.get(mid-1) < midValue)) return mid;
            else if (midValue < n) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
