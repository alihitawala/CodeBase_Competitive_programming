package Coding.ProgInt;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 8/4/15.
 */
public class Decipher {
    public static void main(String[] args) {
        int[] a = {1,0,2,3, 4};
        decipher(a);
    }
    private static void decipher(int[] a) {
        _decipher(a, new ArrayList<Integer>(), 0);
    }

    private static void _decipher(int[] a, ArrayList<Integer> result, int index) {
        if (index == a.length) {
            for (int i : result) {
                char c = (char)(i + 'A' - 1);
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if (a[index] != 0)
            result.add(a[index]);
        _decipher(a, result, index + 1);
        if (a[index] != 0)
            result.remove(result.size()-1);
        if (!result.isEmpty() && index > 0) {
            int value = result.get(result.size()-1) *10 + a[index];
            if (value <27 && value >9) {
                int removedValue = result.remove(result.size()-1);
                result.add(value);
                _decipher(a, result, index + 1);
                result.remove(result.size()-1);
                result.add(removedValue);
            }
        }
    }
}
