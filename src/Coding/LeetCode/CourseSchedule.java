package Coding.LeetCode;

import java.util.*;

/**
 * Created by aliHitawala on 11/15/15.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[][] array = new int[t][];
        for (int i=0;i<n;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int[] ar = new int[]{a,b};
            array[i] = ar;
        }
        System.out.println(Arrays.toString(new CourseSchedule().findOrder(n, array)));
    }
    public int[] findOrder(int n, int[][] p) {
        if (p.length == 0) {
            int[] ar = new int[n];
            for (int i=0;i<n;i++)
                ar[i] = i;
            return ar;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] present = new boolean[n];
        for (int[] ar : p) {
            present[ar[1]] = true;
            if (map.containsKey(ar[1]))
                map.get(ar[1]).add(ar[0]);
            else {
                List<Integer> l = new ArrayList<>();
                l.add(ar[0]);
                map.put(ar[1], l);
            }
        }
        Stack<Integer> stack= new Stack<>();
        int[] res = new int[0];
        int[] b = new int[n];
        //0 - white 1 - gray 2 - black
        for (int i=0;i<n;i++) {
            if (b[i] == 0 && map.containsKey(i)) {
                if (!dfs(i, map, b, stack))
                    return res;
            }
            else if (b[i] == 1)
                return res;
        }
        int[] result = new int[n];
        int len = stack.size();
        int i=0;
        for(i=0;i<len;i++) {
            result[i] = stack.pop();
        }
        for (int j=0;j<n;j++)
            if (!present[j])
                result[i++] = j;
        return result;
    }

    private boolean dfs(int v, HashMap<Integer, List<Integer>> map, int[] b, Stack<Integer> stack) {
        List<Integer> nei = map.get(v);
        b[v] = 1;
        for (int i : nei) {
            if (b[i] == 0 && map.containsKey(i)) {
                dfs(i, map, b, stack);
            }
            else if (b[i] == 1)
            {
                return false;
            }
        }
        stack.push(v);
        b[v] = 2;
        return true;
    }
}
