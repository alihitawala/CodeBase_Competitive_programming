package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class DiffK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        int num = in.nextInt();
        System.out.println(solution(a, num));
    }

    private static int solution(ArrayList<Integer> a, int num) {
        for (int i=0,j=1;j<a.size();) {
            int x = a.get(i);
            int y = a.get(j);
            int diff = y-x;
            if (diff == num) return 1;
            if (diff < num) j++;
            else {
                i++;
                if (i==j) j++;
            }
        }
        return 0;
    }

}
