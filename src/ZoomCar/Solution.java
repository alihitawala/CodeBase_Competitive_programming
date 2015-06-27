package ZoomCar;

import java.util.*;

/**
 * Created by aliHitawala on 6/6/15.
 */
public class Solution {
    public static final long MOD= 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numProfs = in.nextInt();
        Professor[] profs = new Professor[numProfs];
        for (int i=0;i<numProfs;i++) {
            int numCourse = in.nextInt();
            int coursesValue[] = new int[numCourse];
            for (int j=0;j<numCourse;j++) {
                coursesValue[j] = in.nextInt();
            }
            profs[i] = new Professor(numCourse, coursesValue);
        }

        double merge = 1;
        for (int i=0;i<numProfs;i++) {
            Arrays.sort(profs[i].getCourseValues());
            setAllPermutations(profs[i]);
//            System.out.println(profs[i]);
            if (i!=0 )
            {
                Professor p1 = profs[i-1];
                int course1 = p1.getNumCourse();
                Professor p2 = profs[i];
                int course2 = p2.getNumCourse();
                merge = (merge * combi(course1+course2, course1))%MOD;
                profs[i].setNumCourse(course1+course2);
            }
            merge = (merge * profs[i].permutations) % MOD;
        }
        System.out.println(new Double(merge).intValue());
    }

    private static void setAllPermutations(Professor professor) {
        Map<Integer, Integer> map = getMapValue(professor.getCourseValues());
        long freqIndex = 1;
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,Integer> entry = it.next();
            long freq = entry.getValue();
            long factorial = factorial(freq);
            freqIndex = (freqIndex * factorial)%MOD;
        }
        professor.setPermutations(freqIndex);
    }

    private static long factorial(long freq) {
        long result = 1;
        long multiplier = 1;
        for (int i=0;i<freq;i++)
        {
            result= (result * multiplier)%MOD;
            multiplier++;
        }
        return result;
    }

    private static Map<Integer, Integer> getMapValue(int[] courseValues) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i=0;i<courseValues.length;i++) {
            if (result.containsKey(courseValues[i])) {
                result.put(courseValues[i], result.get(courseValues[i])+1);
            }
            else
            {
                result.put(courseValues[i], 1);
            }
        }
        return result;
    }

    private static double combi(int n,int k)
    {
        double ans=1;
        k=k>n-k?n-k:k;
        int j=1;
        for(;j<=k;j++,n--)
        {
            if(n%j==0)
            {
                ans = (ans * n/j) %MOD;
            }else
            if(ans%j==0)
            {
                ans=ans/ j*n;
            }else
            {
                ans=(ans*n)/j;
            }
        }
        return ans;
    }

    static class Professor {
        int numCourse;
        int[] courseValues;
        long permutations;

        Professor(int numCourse, int[] courseValues) {
            this.numCourse = numCourse;
            this.courseValues = courseValues;
        }

        public long getPermutations() {
            return permutations;
        }

        public void setPermutations(long permutations) {
            this.permutations = permutations;
        }

        public int[] getCourseValues() {
            return courseValues;
        }

        public void setCourseValues(int[] courseValues) {
            this.courseValues = courseValues;
        }

        public int getNumCourse() {
            return numCourse;
        }

        public void setNumCourse(int numCourse) {
            this.numCourse = numCourse;
        }

        @Override
        public String toString() {
            return "Professor{" +
                    "numCourse=" + numCourse +
                    ", courseValues=" + Arrays.toString(courseValues) +
                    ", permutations=" + permutations +
                    '}';
        }
    }

}
/*
2
2 1 2
2 1 2
 */