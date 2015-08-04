package Coding.ProgInt;

/**
 * Created by aliHitawala on 7/31/15.
 */
public class StepClimbing {
    public static void main(String[] args) {
        int i = 10;
        System.out.print(numberOfWays(i));
    }

    private static int numberOfWays(int steps) {
        if (steps < 0)
            throw new RuntimeException("Negative values not allowed");
        if (steps == 0 || steps == 1)
            return 1;
        if (steps == 2)
            return 2;
        int one = 1, two=1, three = 2;
        int answer = 0;
        while (steps > 2) {
            answer = one + two + three;
            one = two;
            two = three;
            three = answer;
            steps--;
        }
        return answer;
    }
}
