package org.Alminiana.Classes;

import java.util.Scanner;

public class InputValidator {
    public static int getValidatedChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.printf("Invalid input. Please enter a number between %d and %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid input. Please enter a number between %d and %d.%n", min, max);
            }
        }
        return choice;
    }
}