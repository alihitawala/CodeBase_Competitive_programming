package Coding.IBit.TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/21/15.
 */
public class ThreeSumZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        printArray(threeSum(a));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < a.size() - 2; i++) {
            int x = a.get(i);
            if (i!= 0 && x == a.get(i-1))
                continue;
            List<Pair> pairs = findZeroSum(a, -x, i + 1, a.size() - 1);

            for (Pair p : pairs) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(p.x);
                pair.add(p.y);
                answer.add(pair);
            }
        }
        return answer;
    }

    private static List<Pair> findZeroSum(ArrayList<Integer> a, int num, int start, int end) {
        List<Pair> answer = new ArrayList<>();
        for (int i = start, j=end; i < j;) {
            int x = a.get(i);
            int y = a.get(j);
            if (x+y == num) {
                Pair p = new Pair();
                p.x = x;
                p.y = y;
                answer.add(p);
                i++;
                while (i<j && x == a.get(i))
                    i++;
                j--;
                while (i<j && y == a.get(j))
                    j--;
            }
            else if (x+y < num)
                i++;
            else j--;

        }
        return answer;
    }

    private static void printArray(ArrayList<ArrayList<Integer>> solve) {
        for (ArrayList<Integer> i :solve) {
            for (int j : i)
                System.out.print(j + " " );
            System.out.println();
        }
    }

    static class Pair {
        int x;
        int y;
    }
}
