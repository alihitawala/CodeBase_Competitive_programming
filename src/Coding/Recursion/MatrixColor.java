package Coding.Recursion;

import java.util.Scanner;

/**
 * Created by aliHitawala on 6/13/15.
 */
public class MatrixColor {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int a[][] = new int[r][c];
        for (int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                a[i][j] = in.nextInt();
            }
        }
        color(r,c,a);
        for (int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    private static void color(int r, int c, int[][] a) {
        int color = 1;
        for (int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if (a[i][j] == 0) {
                    color++;
                    allDirectionRecursion(a, i, j, color);
                }
            }
        }
    }

    private static void allDirectionRecursion(int[][] a, int i, int j, int color) {
        int r = a.length;
        int c = a[0].length;
        _color(a, r, c, i-1, j, color);
        _color(a, r, c, i, j-1, color);
        _color(a, r, c, i+1, j, color);
        _color(a, r, c, i, j+1, color);
    }

    private static void _color(int[][] a, int r, int c, int i, int j, int color) {
        count++;
        if (i<0 || i>=r || j<0 || j>=c) return;
        if (a[i][j] == 0537 ) {
            a[i][j] = color;
            allDirectionRecursion(a,i,j,color);
        }
    }
}
