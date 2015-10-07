/**
 * Created by aliHitawala on 9/30/15.
 */
public class Apigee2 {
    public static void main(String[] args) {
        int[][] a = {
                {0,1,1},
                {0,0,1},
                {0,0,0}
        };
        new Apigee2().printPath(a);
        /*
        Output for this test case is :

        Path 1: (0 0)(1 0)(2 0)(2 1)(2 2)
        Path 2: (0 0)(1 0)(1 1)(2 1)(2 2)

        */
    }
    private boolean[][] isVisited;
    //this can be reduced to O(n) using the arrayList as discussed. Keeping the same implementation as showed during the interview.
    Cell[][] toPath;
    private int count = 1;

    public void printPath(int[][] a) {
        //assumption nXn
        isVisited = new boolean[a.length][a.length];
        toPath = new Cell[a.length][a.length];
        dfs(a, 0, 0, 0, 0);
    }

    private void dfs(int[][] a, int i, int j, int comingFromI, int comingFromJ) {
        //return if the index is out of bound or if already visited or the array element is not 0.
        if (i < 0 || i >= a.length || j < 0 || j >= a.length || isVisited[i][j] || a[i][j] != 0)
            return;
        //store the index from where are you coming from
        toPath[i][j] = new Cell(comingFromI, comingFromJ);
        //if you have reached the destination print the answer
        if (i == a.length-1 && j == a.length-1)
        {
            print (toPath);
        }
        //dfs calls to up/left/down/right
        isVisited[i][j] = true;
        dfs(a, i-1, j, i,j);
        dfs(a, i, j-1,i,j);
        dfs(a, i+1, j,i,j);
        dfs(a, i, j +1,i,j);
        isVisited[i][j] = false;
    }

    private void print(Cell[][] toPath) {
        int len = toPath.length;
        System.out.print("Path " + count++ + ": ");
        //printing the path in bottom up manner.
        printBottomUp(toPath, len - 1, len - 1);
        System.out.println();
    }

    private void printBottomUp(Cell[][] toPath, int i, int j) {
        if (i == 0 && j == 0)
        {
            System.out.print("(" + i + " " + j + ")");
            return;
        }
        printBottomUp(toPath, toPath[i][j].i, toPath[i][j].j);
        System.out.print("(" + i + " " + j + ")");
    }

    static class Cell {
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
