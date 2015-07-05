package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/5/15.
 */
public class Search2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for (int j=0;j<n;j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int k=0;k<m;k++) {
                    temp.add(in.nextInt());
                }
                a.add(temp);
            }
            int num = in.nextInt();
            System.out.println(search(a, num));
        }

    }

    private static int search(ArrayList<ArrayList<Integer>> a, int num) {
//        int n = a.size();
//        int m = a.get(0).size();
//        ArrayList<Integer> w = new ArrayList<Integer>();
//        for (ArrayList<Integer> d : a) {
//            w.add(d.get(m-1));
//        }
//        int x = b_search(w, num);
//        int y = x==-1 ? -1 : b_search(a.get(x), num);
//        return y==-1 ? 0 : (a.get(x).get(y) == num ? 1:0);
        return b_search_2D(a, num);
    }

    private static int b_search(ArrayList<Integer> a, int num) {
        int n = a.size();
        int low = 0;
        int high = n-1;
        if (num < low) return low;
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

    private static int b_search_2D(ArrayList<ArrayList<Integer>> a, int num) {
        int n = a.size();
        int m = a.get(0).size();
        int low = 0;
        int high = m*n - 1;
        if (num < low) return 0;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int midValue=a.get(mid/m).get(mid%m);
            if (midValue == num) return 1;
            if (midValue > num) high=mid-1;
            else low = mid+1;
        }
        return 0;
    }

}
