package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/20/15.
 */
public class ThreeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int num = in.nextInt();
        System.out.println(solution2(a, num));
    }

    private static int solution(ArrayList<Integer> a, int num) {
        int diff = Integer.MAX_VALUE;
        int answer = num;
        for (int i=0;i<a.size()-2;i++) {
            for (int j=i+1;j<a.size()-1;j++) {
                for (int k=j+1;k<a.size();k++) {
                    int temp = a.get(i) + a.get(j) + a.get(k);
                    if (Math.abs(temp - num) < diff) {
                        diff = Math.abs(temp - num);
                        answer = temp;
                    }
                }
            }
        }
        return answer;
    }
    /*
        When the array is sorted, try to fix the least integer by looping over it.

        Lets say the least integer in the solution is arr[i].

        Now we need to find a pair of integers j and k, such that arr[j] + arr[k] is closest to (target - arr[i]).

        To do that, let us try the 2 pointer approach.

        If we fix the two pointers at the end ( that is, i+1 and end of array ), we look at the sum.

        If the sum is smaller than the sum we need to get to, we increase the first pointer.
        If the sum is bigger, we decrease the end pointer to reduce the sum.
     */

    //two ptr
    private static int minDistance(ArrayList<Integer> a, int num, int start, int end) {
        int diff = Integer.MAX_VALUE;
        int number = 0;
        for (int i=start, j=end; i<j;) {
            int x = a.get(i);
            int y = a.get(j);
            if (Math.abs(num - (x+y)) < diff) {
                diff = Math.abs(num - (x+y));
                number = x+y;
            }
            if (num == (x+y)) return num;
            if (num < (x+y)) j--;
            else i++;
        }
        return number;
    }

    private static int solution2(ArrayList<Integer> a, int num) {
        Collections.sort(a);
        int diff = Integer.MAX_VALUE;
        int answer = num;
        for (int i=0;i<a.size()-2;i++) {
            int x = a.get(i);
            int y = minDistance(a, num-x, i+1, a.size()-1);
            if (Math.abs(num - (x+y)) < diff) {
                diff = Math.abs(num - (x+y));
                answer = x+y;
            }
        }
        return answer;
    }
}
