package Coding.IBit.Math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/5/15.
 */
public class Path {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(paths(n, m));
        }
    }

    private static int paths(int n, int m) {
        if (n==0 || m==0) return 1;
        if (n>m) {
            int temp = n;n=m;m=temp;
        }
        int[] slot1 = new int[n];
        int[] slot2 = new int[n];
        for (int i=0;i<n;i++) {
            slot1[i]=0;
            slot2[i]=0;
        }
        boolean isSlot1=true;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (j==0 && isSlot1) slot1[j]=1;
                else if (j==0 && !isSlot1) slot2[j]=1;
                else if (isSlot1) slot1[j] = slot1[j-1] + slot2[j];
                else if (!isSlot1) slot2[j] = slot2[j-1] + slot1[j];
            }
            isSlot1=!isSlot1;
        }
        return !isSlot1 ? slot1[n-1] : slot2[n-1];
    }
}
