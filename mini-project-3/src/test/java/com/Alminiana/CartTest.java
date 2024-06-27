package com.Alminiana;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Laptop", 999.99);
        product2 = new Product(2, "Smartphone", 499.99);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1, 1);
        assertEquals(1, cart.getProducts().size());
        assertEquals(product1, cart.getProducts().get(0));
    }

    @Test
    public void testCalculateTotalPrice() {
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
        assertEquals(1999.97, cart.calculateTotalPrice());
    }

    @Test
    public void testClearCart() {
        cart.addProduct(product1, 1);
        cart.clearCart();
        assertEquals(0, cart.getProducts().size());
    }
}