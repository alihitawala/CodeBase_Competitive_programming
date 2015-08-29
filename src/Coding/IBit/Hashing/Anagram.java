package Coding.IBit.Hashing;

import java.util.*;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class Anagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        System.out.println(anagrams(a));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            if (map.containsKey(s)) {
                int index = map.get(s);
                result.get(index).add(i+1);
            } else {
                map.put(s, result.size());
                ArrayList<Integer> t = new ArrayList<>();
                t.add(i+1);
                result.add(t);
            }
        }
        return result;
    }
}
