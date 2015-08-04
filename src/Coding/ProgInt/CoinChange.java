package Coding.ProgInt;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 7/30/15.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int coin = 6;
        coinChange(a, coin);
    }

    private static void coinChange(int[] a, int coin) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        _coinChange(a, coin, b, 0);
    }

    private static void _coinChange(int[] a, int coin, ArrayList<Integer> b, int index) {
        if (coin == 0) {
            print(b);
        }
        else if (index < a.length && coin - a[index] >=0) {
            b.add(a[index]);
            _coinChange(a, coin-a[index], b, index);
            b.remove(b.size()-1);
            _coinChange(a, coin, b, index+1);
        }
    }

    private static void print(ArrayList<Integer> a) {
        System.out.print("{");
        for (int i : a) {
            System.out.print(i);
        }
        System.out.print("}");
        System.out.println();
    }
}
