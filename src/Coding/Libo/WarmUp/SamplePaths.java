package Coding.Libo.WarmUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class SamplePaths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t , pathLength;
        pathLength = in.nextInt();
        t = in.nextInt();
        int path[] = new int[pathLength];
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> twos = new ArrayList<Integer>();
        for (int i=0;i<pathLength;i++) {
            path[i] = in.nextInt();
            if (path[i]==1) ones.add(i);
            if (path[i]==2) twos.add(i);
        }
        for (int i=0;i<t;i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (bSearch(ones, start, end) != -1)
                System.out.println(1);
            else if (bSearch(twos, start, end) != -1)
                System.out.println(2);
            else
                System.out.println(3);
        }
    }

    private static int bSearch(List<Integer> list, int start, int end) {
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = list.get(mid);
            if (start <= midValue && midValue <= end)
                return mid;
            else if (end < midValue)
                high = mid-1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
