package Coding.RG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/22/15.
 */
public class SumPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        ArrayList<Integer> partition = partition(a);
        if (partition != null)
            printArray(partition);
    }

    private static ArrayList<Integer> partition2(ArrayList<Integer> a) {
        long sum = getSum(a);
        if (sum % 2 != 0)
            return null;
        long sumHalf = sum/2;
        Collections.sort(a);

        return null;
    }

    private static ArrayList<Integer> partition(ArrayList<Integer> a) {
        long sum = getSum(a);
        if (sum % 2 != 0)
            return null;
        long sumHalf = sum/2;
        boolean[] bool = new boolean[(int)sumHalf + 1];
        int[] s = new int[(int)sumHalf + 1];
        for (int i=0;i<=sumHalf;i++)
            s[i] = -1;
        for (int i=0;i<a.size();i++) {
            for (int j=1;j<=sumHalf;j++) {
                if (bool[j] && j+a.get(i) <=sumHalf
                        && !bool[j+a.get(i)] && (j<a.get(i) || s[j-a.get(i)] != i)) {
                    s[j+a.get(i)] = i;
                    bool[j+a.get(i)] = true;
                }
            }
            if (a.get(i) <= sumHalf && !bool[a.get(i)])
            {
                s[a.get(i)] = i;
                bool[a.get(i)] = true;
            }
        }
        if (bool[(int)sumHalf]) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            int x = (int)sumHalf;
            while (s[x] !=-1) {
                result.add(a.get(s[x]));
                x -= a.get(s[x]);
            }
            return result;
        }
        return null;
    }

    private static long getSum(ArrayList<Integer> a) {
        long result = 0;
        for (int i : a) {
            result+=i;
        }
        return result;
    }


    private static void printArray(ArrayList<Integer> solve) {
        for (int j : solve)
            System.out.print(j + " " );
        System.out.println();
    }
}
