package com.Alminiana.Model;

import java.util.List;
import java.util.Arrays;

public class ProductFactory {
    public static List<Product> createProducts() {
        Product product1 = new Product(1, "Cheekos", 342.50);
        Product product2 = new Product(2, "Kreetos", 109.89);
        Product product3 = new Product(3, "Freetos", 199.99);
        Product product4 = new Product(4, "Baenaenae", 78.00);
        Product product5 = new Product(5, "Jelly Klay", 11.40);

        return Arrays.asList(product1, product2, product3, product4, product5);
    }
}