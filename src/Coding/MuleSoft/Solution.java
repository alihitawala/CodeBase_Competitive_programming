package Coding.MuleSoft;

/**
 * Created by aliHitawala on 3/15/16.
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = {5,4,0,3,1,6,2};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        boolean isPresent[] = new boolean[a.length];
        int maxCount = 0;
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            int count = 0;
            while (!isPresent[j]) {
                isPresent[j] = true;
                j = a[j];
                count++;
            }
            if (maxCount < count)
                maxCount = count;
        }
        return maxCount;
    }

    boolean isMisplace(int[] a, int i) {
        if (a.length == 1 || a.length == 0)
            return false;
        if (i == 0 && a[i] > a[i+1])
            return true;
        if (i == a.length - 1 && a[i] < a[i-1])
            return true;
        return false;
    }
}
