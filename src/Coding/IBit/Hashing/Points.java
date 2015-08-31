package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Points {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            Integer x =in.nextInt();
            Integer y =in.nextInt();
            a.add(y);
            b.add(x);
        }
        System.out.println(maxPoints(a, b));
    }

    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int length = a.size();
        if (length == 0) return 0;
        if (length == 1) return 1;
        if (length == 2) return 1;
        int max = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                int x1 = a.get(i);
                int x2 = a.get(j);
                int y1 = b.get(i);
                int y2 = b.get(j);
                Double slope = (1.0*(y2-y1)/(x2-x1));
                if (y2-y1 == 0 || y1-y2  == 0)
                    slope = 0.0;
                if (map.containsKey(slope)) {
                    int count = map.get(slope);
                    count++;
                    map.put(slope, count);
                    if (max < count)
                        max = count;
                }
                else
                    map.put(slope, 2);
            }
            map.clear();
        }
        return max == 0 ? 2 : max;
    }
}
