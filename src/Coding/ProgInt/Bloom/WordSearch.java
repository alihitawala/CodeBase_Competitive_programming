package Coding.ProgInt.Bloom;

import java.util.*;

/**
 * Created by aliHitawala on 9/21/15.
 */
public class WordSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = in.next();
                a[i][j] = s.charAt(0);
            }
        }
        String[] s = new String[m];
        for (int i = 0; i < m; i++) {
            s[i] = in.next();
        }
        System.out.println(solve(a, s, n, m));
    }

    private static List<String> solve(char[][] a, String[] s, int len, int slen) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map.containsKey(a[i][j])) {
                    map.get(a[i][j]).add(new Pair(i,j));
                }
                else {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(i,j));
                    map.put(a[i][j], list);
                }
            }
        }
        int[][] cache = new int[len][len];
        for (int i = 0; i < slen; i++) {
            if (map.containsKey(s[i].charAt(0)) && find(s[i], a, map.get(s[i].charAt(0)), cache))
                result.add(s[i]);
        }
        return result;
    }
    private static int token = 1;
    private static boolean find(String s, char[][] a, List<Pair> pairs, int[][] cache) {
        for (Pair pair : pairs) {
            if (recursive(s, a, pair.i, pair.j, cache, token++))
                return true;
        }
        return false;
    }

    private static boolean recursive(String s, char[][] a, int i, int j, int[][] cache, int token) {
        if (s == null || s.isEmpty())
            return true;
        if (s.charAt(0) != a[i][j])
            return false;
        cache[i][j] = token;
        if (i > 0 && cache[i-1][j] != token)
            if (recursive(s.substring(1), a, i-1, j, cache, token))
                return true;
        if (i < a.length-1 && cache[i+1][j] != token)
            if (recursive(s.substring(1), a, i+1, j, cache, token))
                return true;
        if (j < a.length-1 && cache[i][j+1] != token)
            if (recursive(s.substring(1), a, i, j+1, cache, token))
                return true;
        if (j > 0 && cache[i][j-1] != token)
            if (recursive(s.substring(1), a, i, j-1, cache, token))
                return true;
        return false;
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
