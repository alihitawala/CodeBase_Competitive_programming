package Coding.IBit.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/4/15.
 */
public class Repeat3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            List<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println((repeatedNumber(A)));
        }
    }

    private static int repeatedNumber(List<Integer> a) {
        int slot1=-1,slot2=-1,count1=0,count2=0;
        for (int i :a) {
            if (slot1 == i) count1++;
            else if (slot2 == i) count2++;
            else if (count1 == 0){ count1 = 1;slot1=i;}
            else if (count2 == 0){ count2 = 1;slot2=i;}
            else {count1--;count2--;}
        }
        int n1 =0,n2=0;
        for(int i:a){
            if (i==slot1) n1++;
            else if (i==slot2) n2++;
        }
        if (n1> (a.size()/3)) return slot1;
        if (n2> (a.size()/3)) return slot2;
        return -1;
    }
}
