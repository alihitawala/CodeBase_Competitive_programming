package Coding.ProgInt.Bloom;

import java.util.Scanner;

/**
 * Created by aliHitawala on 9/20/15.
 */
public class Bishop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bishopPosition = in.nextInt();
        int target = in.nextInt();
        System.out.println(solve(bishopPosition, target));
    }

    private static int solve(int bishopPosition, int target) {
        if (bishopPosition > 64 || bishopPosition < 1 || target > 64 || target < 1)
            throw new RuntimeException();
        if (bishopPosition == target)
            return 0;
        if (isNotPossible(bishopPosition, target)) {
            return -1;
        }
        if (isDiagonallyPositioned(bishopPosition, target)) {
            return 1;
        }
        return 2;
    }

    private static boolean isDiagonallyPositioned(int bishopPosition, int target) {
        int brow = (bishopPosition-1) / 8;
        int trow = (target-1) / 8;
        if (brow == trow)
            return false;
        if (brow > trow) {
            int temp = brow;
            brow = trow;
            trow = temp;
        }
        int diff = trow - brow;
        if (target == (bishopPosition + (8*diff) + diff) || (bishopPosition + (8*diff) - diff) == target)
            return true;
        return false;
    }

    private static boolean isNotPossible(int bishopPosition, int target) {
        int brow = (bishopPosition-1) / 8;
        int trow = (target-1) / 8;
        boolean isBlackBishop = false;
        boolean isBlackTarget = false;
        if (bishopPosition % 2 != 0 && brow %2 ==0 || (bishopPosition % 2 == 0 && brow %2 !=0))
            isBlackBishop = true;
        if (target % 2 != 0 && trow %2 ==0 || (target % 2 == 0 && trow %2 !=0))
            isBlackTarget = true;
        return isBlackBishop == !isBlackTarget;
    }
}
