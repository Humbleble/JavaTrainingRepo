package org.Alminiana;

import org.Alminiana.model.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class InputValidator {
    private static final Logger logger = LoggerFactory.getLogger(InputValidator.class);

    public static int getValidatedChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    logger.warn("Invalid input: " + choice + ". Please enter a number between " + min + " and " + max);
                    System.out.printf("Invalid input. Please enter a number between %d and %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                logger.warn("Invalid input: not a number. Please enter a number between " + min + " and " + max);
                System.out.printf("Invalid input. Please enter a number between %d and %d.%n", min, max);
            }
        }
        return choice;
    }

    public static Genre getValidatedGenre(Scanner scanner) {
        int choice = getValidatedChoice(scanner, 1, 5);
        switch (choice) {
            case 1: return Genre.FICTION;
            case 2: return Genre.NON_FICTION;
            case 3: return Genre.NOVEL;
            case 4: return Genre.HISTORY;
            case 5: return Genre.ROMANCE;
            default: throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}