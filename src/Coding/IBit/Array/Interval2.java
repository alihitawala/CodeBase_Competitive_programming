package Coding.IBit.Array;

/**
 * Created by aliHitawala on 6/28/15.
 */

import java.util.*;


public class Interval2 {
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
            printArray(new Interval2().insert(A));
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals) {
        LinkedList<Integer> startList = new LinkedList<Integer>();
        LinkedList<Integer> endList = new LinkedList<Integer>();
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (Interval temp : intervals) {
            startList.add(temp.start);
            endList.add(temp.end);
        }
        Collections.sort(startList);
        Collections.sort(endList);
        while (!endList.isEmpty() && !startList.isEmpty()) {
            int start = startList.removeFirst();
            while ((!endList.isEmpty() && !startList.isEmpty())
                    && (endList.peekFirst() >= startList.peekFirst())) {
                endList.removeFirst();
                startList.removeFirst();
            }
            result.add(new Interval(start, endList.removeFirst()));
        }
        return result;
    }

    private static void printArray(ArrayList<Interval> solve) {
        for (Interval i :solve) {
            System.out.println(i.start + " " + i.end );
        }
    }
}
