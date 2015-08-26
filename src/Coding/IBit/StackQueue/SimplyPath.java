package Coding.IBit.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 8/25/15.
 */
public class SimplyPath {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = reader.readLine();
            System.out.println(simplifyPath(x));
        }
    }

    public static String simplifyPath(String a) {
        StringTokenizer tokenizer = new StringTokenizer(a, "/");
        Stack<String> stack = new Stack<>();
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(".")) {
                continue;
            }
            else if (token.equals(".."))
            {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.push(token);
            }
        }
        StringBuilder builder = new StringBuilder("");
        for(String s : stack) {
            builder.append("/").append(s);
        }
        if (builder.toString().equals(""))
            builder.append("/");
        return builder.toString();
    }
}
