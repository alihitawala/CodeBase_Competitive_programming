package Coding.IBit.Math;

/**
 * Created by aliHitawala on 9/16/15.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().pow(-3,3));
        System.out.println(Math.pow(3,5));
    }

    public double pow(double a, double b) {
        if (a == 0 && b == 0)
            return Double.POSITIVE_INFINITY;
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;
        if (b == 1)
            return a;
        boolean aNegative = a < 0;
        boolean bNegative = b < 0;
        a = Math.abs(a);
        b = Math.abs(b);
        int mid = (int)b/2;
        double pow = pow(a, mid);
        double answer = b %2 == 0 ? pow * pow : pow * pow * a;
        answer = bNegative ? 1/answer : answer;
        answer = aNegative && b%2!=0 ? -answer : answer;
        return answer;
    }
}
