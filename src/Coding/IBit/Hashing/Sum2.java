package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class Sum2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            Integer x =in.nextInt();
            a.add(x);
        }
        int x = in.nextInt();
        System.out.println(twoSum(a, x));
    }

    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);
            int diff = b - x;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                result.add(index);
                result.add(i+1);
                return result;
            }
            else if (!map.containsKey(x)){
                map.put(x, i+1);
            }
        }
        return result;
    }
}
