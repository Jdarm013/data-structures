import java.util.Scanner;

public class Recursion {

    // Recursive Sum Generaor W/UI
    public int sum(int n, Scanner scanner) {
        if (n == -1) {
            System.out.println("\n--- Recursive Sum ---");
            n = getValidInput(scanner, "Enter a number (1-9): ");
            int result = n + sum(n - 1, scanner);
            System.out.println("Sum of " + n + " to 1 is: " + result);
            return result;
        }
        if (n <= 0) return 0;
        return n + sum(n - 1, scanner);
    }

    // Factorial Generator W/UI
    public int factorial(int n, Scanner scanner) {
        if (n == -1) {
            System.out.println("\n--- Factorial ---");
            n = getValidInput(scanner, "Enter a number (1-9): ");
            int result = n * factorial(n - 1, scanner);
            System.out.println("Factorial of " + n + " is: " + result);
            return result;
        }
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1, scanner);
    }

    // Power of 10 Generator W/UI
    public int powerOf10(int n, Scanner scanner) {
        if (n == -1) {
            System.out.println("\n--- Power of 10 ---");
            n = getValidInput(scanner, "Enter a power (1-9): ");
            int result = 10 * powerOf10(n - 1, scanner);
            System.out.println("10 to the power of " + n + " is: " + result);
            return result;
        }
        if (n == 0) return 1;
        return 10 * powerOf10(n - 1, scanner);
    }

    // Power of N Generator W/UI
    public int powerOfN(int x, int p, Scanner scanner) {
        if (p == -1) {
            System.out.println("\n--- Power of X to P ---");
            x = getValidInput(scanner, "Enter the base (1-9): ");
            p = getValidInput(scanner, "Enter the power (1-9): ");
            int result = x * powerOfN(x, p - 1, scanner);
            System.out.println(x + " to the power of " + p + " is: " + result);
            return result;
        }
        if (p <= 0) return 1;
        return x * powerOfN(x, p - 1, scanner);
    }

    // "Ears of a Bunny Rabbit" Calculation Generator Program W/UI
    public int bunnyEars(int n, Scanner scanner) {
        if (n == -1) {
            System.out.println("\n--- Bunny Ears ---");
            n = getValidInput(scanner, "How many bunnies (1-9)? ");
            int result = 2 + bunnyEars(n - 1, scanner);
            System.out.println("Total bunny ears: " + result);
            return result;
        }
        if (n <= 0) return 0;
        return 2 + bunnyEars(n - 1, scanner);
    }

// Reverse Character Engine
    public String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
// Palindrome Tester
    public void isPalindrome(Scanner scanner) {
        System.out.println("\n--- Palindrome Tester ---");
        System.out.print("Type word or phrase: ");
        scanner.nextLine(); // Buffer clear
        String input = scanner.nextLine();
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (cleaned.equals(reverse(cleaned))) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }

// Professional Standard for Handling Try/Catch Exceptions without cluttering your code.
    public int getValidInput(Scanner scanner, String prompt) {
        int choice;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 9) {
                    return choice; // Data is perfect, return it
                } else {
                    System.out.println("Invalid: Please stay between 1 and 9.");
                }
            } else {
                System.out.println("Invalid: That is not a whole number.");
                scanner.next();
            }
        }
    }

    // Testdriver AKA Method caller
    public void testDriver() {
        Recursion rec = new Recursion();
        Scanner mainScanner = new Scanner(System.in);
        System.out.println("Welcome to the Recursive Lab!");

        rec.sum(-1, mainScanner);
        rec.factorial(-1, mainScanner);
        rec.powerOf10(-1, mainScanner);
        rec.powerOfN(0, -1, mainScanner);
        rec.bunnyEars(-1, mainScanner);
        rec.isPalindrome(mainScanner);

        mainScanner.close();
    }
// Final Main Call of Program
    public void main(String[] args) {
        testDriver();
    }
}