package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class RepeatStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            String x =in.next();
            System.out.println(lengthOfLongestSubstring(x));
        }
    }

    public static int lengthOfLongestSubstring(String a) {
        char[] str = a.toCharArray();
        int n = a.length();
        int cur_len = 1;  // To store the length of current substring
        int max_len = 1;  // To store the result
        int prev_index;  // To store the previous index
        int i;
        int[] visited = new int[256];
        for (i = 0; i < 256;  i++)
            visited[i] = -1;
        visited[str[0]] = 0;
        for (i = 1; i < n; i++)
        {
            prev_index =  visited[str[i]];
            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else
            {
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }
            visited[str[i]] = i; // update the index of current character
        }

        // Compare the length of last NRCS with max_len and update max_len if needed
        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }
}
