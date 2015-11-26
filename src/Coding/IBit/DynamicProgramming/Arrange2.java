package Coding.IBit.DynamicProgramming;

/**
 * Created by aliHitawala on 10/29/15.
 */
public class Arrange2 {
    public static void main(String[] args) {
        System.out.println(new Arrange2().arrange("WWWB", 2));
    }
    public int arrange(String a, int b) {
        return recursive(a, 0, b, 1);
    }

    private int recursive(String a, int horse, int b, int stable) {
        if (stable > b || horse >= a.length()) {
            return Integer.MAX_VALUE;
        }
        int answer = Integer.MAX_VALUE;
        for (int i=horse;i<a.length()-(b-stable)+1;i++)
        {
            int temp = getValue(a, horse, i);
            int t = recursive(a, horse+i,b,stable+1) +temp;
            if (t < answer)
                answer = t;

        }
        return answer;
    }

    private int getValue(String a, int start, int end) {
        int w=0,b=0;
        for (int i=start;i<=end;i++)
        {
            if (a.charAt(i) == 'W')
                w++;
            else
                b++;
        }
        return w*b;
    }
}
