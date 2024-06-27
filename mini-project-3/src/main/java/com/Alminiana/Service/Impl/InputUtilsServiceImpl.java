package com.Alminiana.Service.Impl;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import com.Alminiana.Service.InputUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class InputUtilsServiceImpl implements InputUtilsService {
    private static final Logger logger = LoggerFactory.getLogger(InputUtilsServiceImpl.class);

    public void processUserInput(Scanner scanner, Cart cart, List<Product> products) {
        // Get a valid product ID from the user
        int productId = InputValidatorServiceImpl.getValidProductId(scanner, products);
        Product selectedProduct = products.stream().filter(product -> product.getId() == productId).findFirst().orElse(null);

        // Get a valid quantity from the user
        int quantity = InputValidatorServiceImpl.getValidQuantity(scanner);

        cart.addProduct(selectedProduct, quantity);
        double subTotal = selectedProduct.getPrice() * quantity;
        System.out.println("Sub-Total: ₱" + subTotal);
        logger.info("Product added to cart: {}, Quantity: {}", selectedProduct.getName(), quantity);
    }

    public void processPayment(Scanner scanner, Cart cart) {
        double totalPrice = cart.calculateTotalPrice();
        while (true) {
            System.out.print("Enter the amount to pay: ");
            String input = scanner.next();
            try {
                double payment = Double.parseDouble(input);
                if (payment < totalPrice) {
                    System.out.printf("Insufficient amount. You need to pay at least ₱%.2f%n", totalPrice);
                } else {
                    double change = payment - totalPrice;
                    System.out.printf("Change: ₱%.2f%n", change);
                    logger.info("Payment processed successfully. Change: {}", change);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                logger.warn("Invalid input format: {}", input);
            }
        }
    }
}