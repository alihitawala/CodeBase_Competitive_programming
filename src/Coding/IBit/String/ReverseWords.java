package Coding.IBit.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class ReverseWords {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String s = reader.readLine();
            System.out.println((new ReverseWords().reverseWords(s)));
        }
    }

    private String reverseWords(String s) {
        String reverse = reverse(s);
        StringBuilder answer = new StringBuilder("");
        boolean isWord = false;
        int start = 0, end = 0;
        for (int i=0;i<reverse.length();i++) {
            char c = reverse.charAt(i);
            if ((c < 'a' || c>'z') && (c<'A' || c>'Z')) {
                if(isWord) {
                    answer.append(reverse(reverse.substring(start, end+1)));
                    answer.append(" ");
                }
                isWord = false;
                start = 0;
                end = 0;
            }
            else {
                if (isWord) {
                    end=i;
                }
                else
                {
                    isWord = true;
                    start = i;
                    end=i;
                }
            }
        }
        if(isWord) {
            answer.append(reverse(reverse.substring(start, end+1)));
            answer.append(" ");
        }
        return answer.toString().trim();
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i=0;i<n/2;i++) {
            swap(chars, i, n-1-i);
        }
        return String.copyValueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


}
