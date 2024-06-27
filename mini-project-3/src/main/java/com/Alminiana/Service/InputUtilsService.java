package com.Alminiana.Service;

import com.Alminiana.Model.Cart;
import com.Alminiana.Model.Product;

import java.util.List;
import java.util.Scanner;

public interface InputUtilsService {
    void processUserInput(Scanner scanner, Cart cart, List<Product> products);
    void processPayment(Scanner scanner, Cart cart);

}
