package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class Colorful {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            System.out.println(colorful(x));
        }
    }

    public static int colorful(int n) {
        if (n<0)
            return 0;
        ArrayList<Integer> a = new ArrayList<>();
        while (n != 0) {
            a.add(n%10);
            n/=10;
        }
        if (a.size() == 1)
            return 1;
        map.clear();
        for (int i=0;i<a.size();i++) {
            for (int j=i+1;j<=a.size();j++) {
                int prod = 1;
                for (int k=i;k<j;k++) {
                    prod *= a.get(k);
                }
                if (map.containsKey(prod))
                    return 0;
                map.put(prod, 1);
            }
        }
        return 1;
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();

  /*  private static boolean recursive(ArrayList<Integer> a, int index, int product) {
        if (a.size() == index) {
            if (map.containsKey(product))
                return false;
            map.put(product, 1);
            return true;
        }
        if (!recursive(a, index+1, product))
            return false;
        int x= a.get(index);
        return recursive(a, index+1, product*x);
    }*/
}
