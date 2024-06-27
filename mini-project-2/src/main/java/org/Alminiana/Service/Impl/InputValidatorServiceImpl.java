package org.Alminiana.Service.Impl;

import org.Alminiana.Model.Genre;
import java.util.Scanner;
import org.Alminiana.Service.InputValidatorService;

public class InputValidatorServiceImpl implements InputValidatorService {

    @Override
    public int getValidatedChoice(Scanner scanner, int min, int max) {
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

    @Override
    public Genre getValidatedGenre(Scanner scanner) {
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