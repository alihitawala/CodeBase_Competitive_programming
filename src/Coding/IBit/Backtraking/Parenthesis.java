package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class Parenthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            System.out.println(generateParenthesis(x));
        }
    }

    public static ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> result = new ArrayList<>();
        recursiveCall(a, "", 0, 0, result);
        return result;
    }

    private static void recursiveCall(int n, String s, int open, int close, ArrayList<String> result) {
        if (open == n && open == close) {
            result.add(s);
        }
        else {
            if (open < n) {
                recursiveCall(n, s + "(", open+1, close, result);
            }
            if (close < open) {
                recursiveCall(n, s + ")", open, close+1, result);
            }
        }
    }

}
