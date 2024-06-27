package com.Alminiana.Service.Impl;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import com.Alminiana.Service.DisplayUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DisplayUtilsServiceImpl implements DisplayUtilsService {
    private static final Logger logger = LoggerFactory.getLogger(DisplayUtilsServiceImpl.class);

    public void displayProducts(List<Product> products) {
        logger.info("Displaying available products.");
        System.out.println("ID | Product Name         | Product Price");
        System.out.println("----------------------------------------");
        for (Product product : products) {
            System.out.printf("%-3d| %-20s| ₱%.2f\n", product.getId(), product.getName(), product.getPrice());
        }
        System.out.println();
    }

    public void displayCart(Cart cart) {
        logger.info("Displaying cart items.");
        System.out.println("\nYour Cart:");
        System.out.println("ID | Product Name         | Product Price | Quantity | Sub-Total");
        System.out.println("---------------------------------------------------------------");
        List<Product> products = cart.getProducts();
        List<Integer> quantities = cart.getQuantities();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int quantity = quantities.get(i);
            double subTotal = product.getPrice() * quantity;
            System.out.printf("%-3d| %-20s| ₱%-13.2f| %-9d| ₱%.2f\n", product.getId(), product.getName(), product.getPrice(), quantity, subTotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Price: ₱%.2f\n", cart.calculateTotalPrice());
        System.out.println();
    }
}