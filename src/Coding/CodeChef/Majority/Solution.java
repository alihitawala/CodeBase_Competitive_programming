package Coding.CodeChef.Majority;

/**
 * Created by aliHitawala on 2/1/15.
 */
public class Solution {

    public int majorityElement(int[] num) {
        int n = num[0];
        int count = 1;
        for (int i=1;i<num.length;i++)
        {
            if (num[i] == n)
            {
                count++;
            }
            else
            {
                count--;
            }
            if (count < 1)
            {
                count=1;
                n=num[i];
            }
        }
        return n;
    }
}
