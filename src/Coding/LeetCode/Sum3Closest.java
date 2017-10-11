package Coding.LeetCode;

import java.util.Arrays;

/**
 * Created by aliHitawala on 11/2/15.
 */
public class Sum3Closest {
    public static void main(String[] args) {
        int[] a= {-3,-2,-5,3,-4};
        int target = -1;
        System.out.println(Solution.threeSumClosest(a, target));
    }
    static class Solution {
        public static int threeSumClosest(int[] a, int target) {
            if (a == null || a.length < 3)
                return 0;
            Arrays.sort(a);
            int min = Integer.MAX_VALUE;
            int ans = min;
            for (int i=0;i<a.length;i++) {
                int x = a[i];
                if (i!=0 && a[i-1] == x)
                    continue;
                int num = findClosestNum(a, i+1, x, target);
                if (num == target)
                    return target;
                if (num == Integer.MAX_VALUE)
                    continue;
                if (Math.abs(num-target) < min){
                    min = Math.abs(num-target);
                    ans = num;
                }
            }
            return ans;
        }

        private static int findClosestNum(int[] a, int start, int p, int target) {
            int min = Integer.MAX_VALUE;
            int ans = min;
            for (int i=start, j = a.length-1;i<j;) {
                int x = a[i];
                int y = a[j];
                if (x+y+p == target)
                    return target;
                else {
                    int n = x+y+p;
                    int temp = Math.abs(n-target);
                    if (temp < min) {
                        min = temp;
                        ans = n;
                    }
                }
                if (x+y+p < target)
                    i++;
                else
                    j--;

            }
            return ans;
        }
    }
}
