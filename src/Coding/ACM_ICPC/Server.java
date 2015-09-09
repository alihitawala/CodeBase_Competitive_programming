package Coding.ACM_ICPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 9/8/15.
 */
public class Server {
}
class Main {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        sc.useDelimiter(System.getProperty("line.separator"));
//        while (sc.hasNextInt()){
//            int n = sc.nextInt();
//            int d = sc.nextInt();
//            int[] a = new int[n];
//            for(int j=0;j<n;j++){
//                a[j] = sc.nextInt();
//            }
//            System.out.print(solve(a, d));
//        }
        read();
    }

    public static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        while (!x.trim().equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(x);
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int[] a = new int[n];
            x = reader.readLine();
            tokenizer = new StringTokenizer(x);
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(solve(a, d));
            x = reader.readLine();
        }
    }

    private static int solve(int[] a, int d) {
        int s = a[0];
        if (s > d)
            return 0;
        for (int i = 1; i < a.length; i++) {
            s += a[i];
            if (s > d)
                return i;
        }
        return a.length;
    }
}
