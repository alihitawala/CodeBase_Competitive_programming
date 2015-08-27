package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class PalinPart {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            for(int j=0;j<n;j++){
                String x =in.next();
                System.out.println(partition(x));
            }
        }

    public static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        recursive(a, null, result, a.length());
        return result;
    }

    private static void recursive(String a, ArrayList<String> list, ArrayList<ArrayList<String>> result, int origLength) {
        if (a.length() == 0)
        {
            if (list == null || list.isEmpty())
                return;
            ArrayList<String> newList = new ArrayList<>(list);
            result.add(newList);
        }
        else {
            for (int i = 1; i <= a.length(); i++) {
                String temp = a.substring(0, i);
                if (isPalin(temp)) {
                    if (origLength == a.length())
                        list = new ArrayList<>();
                    else if (list == null || list.isEmpty())
                        return;
                    list.add(temp);
                    recursive(a.substring(i), list, result, origLength);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private static boolean isPalin(String s) {
        for(int i=0, j=s.length()-1;i<j;i++,j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
