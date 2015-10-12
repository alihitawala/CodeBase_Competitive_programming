package Coding.HEarth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/11/15.
 */
public class KnightsMove {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        Pair board = new Pair(i,j);
        int starti = in.nextInt();
        int startj = in.nextInt();
        Pair start = new Pair(starti,startj);
        int endi = in.nextInt();
        int endj = in.nextInt();
        Pair end = new Pair(endi,endj);
        int blockLen = in.nextInt();
        HashMap<Pair, Boolean> blockedMap = new HashMap<Pair, Boolean>();
        for(int l = 0 ; l<blockLen;l++) {
            int m = in.nextInt();
            int n = in.nextInt();
            Pair k = new Pair(m,n);
            blockedMap.put(k, true);
        }
        System.out.println(solve(board, start, end, blockedMap));
    }


    private static int solve(Pair b, Pair start, Pair end, HashMap<Pair, Boolean> map) {
        LinkedList<Pair> q = new LinkedList<Pair>();
        int[][] board = new int[b.i][b.j];
        q.add(start);
        board[start.i][start.j] = 1;
        Pair[] aux = getAux();
        while (!q.isEmpty()) {
            Pair current = q.remove();
            for (int i=0;i<8;i++) {
                Pair a = aux[i];
                if (current.i+a.i >= 0 && current.i+a.i < b.i && current.j+a.j >= 0 && current.j+a.j <b.j &&
                        board[current.i+a.i][current.j+a.j] == 0) {
                    Pair temp = new Pair(current.i + a.i, current.j+a.j);
                    if (map.containsKey(temp))
                        continue;
                    if (temp.equals(end))
                        return board[current.i][current.j];
                    board[current.i+a.i][current.j+a.j] = board[current.i][current.j] +1;
                    q.add(new Pair(current.i+a.i, current.j+ a.j));
                }
            }
        }
        return 0;
    }
    private static Pair[] getAux() {
        Pair[] result = new Pair[8];
        Pair p = new Pair(2,-1);
        result[0] = p;
        p = new Pair(2,1);
        result[1] = p;
        p = new Pair(1,-2);
        result[2] = p;
        p = new Pair(1,2);
        result[3] = p;
        p = new Pair(-2,-1);
        result[4] = p;
        p = new Pair(-2,1);
        result[5] = p;
        p = new Pair(-1,-2);
        result[6] = p;
        p = new Pair(-1,2);
        result[7] = p;
        return result;
    }
    static class Pair{
        int i,j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair)o;
            return this.i == p.i && this.j == p.j;
        }

        @Override
        public int hashCode(){
            return this.i * 71 + this.j;
        }
    }
}
