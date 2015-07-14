package Coding.IBit.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/9/15.
 */
public class Version {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            String x = in.next();
            String y = in.next();
            System.out.println(version(x, y));
        }
    }

    private static int version(String x, String y) {
        ArrayList<String> a = getVersionList(x);
        ArrayList<String> b = getVersionList(y);
        for (int i=0;i<a.size() && i<b.size();i++) {
            String val1 = a.get(i); int len1 = val1.length();
            String val2 = b.get(i); int len2 = val2.length();
            if (len1 > len2) {
                return 1;
            }
            else if (len2 > len1) {
                return -1;
            }
            else {
                int r = val1.compareTo(val2);
                if (r != 0) return r<0 ? -1 : 1;
            }
        }
        return a.size() == b.size() ? 0 : ((a.size() > b.size()) ? 1 : -1);
    }

    private static ArrayList<String> getVersionList(String x) {
        ArrayList<String> a = new ArrayList<String>();
        StringBuilder v = new StringBuilder("");
        boolean isFirstZero = true;
        for (int i=0;i<x.length();i++) {
            char c = x.charAt(i);
            if (c == '.'){
                a.add(v.toString());
                v = new StringBuilder("");
                isFirstZero = true;
            }
            else {
                if (!isFirstZero || c != '0') {
                    v.append(c);
                    isFirstZero = false;
                }
            }
        }
        if (x.charAt(x.length()-1) != '.' && v.length()>0) {
            a.add(v.toString());
        }
        return a;
    }


}
