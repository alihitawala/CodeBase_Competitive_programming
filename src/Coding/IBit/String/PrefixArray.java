package Coding.IBit.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/8/15.
 */
public class PrefixArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<String> a = new ArrayList<String>();
            for(int j=0;j<n;j++){
                String x = in.next();
                a.add(x);
            }
            System.out.println(prefixMatch(a));
        }
    }

    private static String prefixMatch(ArrayList<String> a) {
        String first = a.get(0);
        int max=first.length();
        for(int i=1;i<a.size();i++) {
            int j=0;
            String other = a.get(i);
            int bound = 0;
            if (other.length() < first.length())
                bound = other.length();
            else
                bound = first.length();
            while(j<bound && other.charAt(j) == first.charAt(j)) j++;
            if (j<max)max=j;
        }
        return first.substring(0,max);
    }
}
