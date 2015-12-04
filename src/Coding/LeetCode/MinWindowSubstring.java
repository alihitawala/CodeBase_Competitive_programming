package Coding.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliHitawala on 11/18/15.
 */
public class MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return s;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else
                map.put(c, 1);
        }
        int count = 0;
        int tail = 0;
        int start = 0, end =0, min = Integer.MAX_VALUE;
        Map<Character,Integer> aux = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (aux.containsKey(c)) {
                int times = aux.get(c);
                if (times < map.get(c))
                    count++;
                aux.put(c, aux.get(c)+1);
            }
            else if (map.containsKey(c)) {
                aux.put(c, 1);
                count++;
            }
            while (count == t.length()) {
                char d = s.charAt(tail);
                if (aux.containsKey(d) && aux.get(d) > 0) {
                    int times = aux.get(d);
                    if (times == map.get(d))
                        count--;
                    aux.put(d, aux.get(d)-1);
                }
                if (min > (i-tail+1))
                {
                    min = i-tail+1;
                    start = tail;
                    end = i+1;
                }
                tail++;
            }
        }
        return s.substring(start, end);
    }
}
