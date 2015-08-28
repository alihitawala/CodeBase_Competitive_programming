package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class LSZero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            a.add(x);
        }
        System.out.println(lszero(a));
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> a) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        ArrayList<Integer> result;
        int sumLeft = 0;
        numToIndex.put(0,-1);
        int maxLeft =0, maxRight=0,maxDistance=-1;
        for (int i=0;i<a.size();i++) {
            int x = a.get(i);
            sumLeft += x;
            if (numToIndex.containsKey(sumLeft)) {
                int k = numToIndex.get(sumLeft);
                int dist = i-k;
                if (dist > maxDistance) {
                    maxLeft = k;
                    maxRight=i;
                    maxDistance = dist;
                }
            }
            else {
                numToIndex.put(sumLeft, i);
            }
        }
        result = new ArrayList<>(a.subList(maxLeft+1, maxRight+1));
        return result;
    }
}
