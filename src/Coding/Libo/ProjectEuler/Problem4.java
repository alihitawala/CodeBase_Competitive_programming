package Coding.Libo.ProjectEuler;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by aliHitawala on 6/8/15.
 */
public class Problem4 {
    private static Set<Long> sortedSet = new TreeSet<Long>();
    private static Long[] cache;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initPalins();
        cache = sortedSet.toArray(new Long[sortedSet.size()]);
        long n = in.nextLong();
        for (long i=0;i<n;i++) {
            long num = in.nextLong();
            long answer = bSearchImmediateSmallest(num);
            System.out.println(answer);
        }
    }

    private static long bSearchImmediateSmallest(long num) {
        return _bSearchImmediateSmallest(num, 0, cache.length-1);
    }

    private static long _bSearchImmediateSmallest(long n, int low, int high) {
        while(low<=high) {
            int mid = (low+high)/2;
            if (cache[mid] <=n && (mid == high || cache[mid+1] > n)) return cache[mid];
            else if (cache[mid] < n) low = mid +1;
            else high = mid-1;
        }
        return -1;
    }

    private static void initPalins() {
        for (int i=100;i<1000;i++) {
            for (int j=i;j<1000;j++) {
                long m = i*j;
                if (isPalin(m)) {
                    sortedSet.add(m);
                }
            }
        }
    }

    private static boolean isPalin(long m) {
        String s = m+"";
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        String reverse = stringBuilder.toString();
        return s.equals(reverse);
    }
}
