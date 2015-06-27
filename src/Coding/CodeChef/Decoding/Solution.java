package Coding.CodeChef.Decoding;

import java.util.HashMap;

/**
 * Created by aliHitawala on 1/31/15.
 */
public class Solution {
    HashMap<String,Integer> map;
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println(new Solution().numDecodings("11123"));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }
//    public int numDecodings(String s) {
//        map = new HashMap<String, Integer>();
//        return this.getPermutations(s);
//    }

    public int numDecodings(String s) {
        int len = s.length();
        char[] nums = s.toCharArray();
        if (len == 0 || nums[0] == '0') return 0;
        int[] ways = new int[len];
        ways[0] = 1;

        for (int i=1; i<len; i++) {
            // Add result calculated step back
            ways[i] = ways[i-1];

            // "00", "30"..."90" are not accepted
            if (nums[i] == '0' && (nums[i-1] < '1' || nums[i-1] > '2')) return 0;

            // Add result calculated two steps back
            // if "11"..."19" or "21...26" but not like "110" or "210"
            if (nums[i-1] == '1' && nums[i] != '0' && ((i+1 < len && nums[i+1] != '0') || i+1 == len)) {
                ways[i] += i-2 > 0 ? ways[i-2] : 1;
            }
            if (nums[i-1] == '2' && nums[i] > '0' && nums[i] < '7') {
                ways[i] += i-2 > 0 ? ways[i-2] : 1;
            }
        }
        return ways[len-1];
    }

    private int getPermutations(String s) {
        if (map.containsKey(s))
        {
            return map.get(s);
        }
        if (s.length() == 0)
            return 0;
        if(s.length() <=2)
        {
            int num = Integer.parseInt(s);
            if (num>9 && num < 27 && num !=10 && num!=20)
            {
                return 2;
            }
            else if (num > 0)
                return 1;
            else
                return 0;
        }
        int first = Integer.parseInt(s.substring(0,1));
        int second = Integer.parseInt(s.substring(0,2));
        boolean isTwoDigit = second <=26;
        int result = 0;
        result = getPermutations(s.substring(1));
        result += isTwoDigit ? getPermutations(s.substring(2)) : 0;
        map.put(s, result);
        return result;
    }
}
