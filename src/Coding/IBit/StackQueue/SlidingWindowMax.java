package Coding.IBit.StackQueue;

import java.util.*;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class SlidingWindowMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int w = in.nextInt();
        System.out.println(slidingMaximum(a, w));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int w) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.size() < w){
            w = a.size();
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int i=0;
        for (;i<w;i++) {
            while (!dq.isEmpty() && a.get(i) >= a.get(dq.getLast())) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for (;i<a.size();i++) {
            result.add(a.get(dq.getFirst()));
            while (!dq.isEmpty() && dq.getFirst() <= (i-w)) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && a.get(i) >= a.get(dq.getLast())) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        result.add(a.get(dq.getFirst()));
        return result;
    }
}
