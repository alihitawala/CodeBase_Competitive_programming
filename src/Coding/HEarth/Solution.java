package Coding.HEarth;
import java.io.*;
import java.util.*;
/**
 * Created by aliHitawala on 10/11/15.
 */
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        long[] temp = new long[n];
        for (int i=0;i<n;i++)
            temp[i] = i;
        getNthPermutations(temp, n, m+1);
        for (long l : temp)
            System.out.print(l + " ");
    }

    public static void getNthPermutations(long[] t, int n, int m) {
        int length = n;
        boolean isFinished = false;
        while (!isFinished) {
            m--;
            int i;
            for ( i = length - 2; i >= 0; --i )
                if (t[i] < t[i+1])
                    break;
            if (m==0|| i == -1 )
                isFinished = true;
            else {
                int ceilIndex = findCeil(t, t[i], i + 1, length - 1 );
                swap(t, i, ceilIndex);
                reverse(t, i + 1, length - 1);
            }
        }
    }
    private static void reverse (long[] t, int i, int j) {
        while (i < j)
        {
            swap(t, i, j);
            i++;
            j--;
        }
    }
    private static int findCeil (long t[], long first, int l, int h)
    {
        int ceilIndex = l;
        for (int i = l+1; i <= h; i++)
            if (t[i] > first && t[i] < t[ceilIndex])
                ceilIndex = i;
        return ceilIndex;
    }
    private static void swap(long[] t, int i, int j) {
        long temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
