package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class LastWord {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String s = reader.readLine();
            System.out.println((new LastWord().lastWord(s)));
        }
    }

    private int lastWord(String s) {
        int answer = 0;
        boolean isWord = false;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if ((c < 'a' || c>'z') && (c<'A' || c>'Z')) {
                isWord = false;
            }
            else {
                if (isWord)
                    answer++;
                else
                {
                    isWord = true;
                    answer=1;
                }
            }
        }
        return answer;
    }
}
