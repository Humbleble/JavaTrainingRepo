package com.Alminiana.Service.Impl;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import com.Alminiana.Service.ReceiptUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReceiptUtilsServiceImpl implements ReceiptUtilsService {
    private static final Logger logger = LoggerFactory.getLogger(ReceiptUtilsServiceImpl.class);

    public void saveReceipt(Cart cart, String userName) {
        String fileName = userName + "_receipt.txt";
        logger.info("Saving receipt to file: {}", fileName);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Receipt:\n");
            writer.write("ID | Product Name         | Product Price | Quantity | Sub-Total\n");
            writer.write("---------------------------------------------------------------\n");

            List<Product> products = cart.getProducts();
            List<Integer> quantities = cart.getQuantities();

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                int quantity = quantities.get(i);
                double subTotal = product.getPrice() * quantity;
                writer.write(String.format("%-3d| %-20s| ₱%-13.2f| %-9d| ₱%.2f\n", product.getId(), product.getName(), product.getPrice(), quantity, subTotal));
            }

            writer.write("---------------------------------------------------------------\n");
            writer.write(String.format("Total Price: ₱%.2f\n", cart.calculateTotalPrice()));
        } catch (IOException e) {
            logger.error("An error occurred while saving the receipt.", e);
        }
    }
}