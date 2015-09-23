package Coding.IBit.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 9/22/15.
 */
public class Max3N {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            ArrayList<Integer> A = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int a = in.nextInt();
                A.add(a);
            }
            System.out.println(new Max3N().maxp3(A));
        }
    }

    public int maxp3(ArrayList<Integer> a) {
        if (a.size() < 3)
            return 0;
        if (a.size() == 3)
            return a.get(0) *a.get(1) *a.get(2);
        ArrayList<Integer> three = max3Positive(a);
        ArrayList<Integer> two = min2Negative(a);
        ArrayList<Integer> threeN = max3Negative(a);
        //case 1 all negative
        if (three.isEmpty())
            return threeN.get(0)*threeN.get(1)*threeN.get(2);
        if (three.size() < 3)
            return three.get(0) * two.get(0) * two.get(1);
        if (three.size() == 3 && two.size() == 2)
            return Math.max(three.get(0) * two.get(0) * two.get(1), three.get(0)* three.get(1)*three.get(2));
        if (three.size() == 3)
            return three.get(0)* three.get(1)*three.get(2);
        return 0;
    }

    private ArrayList<Integer> max3Negative(ArrayList<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : _max3Negative(a)) {
            if(integer != Integer.MIN_VALUE) {
                list.add(integer);
            }
        }
        return list;
    }
    private int[] _max3Negative(ArrayList<Integer> a) {
        int[] result = new int[3];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;
        for (Integer i : a) {
            if (i < 0) {
                if (i > result[0]) {
                    result[2] = result[1];
                    result[1] = result[0];
                    result[0] = i;
                } else if (i > result[1]) {
                    result[2] = result[1];
                    result[1] = i;
                } else if (i > result[2])
                    result[2] = i;
            }
        }
        return result;
    }

    private ArrayList<Integer> min2Negative(ArrayList<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : _min2Negative(a)) {
            if(integer != Integer.MAX_VALUE) {
                list.add(integer);
            }
        }
        return list;
    }
    private int[] _min2Negative(ArrayList<Integer> a) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MAX_VALUE;
        for (Integer i : a) {
            if (i < 0) {
                if (i < result[0]) {
                    result[1] = result[0];
                    result[0] = i;
                } else if (i < result[1]) {
                    result[1] = i;
                }
            }
        }
        return result;
    }

    private ArrayList<Integer> max3Positive(ArrayList<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : _max3Positive(a)) {
            if(integer != Integer.MIN_VALUE) {
                list.add(integer);
            }
        }
        return list;
    }
    private int[] _max3Positive(ArrayList<Integer> a) {
        int[] result = new int[3];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;
        for (Integer i : a) {
            if (i >= 0) {
                if (i > result[0]) {
                    result[2] = result[1];
                    result[1] = result[0];
                    result[0] = i;
                } else if (i > result[1]) {
                    result[2] = result[1];
                    result[1] = i;
                } else if (i > result[2])
                    result[2] = i;
            }
        }
        return result;
    }
}
