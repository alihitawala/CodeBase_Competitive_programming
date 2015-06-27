package Coding.CodeChef.Dungeon;

/**
 * Created by aliHitawala on 1/31/15.
 */
public class Solution
{
    private Integer[][] cache;
    public static void main(String[] args) {
        int[][] dungeon =
//                {{-3,5}};
//                {
//                {2,1},
//                {1,-1}};
                {
                        {-2,-3,3},
                        {-5,-10,1},
                        {10,30,-5}
                };
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
    public int calculateMinimumHP(int[][] dungeon)
    {
        cache = new Integer[dungeon.length][dungeon[0].length];
        int result = calculate(dungeon, 0, 0);
        return result+1;
    }

    private int calculate(int[][] dungeon, int x, int y)
    {
        int result;
        if (cache[x][y] != null)
        {
            result = cache[x][y];
        }
        else
        {
            int value = dungeon[x][y];
            if (x == dungeon.length-1 && y == dungeon[0].length -1)
            {
                result = 0;
            }
            else if (x == dungeon.length-1)
            {
                result = calculate(dungeon, x, y+1);
            }
            else if (y == dungeon[0].length-1)
            {
                result = calculate(dungeon, x+1, y);
            }
            else
            {
                result = Math.min(calculate(dungeon, x+1, y),
                        calculate(dungeon, x, y+1));
            }
            int temp = result - value;
            result = temp <= 0 ? 0 : temp;
            cache[x][y] = result;
        }
        return result;
    }
}
