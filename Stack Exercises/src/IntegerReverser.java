import java.util.Stack;
import java.util.Scanner;

public class IntegerReverser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter an integer to reverse: ");
        int num = scan.nextInt();

        // Break the number down and push to stack
        while (num != 0) {
            int digit = num % 10;
            stack.push(digit);
            num = num / 10;
        }

        // Print the stack
        System.out.println("Elements in Stack: " + stack);

        int rev_num = 0;
        int power = 0;

        // Pop from stack and rebuild the reversed number
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            rev_num = rev_num + digit * (int) Math.pow(10, power);
            power++;
        }

        System.out.println("Reversed Number: " + rev_num);
        scan.close();
    }
}