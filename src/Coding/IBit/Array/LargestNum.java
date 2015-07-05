package Coding.IBit.Array;

import java.util.*;

/**
 * Created by aliHitawala on 6/25/15.
 */
public class LargestNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            List<Integer> a = new ArrayList<Integer>();
            for (int j=0;j<n;j++) {
                a.add(in.nextInt());
            }
            System.out.println(solve(a));
        }
    }

    private static String solve(List<Integer> a) {
        List<String> s = new ArrayList<String>();
        for (int i : a) {
            s.add(String.valueOf(i));
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        };
        Collections.sort(s,cmp);
        StringBuilder answer = new StringBuilder("");
        boolean isZero = true;
        for (String x : s) {
            if (Integer.parseInt(x) != 0) isZero = false;
            answer.append(x);
        }
        return isZero ? "0" : answer.toString();
    }
}
//9879799739609479359359191589688868778668588578578568448248027857797735733703692692691686596565364663463361060959759158758657957751749249148948484804764734644614574464434344324204043833723643513433531731231030528826825725624824722092031921701391241161
//9879799739609479359359191589688688778668588578578568448248027857797735733703692692691686596565364663463361060959759158758657957751749249148948484804764734644614574464434344324204043833723643513433531731231030528826825725624824722092031921701391241161

//688868
//688688