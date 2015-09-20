package Coding.ACM_ICPC.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 9/14/15.
 */
public class AntiBruteForce {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.parseInt(reader.readLine());
        for (int i = 0; i < x; i++) {
            String line = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            int n = Integer.parseInt(tokenizer.nextToken());
            String[] keys = new String[n+1];
            keys[0] = "0000";
            for (int j = 1; j < n+1; j++) {
                keys[j] = tokenizer.nextToken();
            }
            System.out.println(solve(keys));
        }
    }

    private static long solve(String[] keys) {
        int n = keys.length;
        int[][] adjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = countRotate(keys[i], keys[j]);
            }
        }
        return 0;
    }

    private static int countRotate(String m, String n) {
        int count = 0;
        for (int i = 0; i < m.length(); i++) {
            int p = m.charAt(i) - '0';
            int q = n.charAt(i) - '0';
            int g = Math.abs(p-q);
            count += Math.min(g, 10-g);
        }
        return count;
    }
}
