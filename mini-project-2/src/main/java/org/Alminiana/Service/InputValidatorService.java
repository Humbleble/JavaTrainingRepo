package org.Alminiana.Service;

import org.Alminiana.Model.Genre;
import java.util.Scanner;

public interface InputValidatorService {
    int getValidatedChoice(Scanner scanner, int min, int max);
    Genre getValidatedGenre(Scanner scanner);

}
