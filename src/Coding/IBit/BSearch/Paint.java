package Coding.IBit.BSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 7/7/15.
 */
public class Paint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int x = in.nextInt();
                a.add(x);
            }
            int m = in.nextInt();
//            int b = in.nextInt();
            System.out.println(books(a, m));
//            System.out.println(paint(a, m,b));
//            System.out.println(isPos(a, b, m));
        }
    }

    private static int paint(ArrayList<Integer> a, int m, int b) {
        long temp = new Long(b)*(solution(a, m) % 10000003);
        return (int)(temp%10000003);
    }

    private static int books(ArrayList<Integer> a, int m) {
        return solution(a, m);
    }
    private static int solution(ArrayList<Integer> a, int m) {
        int low=0;
        int high = sum(a);
        int min = high;
        while (low <=high) {
            int mid = low + (high-low)/2;
            if (isPos(a, mid, m)) {
                if (min > mid)
                    min = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return min;
    }

    private static boolean isPos(ArrayList<Integer> a, int num, int n) {
        int sum=a.get(0);
        int member = 0;
        for (int i=1;i<a.size();i++) {
            if (sum <= num && (sum+a.get(i)) > num)
            {
                member++;
                sum = a.get(i);
            }
            else {
                sum+=a.get(i);
            }
        }
        if (sum <= num)
            member++;
        else
            return false;
        return member <= n;
    }

    private static int sum (ArrayList<Integer> a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
