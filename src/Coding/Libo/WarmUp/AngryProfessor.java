package Coding.Libo.WarmUp;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t ;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n, threshold;
            n = in.nextInt();
            threshold = in.nextInt();
            int studentsIn = 0;
            for (int j=0;j<n;j++) {
                int temp = in.nextInt();
                if (temp<=0) studentsIn++;
            }
            if (studentsIn < threshold)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
