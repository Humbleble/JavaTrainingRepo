import java.util.Scanner;

public class Calculator {

    // Method to add two numbers
    public double add(double inp1, double inp2) {
        return inp1 + inp2;
    }

    // Method to subtract two numbers
    public double subtract(double inp1, double inp2) {
        return inp1 - inp2;
    }

    // Method to multiply two numbers
    public double multiply(double inp1, double inp2) {
        return inp1 * inp2;
    }

    // Method to divide two numbers, with exception handling for division by zero
    public double division(double inp1, double inp2) {
        if (inp2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return inp1 / inp2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Calculator");
            System.out.println("Choose your operand");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. CLOSE");

            int userChoice;

            // Error handling when user inputs a value not available in the choices
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice < 1 || userChoice > 5) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            // Terminates program if user chooses CLOSE option
            if (userChoice == 5) {
                break;
            }

            double x;

            // Loop for the Error Handling
            while (true) {
                System.out.println("Enter your first number:");

                // Error Handling for invalid inputs such as symbols, letters, etc.
                try {
                    x = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            double y;

            // Loop for the Error Handling with additional check for division by zero
            while (true) {
                System.out.println("Enter your second number:");

                // Error Handling for invalid inputs such as symbols, letters, etc.
                try {
                    y = Double.parseDouble(scanner.nextLine());
                    if (userChoice == 4 && y == 0) {
                        System.out.println("Error: Cannot divide by zero. Please enter a valid number.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            try {
                double result;

                // Switch Cases for userChoice
                switch (userChoice) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.division(x, y);
                        break;

                    // This default case will probably never be reached due to the initial validation at lines 44-53.
                    default:
                        System.out.println("Invalid input. Please try again.");
                        continue;
                }
                System.out.println("The result is " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            boolean validResponse = false;
            while (!validResponse) {
                System.out.println("Do you want to perform another calculation? (y/n)");
                String continueChoice = scanner.nextLine().trim().toLowerCase();

                // Error Handling for user input
                if (continueChoice.equals("y")) {
                    validResponse = true;
                } else if (continueChoice.equals("n")) {
                    scanner.close();
                    return;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            }
        }
        scanner.close();
    }
}