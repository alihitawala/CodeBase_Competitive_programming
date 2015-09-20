package Coding.ProgInt.Bloom;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/20/15.
 */
public class Chocolate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int price = in.nextInt();
        int wrapper = in.nextInt();
        int num = in.nextInt();
        int[] friends = new int[num];
        for (int i = 0; i < num; i++) {
            friends[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(solve(price, wrapper, friends)));

    }

    private static int[] solve(int price, int wrapper, int[] friends) {
        int len = friends.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int money = friends[i];
            int n = money/price;
            int count = n;
            while (n >= wrapper) {
                int left = n % wrapper;
                n = n/wrapper;
                count += n;
                n += left;
            }
            result[i] = count;
        }
        return result;
    }
}
