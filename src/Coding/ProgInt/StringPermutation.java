package Coding.ProgInt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class StringPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            System.out.println(permutations(a));
        }
    }

    private static ArrayList<String> permutations(String a) {
        if (a == null)
            return null;
        ArrayList<String> permutations = new ArrayList<>();
        if (a.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = a.charAt(0);
        String remaining = a.substring(1);
        ArrayList<String> words = permutations(remaining);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, char first, int j) {
        String start = word.substring(0,j);
        String end = word.substring(j);
        return start+first+end;
    }
}
