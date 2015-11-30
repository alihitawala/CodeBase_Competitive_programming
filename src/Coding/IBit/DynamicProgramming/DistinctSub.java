package Coding.IBit.DynamicProgramming;

/**
 * Created by aliHitawala on 10/25/15.
 */
public class DistinctSub {
    public static void main(String[] args) {
        System.out.println(new DistinctSub().numDistinct("rabbbit","rabbit"));
    }
    public int numDistinct(String P, String T) {
        char[] a = P.toCharArray();
        char[] d = T.toCharArray();
        Node[][] cache = new Node[d.length+1][a.length+1];
        for (int i=0;i<cache.length;i++) {
            for(int j=0;j<cache[0].length;j++) {
                if (i==0||j==0) {
                    cache[i][j] = new Node(0,0);
                    continue;
                }
                if (d[i-1] == a[j-1]) {
                    int prevNum = cache[i-1][j-1].num;
                    int prevLoad = cache[i-1][j-1].load;
                    int currentNum = prevNum+1;
                    int currentLoad = cache[i][j-1].load;
                    if (currentNum >= i) {
                        int temp = cache[i][j-1].load;
                        if (i==1)
                            temp++;
                        currentLoad = prevLoad + temp;
                    }
                    cache[i][j] = new Node(currentNum, currentLoad);
                }
                else if (cache[i-1][j].num > cache[i][j-1].num)
                    cache[i][j] = new Node(cache[i-1][j].num, cache[i][j-1].load);
                else
                    cache[i][j] = new Node(cache[i][j-1].num, cache[i][j-1].load);
            }
        }
        return cache[d.length][a.length].load;
    }

    static class Node {
        int num;
        int load;
        public Node(int n, int l){
            this.num = n;
            this.load = l;
        }
    }
}
