/**
 * Created by aliHitawala on 9/30/15.
 */
public class SumTwo {
    public static int sumTwo(int[] a) {
        if (a == null || a.length <= 1) {
            throw new RuntimeException("Array's size is less than 2");
        }
        int largest = Math.max(a[0], a[1]);
        int secondLargest = Math.min(a[0], a[1]);
        for(int i=2;i<a.length;i++) {
            if (a[i] > secondLargest) {
                secondLargest = a[i];
                if (secondLargest > largest) {
                    int temp = largest;
                    largest = secondLargest;
                    secondLargest= temp;
                }
            }
        }
        return secondLargest + largest;
    }
}
