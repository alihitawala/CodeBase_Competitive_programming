package Coding;

/**
 * Created by aliHitawala on 3/3/16.
 */
public class Solution {
    public static void main(String[] args) {
        String s = "ali hussain     hita  ";
        StringBuilder sb = new StringBuilder("");
        for (int i=0,j=0;i<s.length();) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                i++;
                continue;
            }
            j=i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            sb.append(new StringBuilder(s.substring(j, i)).reverse());
        }
        System.out.println(sb.toString());
    }
}

