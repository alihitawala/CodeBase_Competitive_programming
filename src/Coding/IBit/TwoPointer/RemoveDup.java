package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class RemoveDup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        int j = 0;
        for (;j<a.size();) {
            a.set(i, a.get(j));
            int x = a.get(i);
            int y = a.get(j);
            int count = 0;
            while (j<a.size() && x==y ) {
                j++;
                count++;
                if (j<a.size())
                    y = a.get(j);
            }
            if (count > 1) {
                i++;
                a.set(i, a.get(i-1));
                i++;
            }
            else i++;
        }
        return i;
    }
}
