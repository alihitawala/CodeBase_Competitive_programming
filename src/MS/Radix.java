package MS;

import javax.security.sasl.SaslClient;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by aliHitawala on 9/30/15.
 */
public class Radix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<454;i++) {
            String s = in.next();
            try {
                System.out.println(solve(s));
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }

    private static String solve(String s) {
        StringTokenizer token = new StringTokenizer(s, ",");
        String in = token.nextToken();
        if (!in.toLowerCase().equals(in))
            throw new RuntimeException();
        int original = Integer.parseInt(token.nextToken());
        int newbase = Integer.parseInt(token.nextToken());
        if (original < 2 || original > 36 || newbase < 2 || newbase >  36)
            throw new RuntimeException();
        int integerValue = Integer.parseInt(in, original);
        return Integer.toString(integerValue, newbase);
    }
}
