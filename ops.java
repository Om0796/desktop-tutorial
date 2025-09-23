import java.util.*;

public class ops {
    // Swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Optimized bubble sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // If no two elements were swapped, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of files: ");
        int num = sc.nextInt();

        int[] sizes = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter the size of File " + (i + 1) + ": ");
            sizes[i] = sc.nextInt();
        }

        // Step 1: Sort file sizes
        bubbleSort(sizes);

        // Step 2: Calculate cumulative retrieval times
        int[] retrievalTimes = new int[num];
        retrievalTimes[0] = sizes[0];
        for (int i = 1; i < num; i++) {
            retrievalTimes[i] = retrievalTimes[i - 1] + sizes[i];
        }

        // Step 3: Compute Mean Retrieval Time
        float totalRetrievalTime = 0;
        for (int time : retrievalTimes) {
            totalRetrievalTime += time;
        }

        float meanRetrievalTime = totalRetrievalTime / num;

        // Step 4: Display results
        System.out.println("\nSorted File Sizes: " + Arrays.toString(sizes));
        System.out.println("Retrieval Times: " + Arrays.toString(retrievalTimes));
        System.out.printf("The Mean Retrieval Time is %.2f%n", meanRetrievalTime);

        sc.close();
    }
}
