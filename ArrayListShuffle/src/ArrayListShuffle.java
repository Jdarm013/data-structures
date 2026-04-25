import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

//class to encapsulate logic
public class ArrayListShuffle {
    ArrayList<String> stringAL = new ArrayList<>();
    ArrayList<Integer> intAL = new ArrayList<>();
    //array list interface
    public void testArrayListInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an Array List of Integers");
        String prompt = "";
        do {
            System.out.print("Choose your operation: add (a),delete(d), shuffle(m),sort(s), print(p), quit(q): ");
            prompt = scanner.nextLine();
            switch (prompt) {
                case "a" -> addIntAL();
                case "d" -> delIntAL();
                case "m" -> Collections.shuffle(intAL);
                case "s" -> Collections.sort(intAL);
                case "p" -> System.out.println(intAL);
                case "q" -> {
                    break;
                }
            }
        }
        while (!prompt.equals("q"));
    }
    //method to delete from int array list
    private void delIntAL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(intAL);
        System.out.println("Choose integer to delete: ");
        try {
            Integer item = Integer.valueOf(scanner.nextLine());
            if (intAL.remove(item)) {
                System.out.println("ArrayList: " + intAL);
            } else {
                System.out.println("Item not found.");
            }
        } catch (Exception e) { System.out.println("Invalid number."); }
    }
    //method to add to int array list
    private void addIntAL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new item: ");
        String item = scanner.nextLine();
        try {
            intAL.add(Integer.valueOf(item));
            System.out.println("ArrayList: " + intAL);
        } catch (Exception e) { System.out.println("Please enter a number."); }
    }
    //interface for string array list
    public void testArrayStrings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an Array of Strings such as countries or fruits...");
        String prompt = "";
        do {
            System.out.print("Choose your operation: add (a),delete(d), shuffle(m),sort(s), print(p), quit(q): ");
            prompt = scanner.nextLine();
            switch (prompt) {
                case "a" -> addStringAL();
                case "d" -> delStringAL();
                case "m" -> Collections.shuffle(stringAL);
                case "s" -> Collections.sort(stringAL);
                case "p" -> System.out.println(stringAL);
                case "q" -> {
                    break;
                }
            }
        }
        while (!prompt.equals("q"));
    }
    //method for deleting from string array list
    private void delStringAL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Array: " + stringAL);
        System.out.println("Cnoose item to delete: ");
        String target = scanner.nextLine();
        boolean isRemoved = stringAL.remove(target);
        if (!isRemoved) {
            System.out.println("Item not found.");
        } else {
            System.out.println("Array: " + stringAL);
        }
    }
    //method for adding to string array list
    private void addStringAL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new item: ");
        String item = scanner.nextLine();
        if (stringAL.contains(item)) {
            System.out.println("Duplicate item not added.");
            return;
        }
        stringAL.add(item);
        System.out.println("ArrayList: " + stringAL);
    }


    //class holding test methods
    public static class InnerShuffle {
        public void testArrayListStrings(ArrayListShuffle arrayList) {
            arrayList.testArrayStrings();
        }
        public void testArrayListInt(ArrayListShuffle arrayList) {
            arrayList.testArrayListInt();
        }
    }


    public void myTestDriver() {
        InnerShuffle inner = new InnerShuffle();
        inner.testArrayListStrings(this);
        inner.testArrayListInt(this);

        // Link to the other class
        ArrayShuffle arrays = new ArrayShuffle();
        arrays.myTestDriver();
    }

    public static void main(String[] args) {
        ArrayListShuffle arrayList = new ArrayListShuffle();
        arrayList.myTestDriver();

    }
}
//we have to use a lambda expression instead of a default comparator because its case sensitive, and for brevity.
//Lambda also allows your to sort by more then just alphabetical order, it can sort by many different value types.
//