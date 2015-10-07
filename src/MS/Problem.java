package MS;

import java.util.*;

/**
 * Created by aliHitawala on 9/30/15.
 */
public class Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int n = in.nextInt();
            ArrayList<ProblemDef> defs = new ArrayList<>();
            for (int j = 0; j < 33; j++) {
                String s = in.next();
                StringTokenizer token = new StringTokenizer(s,",");
                int id = Integer.parseInt(token.nextToken());
                int score = Integer.parseInt(token.nextToken());
                int duration = Integer.parseInt(token.nextToken());
                defs.add(new ProblemDef(id, score, duration));
            }
            solve(n, defs);
        }
    }

    private static void solve(int n, ArrayList<ProblemDef> problemDefs) {
        Collections.sort(problemDefs, new Comparator<ProblemDef>() {
            @Override
            public int compare(ProblemDef o1, ProblemDef o2) {
                return o2.score*(o2.score/o2.duration) - o1.score*(o1.score/o1.duration) ;
            }
        });
        int[][] knap = new int[problemDefs.size() +1][n +1];
        int[][] knapIndex = new int[problemDefs.size() +1][n +1];
        for (int i = 0; i < problemDefs.size() +1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i==0||j==0)
                    knap[i][j] = 0;
                else if(problemDefs.get(i-1).duration <= j) {
                    if (problemDefs.get(i - 1).score + knap[i - 1][j - problemDefs.get(i - 1).duration] > knap[i - 1][j]) {
                        knap[i][j] = problemDefs.get(i - 1).score + knap[i - 1][j - problemDefs.get(i - 1).duration];
                        knapIndex[i][j] = problemDefs.get(i - 1).id;
                    }
                    else
                        knap[i][j] = knap[i - 1][j];
                }
                else {
                    knap[i][j] = knap[i - 1][j];
                }
            }
        }
        int result = knap[problemDefs.size()][n];
        ArrayList<Integer> p = indexInvolved(problemDefs, knapIndex);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : p) {
            map.put(i, i);
        }
        int totalW = 0;
        for (int i = 0; i < p.size(); i++) {
            int x = problemDefs.get(p.get(i)).duration;
            totalW += x;
        }
        int wRemaining = n - totalW;
        int partial = -1;
        for (int i = 0; i < problemDefs.size(); i++) {
            if (!map.containsKey(i)) {
                ProblemDef def = problemDefs.get(i);
                int value = wRemaining*def.score/def.duration;
                result += value;
                partial = i;
                break;
            }
        }
        System.out.println(result);
        System.out.print(partial+1 + "*");
        for(int i : p) {
            i = i+1;
            System.out.print(", " + i);
        }
        System.out.println();
    }

    private static ArrayList<Integer> indexInvolved(ArrayList<ProblemDef> problemDefs, int[][] knapIndex) {
        ArrayList<Integer> a = new ArrayList<>();
        int j = knapIndex[0].length-1;
        for (int i = knapIndex.length-1; i>= 0; i--) {
            if (knapIndex[i][j] == 0)
                break;
            a.add(knapIndex[i][j] - 1);
            ProblemDef def = problemDefs.get(knapIndex[i][j] - 1);
            j = j - def.duration;
        }
        return a;
    }


    static class ProblemDef{
        int id;
        int score;
        int duration;

        public ProblemDef(int id, int score, int duration) {
            this.id = id;
            this.score = score;
            this.duration = duration;
        }
    }
}
