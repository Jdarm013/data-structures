package exercise3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercise3 {

    // Integers
    static int[] numbers = {42, 15, 73, 8, 99, 27, 56, 34, 88, 61, 20};

    // Strings
    static String[] strings = {"Brazil", "Germany", "Australia", "France", "Japan",
            "Canada", "India", "Mexico", "Spain", "Egypt", "China"};

    public static void main(String[] args) {

        // Build integer min heap
        PriorityQueue<Integer> minHeapInt = new PriorityQueue<>();
        for (int num : numbers) {
            minHeapInt.add(num);
        }

        // Build String min heap
        PriorityQueue<String> minHeapStr = new PriorityQueue<>();
        for (String s : strings) {
            minHeapStr.add(s);
        }

        // Print heap contents before polling
        System.out.println("--- Integer Min Heap contents: " + minHeapInt);
        System.out.println("--- String Min Heap contents: " + minHeapStr);

        // Poll integer heap into ArrayList
        ArrayList<Integer> intList = new ArrayList<>();
        while (!minHeapInt.isEmpty()) {
            intList.add(minHeapInt.poll());
        }

        // Poll String heap into ArrayList
        ArrayList<String> strList = new ArrayList<>();
        while (!minHeapStr.isEmpty()) {
            strList.add(minHeapStr.poll());
        }

        // Print the resulting ArrayLists
        System.out.println("\n--- Integer ArrayList: " + intList);
        System.out.println("--- String ArrayList: " + strList);

    }
}