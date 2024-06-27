package com.Alminiana;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import com.Alminiana.Service.Impl.ReceiptUtilsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReceiptUtilsServiceImplTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Laptop", 999.99);
        product2 = new Product(2, "Smartphone", 499.99);
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
    }

    @Test
    public void testSaveReceipt() throws IOException {
        String userName = "testUser";
        ReceiptUtilsServiceImpl receiptUtils = new ReceiptUtilsServiceImpl();
        receiptUtils.saveReceipt(cart, userName);

        File file = new File(userName + "_receipt.txt");
        assertTrue(file.exists());

        // Clean up the test file
        Files.delete(Paths.get(userName + "_receipt.txt"));
    }
}