package com.Alminiana.Service;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;

import java.util.List;

public interface DisplayUtilsService {
    void displayProducts(List<Product> products);
    void displayCart(Cart cart);
}
