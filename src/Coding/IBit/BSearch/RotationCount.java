package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/5/15.
 */
public class RotationCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(count(a));
    }

    private static int count(ArrayList<Integer> a) {
        int low=0;
        int high = a.size()-1;
        int length = a.size();
        while (low <= high) {
            int mid = low + (high-low)/2;
            int lowValue = a.get(low);
            int highValue = a.get(high);
            if (lowValue <= highValue) return lowValue;
            int next = a.get((mid+1)%length);
            int prev = a.get((mid+length-1)%length);
            int midValue = a.get(mid);
            if (next >=midValue && prev >= midValue) return midValue;
            if (lowValue <=midValue) low = mid+1;
            else if (midValue <= highValue) high = mid-1;
        }
        return -1;
    }
}
