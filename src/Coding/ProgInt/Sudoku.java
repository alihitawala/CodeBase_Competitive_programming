package Coding.ProgInt;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 8/1/15.
 */
public class Sudoku {
    private static int count=0;

    public static void main(String[] args) {
        int[][] a = {
                {0,0,0,0,0,0,0,0,0},
                {5,9,3,6,0,0,0,0,0},
                {2,6,8,0,0,0,0,0,0},
                {4,0,1,0,0,0,3,0,0},
                {0,0,0,4,0,0,0,9,2},
                {0,8,0,0,0,0,0,6,0},
                {0,2,0,0,6,1,8,0,5},
                {0,0,0,2,3,0,0,0,1},
                {1,0,0,0,0,8,0,3,0}
        };
        /*int[][] a = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };*/
        solve_optimized(a);
        print(a);
        System.out.println(count);
    }
    private static boolean solve(int[][] a) {
        if (a.length != 9 || a[0].length != 9)
            throw new RuntimeException("Wrong input board!");
        ArrayList<Integer> nextEmptyPlace = nextEmptyIndices(a);
        if (nextEmptyPlace == null)
            return isCorrectBoard(a);
        for (int i=0;i<9;i++) {
            a[nextEmptyPlace.get(0)][nextEmptyPlace.get(1)] = i+1;
            if (solve(a))
                return true;
            else
                i=0;
        }
        return false;
    }

    private static boolean solve_optimized(int[][] a) {
        int[][] statuses = new int[9][9];
        for(int i=0;i<a.length;i++) {
            for (int j=0;j<a.length;j++) {
                statuses[i][j] = a[i][j] > 0 ? 2:  0;
            }
        }
        return solve(a, statuses, 0,0);
    }

    private static boolean solve(int[][] a, int [][] statuses, int x, int y) {
        count++;
        if (x>8)
        {
            int count = 0;
            for (int[] i :a)
                for (int j: i)
                    if (j > 0)
                        count++;
            return count == 81;
        }
        if (statuses[x][y] >= 1) {
            int nextX = x;
            int nextY = y+1;
            if (nextY == 9) {
                nextX++;
                nextY=0;
            }
            return solve(a, statuses, nextX, nextY);
        }
        else {
            boolean[] used = new boolean[9];
            for (int i=0;i<9;i++)
                if (statuses[x][i] > 0)
                    used[a[x][i] -1] = true;

            for (int i=0;i<9;i++)
                if (statuses[i][y] > 0)
                    used[a[i][y] -1] = true;

            for(int i=x-(x%3);i<x-(x%3)+3;i++)
                for(int j=y-(y%3);j<y-(y%3)+3;j++) {
                    if (statuses[i][j] > 0)
                        used[a[i][j] -1 ] = true;
                }
            for (int i=0;i<9;i++) {
                if (!used[i]) {
                    statuses[x][y] = 1;
                    a[x][y] = i+1;
                    int nextX = x;
                    int nextY = y+1;
                    if (nextY == 9) {
                        nextX++;
                        nextY=0;
                    }
                    if (solve(a, statuses, nextX, nextY))
                        return true;
                    for (int m=0;m<9;m++) {
                        for (int n=0;n<9;n++) {
                            if (m>x || (m==x && n>=y))
                                if (statuses[m][n] == 1) {
                                    statuses[m][n] = 0;
                                    a[m][n] = 0;
                                }
                        }
                    }
                }
            }
        }
        return false;
     }

    private static boolean isCorrectBoard(int[][] a) {
        int compare = 0;
        for (int i=0;i<9;i++) {
            compare |= 1<<i;
        }
        int[] groups = new int[9];
        int[] columns = new int[9];
        for (int i=0;i<a.length;i++) {
            int temp = 0;
            for(int j=0;j<a[i].length;j++) {
                temp |= 1<<(a[i][j]-1);
                columns[j] |= 1 << (a[i][j] -1);
                groups[((i/3)*3) + (j/3)] |= 1 << (a[i][j] -1);
            }
            if (temp != compare)
                return false;
        }
        for (int i=0;i<9;i++) {
            if (groups[i] != compare || columns[i] != compare)
                return false;
        }
        return true;
    }

    private static ArrayList<Integer> nextEmptyIndices(int[][] a) {
        for (int i=0;i<a.length;i++)
            for(int j=0;j<a[i].length;j++) {
                if (a[i][j] == 0)
                {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        return null;
    }
    private static void print(int[][] a) {
        for (int[] i : a) {
            for (int j : i)
                System.out.print(j);
            System.out.println();
        }

    }
}
/*
0 1 2 3 4 5 6 7 8
1 0 0 1 1 1 2 2 2
2 0 0 1 1 1 2 2 2
3 3 3 4 4 4 5 5 5
4 3 3 4 4 4 5 5 5
5 3 3 4 4 4 5 5 5
6 6 6 7 7 7 8 8 8
7 6 6 7 7 7 8 8 8
8 6 6 7 7 7 8 8 8

 */