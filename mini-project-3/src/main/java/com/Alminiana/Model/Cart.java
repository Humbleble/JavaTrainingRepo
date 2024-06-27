package com.Alminiana.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private List<Integer> quantities;

    public Cart() {
        products = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
    }

    public void clearCart() {
        products.clear();
        quantities.clear();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }
}