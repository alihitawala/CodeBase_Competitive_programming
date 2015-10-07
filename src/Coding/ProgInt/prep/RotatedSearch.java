package Coding.ProgInt.prep;

/**
 * Created by aliHitawala on 10/1/15.
 */
public class RotatedSearch {
    public static int search(int[]a , int b) {
        int len = a.length;
        int low = 0;
        int high = len-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == b)
                return mid;
            if (b > a[mid]) {
                if (b <= a[high] || a[mid] > a[high])
                    low = mid+1;
                else
                    high = mid -1;
            }
            else {
                if (b >= a[low] || a[mid] < a[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
