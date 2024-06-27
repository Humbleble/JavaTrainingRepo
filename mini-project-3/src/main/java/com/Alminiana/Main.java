package com.Alminiana;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import com.Alminiana.Model.ProductFactory;
import com.Alminiana.Service.Impl.DisplayUtilsServiceImpl;
import com.Alminiana.Service.Impl.InputUtilsServiceImpl;
import com.Alminiana.Service.Impl.ReceiptUtilsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Program started.");

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        logger.info("User name entered: {}", userName);

        Cart cart = new Cart();
        List<Product> products = ProductFactory.createProducts();
        DisplayUtilsServiceImpl displayUtils = new DisplayUtilsServiceImpl();
        InputUtilsServiceImpl inputUtils = new InputUtilsServiceImpl();
        ReceiptUtilsServiceImpl receiptUtils = new ReceiptUtilsServiceImpl();

        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Welcome to Jek's Mart!");
            displayUtils.displayProducts(products);

            boolean addMoreItems = true;
            while (addMoreItems) {
                inputUtils.processUserInput(scanner, cart, products);

                System.out.print("Would you like to buy more? (y/n): ");
                while (addMoreItems) {
                    char buyMore = scanner.next().toLowerCase().charAt(0);
                    if (buyMore == 'y' || buyMore == 'n') {
                        if (buyMore == 'n') {
                            addMoreItems = false;
                        }
                        break;
                    } else {
                        System.out.print("Invalid input, Please input y for Yes and n for No: ");
                    }
                }
            }

            displayUtils.displayCart(cart);
            inputUtils.processPayment(scanner, cart);
            receiptUtils.saveReceipt(cart, userName);
            cart.clearCart();

            System.out.print("Thank you for shopping!\n\n");
            System.out.print("Would you like to shop again? (y/n): ");
            while (continueShopping) {
                char shopAgain = scanner.next().toLowerCase().charAt(0);
                if (shopAgain == 'y' || shopAgain == 'n') {
                    if (shopAgain == 'n') {
                        continueShopping = false;
                    }
                    break;
                } else {
                    System.out.print("Invalid input, Please input y for Yes and n for No: ");
                }
            }
        }

        logger.info("Program terminated.");
        scanner.close();
    }
}