import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // Function to sort the array using bucket sort
    public static void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        // Create n empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]); // Index in bucket
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into the original array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Main method to test the Bucket Sort implementation
    public static void main(String[] args) {
        float[] arr = { (float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665, (float) 0.3434 };
        int n = arr.length;

        System.out.println("Unsorted array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        bucketSort(arr, n);

        System.out.println("\nSorted array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
