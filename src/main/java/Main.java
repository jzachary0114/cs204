import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Welcome to the Calculator CLI!");
        System.out.println("Enter a command (add, subtract, multiply, divide, fibonacci, binary) followed by numbers.");

        while (true) {
            System.out.print("> ");  // Command prompt
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts.length < 2) {
                System.out.println("Invalid command. Please enter a valid operation.");
                continue;
            }

            String operation = parts[0];

            try {
                switch (operation) {
                    case "add":
                        if (parts.length < 3) throw new IllegalArgumentException("Two numbers required.");
                        int sum = calculator.add(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        System.out.println(sum);
                        break;

                    case "subtract":
                        if (parts.length < 3) throw new IllegalArgumentException("Two numbers required.");
                        int difference = calculator.subtract(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        System.out.println(difference);
                        break;

                    case "multiply":
                        if (parts.length < 3) throw new IllegalArgumentException("Two numbers required.");
                        int product = calculator.multiply(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        System.out.println(product);
                        break;

                    case "divide":
                        if (parts.length < 3) throw new IllegalArgumentException("Two numbers required.");
                        int quotient = calculator.divide(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        System.out.println(quotient);
                        break;

                    case "fibonacci":
                        int n = Integer.parseInt(parts[1]);
                        System.out.println(calculator.fibonacciNumberFinder(n));
                        break;

                    case "binary":
                        int num = Integer.parseInt(parts[1]);
                        System.out.println(calculator.intToBinaryNumber(num));
                        break;

                    case "exit":
                        System.out.println("Exiting Calculator CLI. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Unknown command. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
