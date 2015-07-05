package Coding.IBit.Array;

/**
 * Created by aliHitawala on 6/28/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class IntervalMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Interval> A = new ArrayList<Interval>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                int b = in.nextInt();
                A.add(new Interval(a,b));
            }
            int a = in.nextInt();
            int b = in.nextInt();
            printArray(new IntervalMain().insert(A, new Interval(a,b)));
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        boolean isOverLap = false;
        for (int i=0;i<intervals.size();i++)
        {
            Interval temp = intervals.get(i);
            if (Math.max(start, temp.start) <= Math.min(end, temp.end)) {
                temp.start = Math.min(start, temp.start);
                temp.end = Math.max(end, temp.end);
                isOverLap = true;
            }
        }
        if (!isOverLap) {
            boolean inserted = false;
            for (int i=0;i<intervals.size();i++) {
                Interval t = intervals.get(i);
                if (start<t.start && end < t.start) {
                    intervals.add(i, newInterval);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                intervals.add(intervals.size(), newInterval);
            }
        }
        else {
            for (int i=0;i<intervals.size()-1;i++) {
                Interval first = intervals.get(i);
                Interval next = intervals.get(i+1);
                if (first.end >= next.start) {
                    next.start = Math.min(first.start, next.start);
                    next.end = Math.max(first.end, next.end);
                    first.start = 0;
                    first.end = 0;
                }

            }
            ArrayList<Interval> newResult = new ArrayList<Interval>();
            for (Interval first : intervals) {
                if (first.start > 0 && first.end > 0)
                    newResult.add(first);
            }
            intervals=newResult;
        }
        return intervals;
    }

    private static void printArray(ArrayList<Interval> solve) {
        for (Interval i :solve) {
            System.out.println(i.start + " " + i.end );
        }
    }
}
