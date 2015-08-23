package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class MaxOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int num = in.nextInt();
        System.out.println(maxone(a, num));
    }
    public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int window = 0;
        int start = 0, rangeStart=0, rangeEnd=-1;
        int maxGap = 0;
        int switches = b;
        for (int i=0;i<a.size();i++) {
            int x = a.get(i);
            if (x == 1)
                window++;
            else { // 0
                if (switches != 0) {
                    switches--;
                    window++;
                }
                else {
                    if (a.get(start) == 1) {
                        while (start < a.size() && a.get(start) != 0) {
                            start++;
                            window--;
                        }
                        start++;
                        window--;
                        window++;
                    }
                    else {
                        start++;
                        window--;
                        window++;
                    }
                }
            }
            if (window >maxGap) {
                maxGap = window;
                rangeEnd = i;
                rangeStart = start;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=rangeStart;i<=rangeEnd;i++)
            answer.add(i);
        return answer;
    }
}
