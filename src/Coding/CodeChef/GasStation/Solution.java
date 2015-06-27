package Coding.CodeChef.GasStation;

/**
 * Created by aliHitawala on 1/31/15.
 */
public class Solution {
    public static void main(String[] args) {
        int[] gas = {4};
        int[] cost = {5};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = this.getDifference(gas, cost);
        if (this.isAllNegative(diff))
        {
            return -1;
        }
        int start = this.getLongestSumSubsequence(diff, true);
        return this.isCircuitPossible(diff, start) ? start : -1;
    }

    private boolean isAllNegative(int[] diff) {
        for(int i=0;i<diff.length;i++)
        {
            if(diff[i]>=0)
                return false;
        }
        return true;
    }

    private boolean isCircuitPossible(int[] diff, int start) {
        int i = start;
        int temp =0;
        do {
            int index= i%diff.length;
            temp=temp+diff[index];
            if (temp<0)
                return false;
            i=(i+1)%diff.length;
        }while(i!=start);
        return true;
    }

    private int getLongestSumSubsequence(int[] diff, boolean isLoop) {
        int start=0, max=-1, maxTemp=0, startMax=-1, endMin=-1, length=diff.length;
        for (int i=0;i<length;i++)
        {
            maxTemp=diff[i]+maxTemp;
            if (maxTemp>=0 && maxTemp>max)
            {
                max=maxTemp;
                startMax=start;
                endMin=i;
            }
            else if (maxTemp<0)
            {
                start=i+1;
                maxTemp=0;
            }
        }
        if (isLoop && endMin != length-1)
        {
            int endTemp = endMin;
            for (int i=endTemp+1;i!=endTemp;i=(i+1)%length)
            {
                int index = i%length;
                maxTemp = diff[index] + maxTemp;
                if (maxTemp >= 0 && maxTemp>max)
                {
                    max = maxTemp;
                    startMax = start;
                    endMin = i;
                }
                else if (maxTemp <0)
                {
                    start =(i+1) %length;
                    maxTemp = 0;
                }
            }
        }
        return startMax;
    }

    private int[] getDifference(int[] gas, int[] cost) {
        int diff[] = new int[gas.length];
        for (int i =0;i<gas.length;i++)
            diff[i] = gas[i]-cost[i];
        return diff;
    }
}
