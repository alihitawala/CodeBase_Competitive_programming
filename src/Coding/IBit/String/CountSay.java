package Coding.IBit.String;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class CountSay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            System.out.println((new CountSay().countSay(n)));
        }
    }
    private static HashMap<Integer, String> cache = new HashMap<Integer, String>();
    static {
        cache.put(1,"1");
    }
    private static int maxFound = 1;
    private String countSay(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int max = maxFound;
        String start = cache.get(maxFound);
        for (int i=max+1;i<=n;i++) {
            StringBuilder temp = new StringBuilder("");
            char current = start.charAt(0);
            int currentCount = 1;
            for (int j=1;j<start.length();j++) {
                if (start.charAt(j) == current) currentCount++;
                else {
                    temp.append(currentCount).append(current);
                    current=start.charAt(j);currentCount=1;
                }
            }
            temp.append(currentCount).append(current);
            start = temp.toString();
            cache.put(i, start);
        }
        maxFound = n;
        return cache.get(n);
    }
}
