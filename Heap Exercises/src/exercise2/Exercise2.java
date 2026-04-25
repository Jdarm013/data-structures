package exercise2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercise2 {

    // Hardcoded Strings (countries) - same list used throughout all exercises
    static String[] strings = {"Brazil", "Germany", "Australia", "France", "Japan",
            "Canada", "India", "Mexico", "Spain", "Egypt", "China"};

    public static void main(String[] args) {

        // Min heap - natural alphabetical ordering, no comparator needed
        PriorityQueue<String> minHeap = new PriorityQueue<>();

        // Max heap - custom comparator provided by instructor (Z-A ordering)
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // Add all strings to both heaps
        System.out.println("Adding strings to Min Heap and Max Heap...");
        for (String s : strings) {
            minHeap.add(s);
            maxHeap.add(s);
        }

        // Print the min and max using peek (does not remove)
        System.out.println("\n--- Min Heap peek (alphabetically first): " + minHeap.peek());
        System.out.println("--- Max Heap peek (alphabetically last): " + maxHeap.peek());

        // Print contents of each heap
        System.out.println("\n--- Min Heap contents: " + minHeap);
        System.out.println("--- Max Heap contents: " + maxHeap);

        // Remove the top element from each heap
        System.out.println("\nRemoving top element from each heap...");
        String removedMin = minHeap.remove();
        String removedMax = maxHeap.remove();
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
