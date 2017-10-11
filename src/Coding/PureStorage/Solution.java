package Coding.PureStorage;

/**
 * Created by aliHitawala on 3/14/16.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("hellolle"));
        System.out.println(longestPalindrome("wowpurerocks"));
    }
    public static int longestPalindrome(String s) {
        char[] a = s.toCharArray();
        int p = getLongestEven(a);
        int q = getLongestOdd(a);
        return p+q;
    }

    private static int getLongestEven(char[] a) {
        int i=0;
        int j=1;
        int count = 0;
        for (int k=0;k<a.length-1;k++) {
            i=k;j=k+1;
            while (i>=0 && j<a.length && a[i] == a[j]) {
                i--;j++;
                count++;
            }
        }
        return count;
    }
    private static int getLongestOdd(char[] a) {
        int i=0;
        int j=0;
        int count = 0;
        for (int k=0;k<a.length;k++) {
            i=k;j=k;
            while (i>=0 && j<a.length && a[i] == a[j]) {
                i--;j++;
                count++;
            }
        }
        return count;
    }
}
