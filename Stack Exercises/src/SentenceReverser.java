import java.util.Stack;
import java.util.Scanner;

public class SentenceReverser {

    public static void main(String[] args) {
        SentenceReverser reverser = new SentenceReverser();

        String test1 = "I must not fear. Fear is the mind killer. Fear is the little death that brings total obliteration.";
        String test2 = "Fools admire thoughtful men while men thoughtful admire fools.";


        System.out.println("Mantra from 'Dune':");
        System.out.println("Original: " + test1);
        System.out.println("Reversed: " + reverser.reverse(test1));

        System.out.println(); // Blank line for clean spacing

        System.out.println("Palindrome");
        System.out.println("Original: " + test2);
        System.out.println("Reversed: " + reverser.reverse(test2));
    }

    public String reverse(String sentence) {
        String reversed = "";
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(sentence);

        while (scanner.hasNext()) {
            String pushWord = scanner.next();
            stack.push(pushWord);

            // Check for the period to trigger processing
            if (pushWord.contains(".")) {
                reversed = processSentence(scanner, stack, reversed);
            }
        }

        scanner.close();
        return reversed.trim();
    }

    public String processSentence(Scanner scanner, Stack<String> stack, String reversed) {
        boolean isFirstWord = true;

        while (!stack.isEmpty()) {
            String popWord = stack.pop();

            // Clean the word
            popWord = popWord.replace(".", "");
            popWord = popWord.toLowerCase();

            // Capitalize if it's the first word pulled off the stack
            if (isFirstWord) {
                String firstLetter = popWord.substring(0, 1);
                popWord = firstLetter.toUpperCase() + popWord.substring(1);
                isFirstWord = false;
            }

            reversed = reversed + popWord + " ";
        }

        // Remove the trailing space, add the period, and add a space for the next sentence
        reversed = reversed.trim() + ". ";
        return reversed;
    }
}