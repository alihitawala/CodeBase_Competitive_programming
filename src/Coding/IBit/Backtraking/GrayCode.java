package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/27/15.
 */
public class GrayCode {
    /*

	public ArrayList<Integer> grayCode(int a) {
	}
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j=0;j<n;j++){
            int x =in.nextInt();
            System.out.println(grayCode(x));
        }
    }

    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<n;i++){
            int size = arr.size();
            for(int j=size-1;j>=0;j--){
                arr.add(arr.get(j)+size);
            }
        }
        return arr;
    }
}
