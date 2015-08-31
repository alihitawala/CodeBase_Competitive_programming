package Coding.IBit.Backtraking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 8/30/15.
 */
public class Sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> a = new ArrayList<String>();
        for(int j=0;j<n;j++){
            String x =in.next();
            a.add(x);
        }
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            char[] chars = s.toCharArray();
            ArrayList<Character> charList = new ArrayList<>();
            for (int j=0;j<chars.length;j++) {
                char c = chars[j];
                charList.add(c);
            }
            list.add(charList);
        }
        solveSudoku(list);
        System.out.println(list);
    }

    public static void solveSudoku(ArrayList<ArrayList<Character>> board) {
        if(board.size()<9 || board.get(0).size()<9) return;
        solSudoku(board, 0, 0);
    }

    static boolean solSudoku(ArrayList<ArrayList<Character>> board, int irow, int icol) {
        if(irow==9) return true;

        int irow2, icol2;
        if(icol==8) {
            irow2 = irow+1;
            icol2 = 0;
        }
        else {
            irow2 = irow;
            icol2 = icol+1;
        }

        if(board.get(irow).get(icol) != '.') {
            if(!isValid(board, irow, icol)) return false;
            return solSudoku(board, irow2, icol2);
        }

        for(int i=1; i<=9; i++) {
            board.get(irow).set(icol, (char)('0'+i));
            if(isValid(board, irow, icol) && solSudoku(board, irow2, icol2)) return true;
        }

        // reset grid
        board.get(irow).set(icol, '.');
        return false;
    }

    static boolean isValid(ArrayList<ArrayList<Character>> board, int irow, int icol) {
        char val = board.get(irow).get(icol);
        if(val-'0'<1 || val-'0'>9) return false;

        // check row & col
        for(int i=0; i<9; i++) {
            if(board.get(irow).get(i)==val && i!=icol) return false;
            if(board.get(i).get(icol)==val && i!=irow) return false;
        }

        //check 3x3 box
        int irow0 = irow/3*3;
        int icol0 = icol/3*3;
        for(int i=irow0; i<irow0+3; i++) {
            for(int j=icol0; j<icol0+3; j++) {
                if(board.get(i).get(j)==val && (i!=irow || j!=icol)) return false;
            }
        }
        return true;
    }
}
