package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class LetterPhone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            String x =in.next();
            System.out.println(letterCombinations(x));
        }
    }

    public static ArrayList<String> letterCombinations(String a) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<a.length();i++) {
            char c = a.charAt(i);
            list.add(getString(c));
        }
        ArrayList<String> result = new ArrayList<>();
        recursive(list, 0, "", result);
        return result;
    }

    private static void recursive(ArrayList<String> list, int listItem, String content, ArrayList<String> result) {
        if (list.size() == listItem) {
            result.add(content);
            return;
        }
        String item = list.get(listItem);
        for(int i=0;i<item.length();i++) {
            char c = item.charAt(i);
            recursive(list, listItem+1, content+c, result);
        }
    }

    private static String getString(char c) {
        switch (c) {
            case '1':
                return "1";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return "0";
        }
        throw new RuntimeException("number not supported");
    }
}
