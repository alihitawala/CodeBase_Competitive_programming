package Coding.IBit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/26/15.
 */
public class PlusOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        printArray(plusOne(a));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        Integer a[] = A.toArray(new Integer[n]);
        int carry =1;
        for (int i=a.length-1;i>=0;i--) {
            a[i]+=carry;
            if (a[i]/10 > 0) carry = 1;
            else { carry = 0; break;}
            a[i]%=10;
        }
        int index = 0;
        if (carry==1) {
            A.add(0,1);
            index = 1;
            n++;
        }
        for (int i:a) {
            A.set(index, i);
            index++;
        }
        index=0;
        while (A.get(index) == 0) {
            index++;
        }
        return new ArrayList<Integer>(A.subList(index, n));
    }

    private static void printArray(ArrayList<Integer> solve) {
        for (int j : solve)
            System.out.print(j + " " );
        System.out.println();
    }
}
