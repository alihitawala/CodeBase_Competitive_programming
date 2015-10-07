package MS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/30/15.
 */
public class Happy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<10;i++) {
            int s = in.nextInt();
            try {
                System.out.println(solve(s));
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }

    private static String solve(long s) {
        HashMap<Long, Long> map = new HashMap<>();
        long original = s;
        map.put(s,s);
        s = getN(s);
        long count = s == 1 ? 0 : 1;
        while (!map.containsKey(s) && s != 1) {
            map.put(s,s);
            s = getN(s);
            count++;
        }
        String what = "";
        if (s == 1)
            what = "happy ";
        else
            what = "unhappy ";
        return what + count;
    }

    private static long getN(long s) {
        ArrayList<Long> digits = new ArrayList<>();
        while (s != 0) {
            digits.add(s%10);
            s = s/10;
        }
        return sumSquare(digits);
    }

    private static long sumSquare(ArrayList<Long> digits) {
        long answer = 0;
        for(long i : digits) {
            answer += i*i;
        }
        return answer;
    }
}
