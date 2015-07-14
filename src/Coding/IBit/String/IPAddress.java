package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/10/15.
 */
public class IPAddress {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String n = in.next();
            printArray(new IPAddress().getSolution(n));
        }
    }

    private String[] result = new String[4];
    private ArrayList<String> answer = new ArrayList<String>();

    private ArrayList<String> getSolution(String s) {
        solution(s, 4);
        return answer;
    }

    private void solution(String s, int n) {
        if (n==1) {
            if (s.length() == 0) return;
            String t = s.substring(0);
            int num = Integer.parseInt(t);
            if (num <=255 && t.equals(String.valueOf(num))) {
                result[4-n] = t;
                StringBuilder b = new StringBuilder("");
                for (int i=0;i<3;i++) {
                    b.append(result[i]).append(".");
                }
                b.append(result[3]);
                answer.add(b.toString());
            }
            return;
        }
        for (int i=1;i<=3;i++) {
            if (s.length() < i) return;
            String t = s.substring(0,i);
            int num = Integer.parseInt(t);
            if (num <=255 && t.equals(String.valueOf(num))) {
                result[4-n] = t;
                solution(s.substring(i), n-1);
            }
            else return;
        }
    }

    private static void printArray(ArrayList<String> solve) {
        for (String i :solve) {
            System.out.print(i + " " );
        }
    }
}
