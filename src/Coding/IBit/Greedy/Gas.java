package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
    public class Gas {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int i=0;i<t;i++) {
                int n = in.nextInt();
                List<Integer> A = new ArrayList<Integer>();
                List<Integer> B = new ArrayList<Integer>();
                for(int j=0;j<n;j++){
                    int a = in.nextInt();
                    A.add(a);
                    int b = in.nextInt();
                    B.add(b);
                }
                System.out.println(new Gas().canCompleteCircuit(A, B));
            }
        }

    private int canCompleteCircuit(List<Integer> gas, List<Integer> cost) {
        int len = gas.size();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = gas.get(i) - cost.get(i);
        }
        int start = max_sum(a);
        if (start == -1)
            return -1;
        int sum = 0;
        for (int i = start;; ) {
            sum = sum +a[i];
            if (sum < 0)
                return -1;
            i=(i+1)%len;
            if (i == start)
                return start;
        }
    }

    private int max_sum(int[] a) {
        int startTemp = 0, start = -1;
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp + a[i] < 0){
                temp =0;
                startTemp=i+1;
                continue;
            }
            else if (temp + a[i] > max) {
                start = startTemp;
                max = temp + a[i];
            }
            temp = temp + a[i];
        }
        return start;
    }
}
