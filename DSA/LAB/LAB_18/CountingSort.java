import java.util.Arrays;

public class CountingSort {

    // Function to implement Counting Sort
    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Find the maximum value in the array to determine the range
        int max = Arrays.stream(arr).max().getAsInt();

        // Create a count array to store the count of each unique object
        int[] count = new int[max + 1];

        // Store the count of each number in the count array
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Modify the count array such that each element at each index stores the sum of the previous counts
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Output array that will store the sorted array
        int[] output = new int[n];

        // Build the output array by placing elements at their correct positions
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main method to test the Counting Sort implementation
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1, 5};

        System.out.println("Unsorted array: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
