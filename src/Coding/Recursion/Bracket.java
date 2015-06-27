package Coding.Recursion;

/**
 * Created by aliHitawala on 5/16/15.
 */
public class Bracket {
    public static void main(String[] args) {
        int numBracket = 9;
        print(4);
    }

    private static void print(int i) {
        _print("(", 1,0,i);
    }

    private static void _print(String tillNow, int open, int close, int total) {
        if (tillNow.length() > total*2 || open < close || open > total)
            return;
        if (tillNow.length() == total*2) {
            System.out.println(tillNow);
        }
        else if (total == open) {
            _print(tillNow+")", open,close+1,total);
        }
        else {
            _print(tillNow+"(", open+1,close,total);
            _print(tillNow+")", open,close+1,total);
        }
    }
}
