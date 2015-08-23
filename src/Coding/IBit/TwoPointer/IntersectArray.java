package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class IntersectArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        n = in.nextInt();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            b.add(x);
        }
        print(intersect(a,b));
    }

    private static void print(ArrayList<Integer> intersect) {
        for (int i: intersect) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0,j=0;i<a.size()&&j<b.size();) {
            int x = a.get(i);
            int y = b.get(j);

            if (x==y) {
                answer.add(x);
                i++;j++;
            }
            else if (x<y) i++;
            else j++;
        }
        return answer;
    }
}
