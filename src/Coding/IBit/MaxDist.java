package Coding.IBit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by aliHitawala on 6/28/15.
 */
public class MaxDist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            List<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println(new MaxDist().maximumGap(A));
        }
    }

    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int [] min_a = new int[n];min_a[0] = A.get(0);
        int [] max_a = new int[n];max_a[n-1] = A.get(n-1);
        for (int i=1;i<n;i++)
            min_a[i] = Math.min(min_a[i-1], A.get(i));
        for (int i=n-2;i>=0;i--)
            max_a[i] = Math.max(max_a[i+1], A.get(i));
        int minIndex = 0, maxIndex = 0, maxDifference = 0;
        while (minIndex<n && maxIndex<n) {
            if (min_a[minIndex] <= max_a[maxIndex]) {
                if (maxDifference < maxIndex-minIndex)
                    maxDifference = maxIndex-minIndex;
                maxIndex++;
            }
            else minIndex++;
        }
        return maxDifference;
    }

    private static void printArray(ArrayList<Integer> solve) {
        for (int i :solve) {
            System.out.print(i + " " );
        }
    }
}
