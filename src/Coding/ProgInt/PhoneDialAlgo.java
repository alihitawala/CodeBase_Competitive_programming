package Coding.ProgInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/27/15.
 */
public class PhoneDialAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            ArrayList<String> result = new ArrayList<>();
            String s = in.next();
            generateAllPermutations(s, "", result);
            System.out.println(result);
        }
    }
    private static final Map<Integer, String> DIAL_PAD_NUMBER_TO_CHARS = new HashMap<>();
    static {
        DIAL_PAD_NUMBER_TO_CHARS.put(2, "ABC");
        DIAL_PAD_NUMBER_TO_CHARS.put(3, "DEF");
        DIAL_PAD_NUMBER_TO_CHARS.put(4, "GHI");
        DIAL_PAD_NUMBER_TO_CHARS.put(5, "JKL");
        DIAL_PAD_NUMBER_TO_CHARS.put(6, "MNO");
        DIAL_PAD_NUMBER_TO_CHARS.put(7, "PQRS");
        DIAL_PAD_NUMBER_TO_CHARS.put(8, "TUV");
        DIAL_PAD_NUMBER_TO_CHARS.put(9, "WXYZ");
    }

    private static void generateAllPermutations(String s, String answer, ArrayList<String> result) {
        if (s == null || s.isEmpty()) {
            result.add(answer);
            return;
        }
        int i = s.charAt(0) - '0';
        if (i < 2 || !DIAL_PAD_NUMBER_TO_CHARS.containsKey(i))
            throw new UnsupportedOperationException("This character is not allowed");
        String chars = DIAL_PAD_NUMBER_TO_CHARS.get(i);
        for (int j = 0; j < chars.length(); j++) {
            char c = chars.charAt(j);
            generateAllPermutations(s.substring(1), answer+c, result);
        }
    }
}
