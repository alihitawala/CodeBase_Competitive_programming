package Coding.ACM_ICPC.graph;

import java.util.*;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class RankLanguages {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[][] c = new char[x][y];
            for (int j = 0; j < x; j++) {
                String s = in.next();
                for (int k = 0; k < s.length(); k++) {
                    c[j][k] = s.charAt(k);
                }
            }
            List<Pair> pairs = solve(c);
            int worldnum = i+1;
            System.out.println("World #" + worldnum);
            for(Pair p : pairs) {
                System.out.println(p.c + ": " + p.freq);
            }
        }
    }

    private static List<Pair> solve(char[][] c) {
        Map<Character, Integer> result = new HashMap<>();
        int x = c.length;
        int y = c[0].length;
        boolean[][] cache = new boolean[x][y];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                char p = c[i][j];
                if (!cache[i][j]) {
                    cache[i][j] = true;
                    recursiveCall(c, i, j, cache);
                    if (result.containsKey(p)) {
                        result.put(p, result.get(p) + 1);
                    }
                    else
                        result.put(p,1);
                }
            }
        }
        List<Pair> pair = new ArrayList<>();
        for(Map.Entry<Character, Integer> e : result.entrySet()) {
            pair.add(new Pair(e.getKey(), e.getValue()));
        }
        Collections.sort(pair, new Comparator<Pair>() {
            @Override
            public int compare(Pair p, Pair q) {
                if (p.freq != q.freq)
                    return q.freq-p.freq;
                return p.c - q.c;
            }
        });
        return pair;
    }

    private static void recursiveCall(char[][] c, int i, int j, boolean[][] cache) {
        if (i < 0 || i >= c.length || j < 0 || j> c[0].length)
            return;
        char p = c[i][j];
        if (i-1 >=0 && !cache[i-1][j] && c[i-1][j] == p) {
            cache[i-1][j]= true;
            recursiveCall(c,i-1,j,cache);
        }
        if (i+1 < c.length && !cache[i+1][j] && c[i+1][j] == p) {
            cache[i+1][j]= true;
            recursiveCall(c, i + 1, j, cache);
        }
        if (j-1 >=0 && !cache[i][j-1] && c[i][j-1] == p) {
            cache[i][j-1]= true;
            recursiveCall(c,i,j-1,cache);
        }
        if (j+1 < c[0].length && !cache[i][j+1] && c[i][j+1] == p) {
            cache[i][j+1]= true;
            recursiveCall(c,i,j+1,cache);
        }
    }

    static class Pair {
        char c;
        int freq;

        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
