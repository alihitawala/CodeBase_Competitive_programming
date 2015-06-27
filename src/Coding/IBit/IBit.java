package Coding.IBit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/23/15.
 */
public class IBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int x =in.nextInt();
                a.add(x);
            }
            ArrayList<Integer> contiguousMax = getMaxSumContiguous(a);
            for (long k : contiguousMax) {
                System.out.println(k);
            }
        }
    }

    private static ArrayList<Integer> getMaxSumContiguous(ArrayList<Integer> a) {
        long max = Integer.MIN_VALUE;
        long tempMax=0;
        long tempStart=0, start=0;
        long tempEnd=0, end=-1;
        for (int j=0;j<a.size();j++) {
            long i = a.get(j);
            if (i>=0){
                tempMax += i;
                tempEnd = j;
                if (tempMax > max) {
                    max = tempMax;
                    start = tempStart;
                    end = tempEnd;
                }
                else if (tempMax == max) {
                    if (tempEnd - tempStart > end - start ||
                            (tempEnd - tempStart == end - start
                                    && a.get((int) tempStart) < a.get((int)start) ))
                    {
                        max = tempMax;
                        start = tempStart;
                        end = tempEnd;
                    }
                }
            }
            if (i<0) {
                tempMax = 0;
                tempStart = j+1;
            }
        }

        long length = end - start +1;
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i=0;i<length;i++) {
            int x = a.get((int)start+i);
            b.add(x);
        }
        return b;
    }
}
