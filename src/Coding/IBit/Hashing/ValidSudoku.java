package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        System.out.println(isValidSudoku(a));
    }

    public static int isValidSudoku(final List<String> a) {
        int[][] ar = new int[9][9];
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            char[] chars = s.toCharArray();
            for (int j=0;j<chars.length;j++) {
                char c = chars[j];
                ar[i][j] = c == '.' ? 0 : c - '0';
            }
        }
        HashMap<Integer, Integer> mapRow = new HashMap<>();
        HashMap<Integer, Integer> mapCol = new HashMap<>();
        ArrayList<HashMap<Integer,Integer>> groupMap = new ArrayList<>();
        groupMap.add(new HashMap<Integer, Integer>());
        groupMap.add(new HashMap<Integer, Integer>());
        groupMap.add(new HashMap<Integer, Integer>());
        for (int i=0;i<9;i++) {
            if (i % 3 == 0) {
                groupMap.get(0).clear();
                groupMap.get(1).clear();
                groupMap.get(2).clear();
            }
            for (int j=0;j<9;j++) {
                int row = ar[i][j];
                int col = ar[j][i];
                if (row != 0) {
                    HashMap<Integer, Integer> map = groupMap.get(j/3);
                    if (mapRow.containsKey(row) || map.containsKey(row))
                        return 0;
                    else {
                        mapRow.put(row, row);
                        map.put(row, row);
                    }
                }
                if (col != 0) {
                    if (mapCol.containsKey(col))
                        return 0;
                    else
                        mapCol.put(col, col);
                }
            }
            mapCol.clear();
            mapRow.clear();
        }
        return 1;
    }
}
