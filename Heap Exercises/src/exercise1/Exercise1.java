package exercise1;

import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise1 {

    // Hardcoded integers - same list used throughout all exercises
    static int[] numbers = {42, 15, 73, 8, 99, 27, 56, 34, 88, 61, 20};

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all numbers to both heaps
        System.out.println("Adding numbers to Min Heap and Max Heap...");
        for (int num : numbers) {
            minHeap.add(num);
            maxHeap.add(num);
        }

        // Print the min and max using peek (does not remove)
        System.out.println("\n--- Min Heap peek (minimum value): " + minHeap.peek());
        System.out.println("--- Max Heap peek (maximum value): " + maxHeap.peek());

        // Print contents of each heap
        System.out.println("\n--- Min Heap contents: " + minHeap);
        System.out.println("--- Max Heap contents: " + maxHeap);

        // Remove the top element from each heap
        System.out.println("\nRemoving top element from each heap...");
        int removedMin = minHeap.remove();
        int removedMax = maxHeap.remove();
        System.out.println("Removed from Min Heap: " + removedMin);
        System.out.println("Removed from Max Heap: " + removedMax);

        // Print contents after removal
        System.out.println("\n--- Min Heap contents after removal: " + minHeap);
        System.out.println("--- Max Heap contents after removal: " + maxHeap);

        // Add the removed items back
        System.out.println("\nAdding removed items back to each heap...");
        minHeap.add(removedMin);
        maxHeap.add(removedMax);

        // Print contents after adding back
        System.out.println("\n--- Min Heap contents after adding back: " + minHeap);
        System.out.println("--- Max Heap contents after adding back: " + maxHeap);

        // Use peek to confirm top element without modifying
        System.out.println("\n--- Min Heap peek after restore: " + minHeap.peek());
        System.out.println("--- Max Heap peek after restore: " + maxHeap.peek());
    }
}