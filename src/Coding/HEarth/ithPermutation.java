package Coding.HEarth;

/**
 * Created by aliHitawala on 10/11/15.
 */
public class ithPermutation {
    /**
     * @param n The number of entries
     * @param i The index of the permutation
     */
    // http://stackoverflow.com/questions/7918806/finding-n-th-permutation-without-computing-others
    public static void getNthPermutations(int n, long i) {
        int j, k = 0;
        long[] fact = new long[n];
        long[] perm = new long[n];

        fact[k] = 1;
        while (++k < n)
            fact[k] = fact[k - 1] * k;

        for (k = 0; k < n; ++k)
        {
            perm[k] = i / fact[n - 1 - k];
            i = i % fact[n - 1 - k];
        }

        for (k = n - 1; k > 0; --k)
            for (j = k - 1; j >= 0; --j)
                if (perm[j] <= perm[k])
                    perm[k]++;

        // print permutation
        for (k = 0; k < n; ++k)
            System.out.print(perm[k] + " ");
    }
}
