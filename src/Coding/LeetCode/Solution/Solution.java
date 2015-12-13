package Coding.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aliHitawala on 11/10/15.
 */
public class Solution {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,4));
        list.add(new Interval(5,6));
        list.add(new Interval(7,8));
        list.add(new Interval(9,10));
        System.out.println(new Solution().isConflict(list));
    }
public boolean isConflict(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
        return false;
        //O(nlogn)
        //bring func out for testability
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval prev = intervals.get(0);

        for (int i=1;i<intervals.size();i++) {
        //exception handling for negative inputs
        Interval curr= intervals.get(i);
        if (prev.end >= curr.start) {
        return true;
        }
        prev = curr;
        }
        return false;
        }
        }

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}