package Coding.ProgInt;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        int[] a = {5};
        System.out.println(longestPalindrome(a));
    }
    private static int longestPalindrome(int[] a) {
        int maxCount=0;
        for (int i=0;i<a.length;i++) {
            int count=1;
            int j=i, k=i+2;
            while (j>=0 && k<a.length && a[j--]==a[k++])
                count+=2;
            if (count > maxCount)
                maxCount = count;
            j=i-1;k=i;
            count=0;
            while (j>=0 && k<a.length && a[j--]==a[k++])
                count+=2;
            if (count>maxCount)
                maxCount=count;
        }
        return maxCount;
    }
}
