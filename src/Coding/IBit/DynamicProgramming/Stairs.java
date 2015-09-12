package Coding.IBit.DynamicProgramming;

/**
 * Created by aliHitawala on 9/12/15.
 */
public class Stairs {

    public int climbStairs(int a) {
        if (a == 0)
            return 1;
        else if (a <0)
            return 0;
        int[] n = new int[a+3];
        n[0] = 1;
        n[1] = 2;
        for (int i = 2; i < a; i++) {
            n[i] = n[i-1]+n[i-2];
        }
        return n[a-1];
    }
}
