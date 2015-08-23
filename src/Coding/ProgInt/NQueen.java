package Coding.ProgInt;

/**
 * Created by aliHitawala on 8/5/15.
 */
public class NQueen {
    private static int count=1;

    public static void main(String[] args) {
        solve(5);
    }

    private static void solve(int boardSize) {
        int[][] board = new int[boardSize][boardSize];
        _solve(board, 0, boardSize);
    }

    private static void printBoard(int[][]a, int N) {
        System.out.println(count++);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (a[i][j] == i+1) {
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static void _solve(int[][] board, int row, int N) {
        if (row==N) {
            printBoard(board, N);
        }
        else {
            for (int i=0;i<N;i++) {
                if (board[row][i] == 0) {
                    board[row][i] = row+1;
                    invalidatePositionsOnBoard(board, row, i, N);
                    _solve(board, row+1, N);
                    board[row][i]=0;
                    removeInvalidatePosition(board, row, N);
                }
            }
        }
    }

    private static void removeInvalidatePosition(int[][] board, int row, int N) {
        for (int i=row+1;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (board[i][j] >= row+1 || board[i][j] <= -(row+1))
                    board[i][j]=0;
            }
        }
    }

    private static void invalidatePositionsOnBoard(int[][] board, int row, int column, int N) {
        int blockNumber = -(row+1);
        for (int i=row+1;i<N;i++) {
            if (board[i][column] == 0)
                board[i][column] = blockNumber;
            int gap = i-row;
            if (column-gap >=0 && board[i][column-gap] == 0)
                board[i][column-gap] = blockNumber;
            if (column+gap < N && board[i][column+gap] == 0)
                board[i][column+gap] = blockNumber;
        }
    }
}
