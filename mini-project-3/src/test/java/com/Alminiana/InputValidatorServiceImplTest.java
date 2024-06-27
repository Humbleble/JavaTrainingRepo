package com.Alminiana;

import com.Alminiana.Model.Product;
import com.Alminiana.Service.Impl.InputValidatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatorServiceImplTest {
    private List<Product> products;

    @BeforeEach
    public void setUp() {
        products = Arrays.asList(
                new Product(1, "Laptop", 999.99),
                new Product(2, "Smartphone", 499.99)
        );
    }

    @Test
    public void testGetValidProductId() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int productId = InputValidatorServiceImpl.getValidProductId(scanner, products);
        assertEquals(1, productId);
    }

    @Test
    public void testGetValidQuantity() {
        String input = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int quantity = InputValidatorServiceImpl.getValidQuantity(scanner);
        assertEquals(2, quantity);
    }
}