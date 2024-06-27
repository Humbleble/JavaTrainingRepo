package com.Alminiana.Service.Impl;

import com.Alminiana.Model.Product;
import com.Alminiana.Service.InputValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class InputValidatorServiceImpl implements InputValidatorService {
    private static final Logger logger = LoggerFactory.getLogger(InputValidatorServiceImpl.class);

    public static int getValidProductId(Scanner scanner, List<Product> products) {
        while (true) {
            System.out.print("Type in the product ID to buy: ");
            String input = scanner.next();
            try {
                int productId = Integer.parseInt(input);
                boolean valid = products.stream().anyMatch(product -> product.getId() == productId);
                if (!valid) {
                    System.out.println("Invalid product ID. Please try again.");
                    logger.warn("Invalid product ID entered: {}", productId);
                } else {
                    return productId;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric product ID.");
                logger.warn("Invalid input format: {}", input);
            }
        }
    }

    public static int getValidQuantity(Scanner scanner) {
        while (true) {
            System.out.print("Enter the quantity: ");
            String input = scanner.next();
            try {
                int quantity = Integer.parseInt(input);
                if (quantity <= 0) {
                    System.out.println("Quantity must be positive. Please try again.");
                    logger.warn("Invalid quantity entered: {}", quantity);
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric quantity.");
                logger.warn("Invalid input format: {}", input);
            }
        }
    }
}