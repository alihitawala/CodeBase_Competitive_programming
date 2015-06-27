package Coding.Libo.WarmUp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class CutTheStick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int elements;
        elements = in.nextInt();
        int sticks[] = new int[elements];
        for (int i=0;i<elements;i++){
            sticks[i] = in.nextInt();
        }
        Arrays.sort(sticks);
        int l=sticks.length;
        int ptr = 0, start = 0;
        while (l!=0) {
            System.out.println(l);
            while (ptr < sticks.length && sticks[ptr] == sticks[start]) {
                ptr++;
                l--;
            }
            start = ptr;
        }
    }
}
