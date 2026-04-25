import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

//outer class to encapsulate logic
public class ArrayShuffle {

    //initializing arrays
    int[] intArray = new int[10];
    String[] stringArray = new String[10];

    //Integer array interface code
    public void testArrayInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an array of Integers.");
        System.out.println("Starting Integer array.");

        String prompt = "";
        do {
            System.out.print("Choose your operation: add(a),delete(d), shuffle(m),sort(s), print(p), quit(q): ");
            prompt = scanner.nextLine();
            switch (prompt) {
                case "a" -> addIntArray();
                case "d" -> delIntArray();
                case "m" -> shuffleIntArray(intArray);
                case "s" -> sortIntArray(intArray);
                case "p" -> printIntArray(intArray);
                case "q" -> {
                    break;
                }
            }
        }
        while (!prompt.equals("q"));
    }
    //method to print from array
    public void printIntArray(int[] intArray) {

        System.out.println(Arrays.toString(intArray));
    }

    //method to sort array
    public void sortIntArray(int[] intArray) {
        Arrays.sort(intArray);
        System.out.println("Sorted Array"+Arrays.toString(intArray));
    }
    //method to shuffle array
    public void shuffleIntArray(int[] intArray) {

        // Shuffle the array using Fisher-Yates algorithm
        Random rand = new Random();
        for (int i = intArray.length - 1;
             i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap numbers[i] with numbers[j]
            int temp = intArray[i];
            intArray[i] = intArray[j];
            intArray[j] = temp;
        }
        // Print the shuffled array
        System.out.println("Shuffled array: " + Arrays.toString(intArray));
    }

    //method to delete from array
    public void delIntArray() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Array: " + Arrays.toString(intArray));
            System.out.println("Cnoose item to delete: ");
            int target = scanner.nextInt();
            int index = -1;
            boolean isRemoved = false;
            if ((index = indexOf(intArray, target)) != -1) {
                intArray[index] = 0;
                isRemoved = true;
            }
            if (!isRemoved) {
                System.out.println("Item not found.");
            } else {
                System.out.println("Array: " + Arrays.toString(intArray));
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input for integer deletion.");
        }
    }


    //method to add to array
    public void addIntArray() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add new item: ");
            int target = Integer.parseInt(scanner.nextLine());
            if ((indexOf(intArray, target)) != -1) {
                System.out.println("Duplicate item not added.");
                return;
            }
            boolean outOfSpace = true;
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] == 0) {
                    intArray[i] = target;
                    outOfSpace = false;
                    break;
                }
            }
            if (outOfSpace) {
                System.out.println("No more space");
            }
            else {
                System.out.println("IntArray: " + Arrays.toString(intArray));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while adding.");
        }
    }

    //method to print array(String)
    public void printStringArray(String[] stringArray) {

        System.out.println(Arrays.toString(stringArray));
    }


    //method to sort array(string)
    public static void sortStringArray(String[] stringArray) {
        //  Use Arrays sort with a custom comparator that moves nulls to end
        // This uses a lambda expression for brevity
        Arrays.sort(stringArray, (a, b) -> {
            if (a == null) return 1;       // Move null values to the end
            if (b == null) return -1;
            return a.compareTo(b);

        });
        System.out.println(Arrays.toString(stringArray));
    }
    //method to shuffle array(string)
    public static void shuffleStringArray(String[] stringArray){
        // Shuffle the array using Fisher-Yates algorithm
        Random rand = new Random();
        for (int i = stringArray.length - 1;
             i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap numbers[i] with numbers[j]
            String temp = stringArray[i];
            stringArray[i] = stringArray[j];
            stringArray[j] = temp;
        }
        // Print the shuffled array
        System.out.println("Shuffled array: " + Arrays.toString(stringArray));
    }

    //method to delete for array(string)
    public void delStringArray() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Array: " + Arrays.toString(stringArray));
            System.out.println("Cnoose item to delete: ");
            String target = scanner.nextLine();
            int index = -1;
            boolean isRemoved = false;
            if ((index = indexOf(stringArray,target)) != -1) {
                stringArray[index] = null;
                isRemoved = true;
            }
            if (!isRemoved) {
                System.out.println("Item not found.");
            } else {
                System.out.println("Array: " + Arrays.toString(stringArray));
            }
        } catch (Exception e) {
            System.out.println("Error occurred during deletion.");
        }
    }



    //Method to add to string array
    public void addStringArray() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add new item: ");
            String target = scanner.nextLine();

            if ((indexOf(stringArray, target)) != -1) {
                System.out.println("Duplicate item not added.");
                return;
            }
            boolean outOfSpace = true;
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i] == null) {
                    stringArray[i] = target;
                    outOfSpace = false;
                    break;
                }
            }
            if (outOfSpace) {
                System.out.println("No more space");
            } else {
                System.out.println("StringArray: " + Arrays.toString(stringArray));
            }
        } catch (Exception e) {
            System.out.println("Error occurred while adding string.");
        }
    }


    public static int indexOf(int[] numbers, int target) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int indexOf(String[] strArray, String target) {
        int index = -1;
        for (int i = 0; i < strArray.length; i++) {
            // Check for nulls in stringArray, before using equals
            if (strArray[i] != null && strArray[i].equals(target)) {
                index = i;
                break;
            }
        }
        return index;
    }
    //String array interface code
    public void testArrayString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an array of Strings such as countries or fruits...");
        String prompt = "";
        do {
            System.out.print("Choose your operation: add(a),delete(d), shuffle(m),sort(s), print(p), quit(q): ");
            prompt = scanner.nextLine();
            switch (prompt) {
                case "a" -> addStringArray();
                case "d" -> delStringArray();
                case "m" -> shuffleStringArray(stringArray);
                case "s" -> sortStringArray(stringArray);
                case "p" -> printStringArray(stringArray);
                case "q" -> {
                    break;
                }
            }
        }
        while (!prompt.equals("q"));
    }
    //class holding test methods
    public static class arrayShuffleInner {

        public void testArrayStrings(ArrayShuffle arrays) {
            arrays.testArrayString();
        }

        public void testArrayInt(ArrayShuffle arrays) {
            arrays.testArrayInt();
        }

    }

    public void myTestDriver() {
        arrayShuffleInner inner = new arrayShuffleInner();
        inner.testArrayInt(this);
        inner.testArrayStrings(this);
    }

    public static void main(String[] args) {
        ArrayShuffle arrays = new ArrayShuffle();
        arrays.myTestDriver();
    }
}