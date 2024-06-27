# Basic E-Commerce Cart System

This project implements a simple e-commerce cart system that allows users to add items to a cart, view the cart, and calculate the total price.

## Features

- Display a list of products.
- Add products to the cart.
- View the cart with product details, quantities, and sub-totals.
- Calculate the total price of the cart.
- Process payment and calculate change.
- Generate a receipt and save it to a file.

## Project Structure

The project is organized into the following packages:

### com.Alminiana.Model
- `Cart.java`: Represents the shopping cart.
- `Product.java`: Represents a product.
- `ProductFactory.java`: Creates and returns a list of products.

### com.Alminiana.Service
- `DisplayUtilsService.java`: Interface for displaying information.
- `DisplayUtilsServiceImpl.java`: Implementation of `DisplayUtilsService`.
- `InputUtilsService.java`: Interface for handling user inputs.
- `InputUtilsServiceImpl.java`: Implementation of `InputUtilsService`.
- `InputValidatorService.java`: Interface for validating inputs.
- `InputValidatorServiceImpl.java`: Implementation of `InputValidatorService`.
- `ReceiptUtilsService.java`: Interface for handling receipts.
- `ReceiptUtilsServiceImpl.java`: Implementation of `ReceiptUtilsService`.

### com.Alminiana
- `Main.java`: The main class that runs the application.

## Project Structure
```css
   mini-project-3/
   ├── src/
   │   ├── main/
   │   │   ├── java/
   │   │   │   └── com/
   │   │   │       └── Alminiana/
   │   │   │           ├── Model/
   │   │   │           │   ├── Cart.java
   │   │   │           │   ├── Product.java
   │   │   │           │   └── ProductFactory.java
   │   │   │           ├── Service/
   │   │   │           │   ├── DisplayUtilsService.java
   │   │   │           │   ├── InputUtilsService.java
   │   │   │           │   ├── ReceiptUtilsService.java
   │   │   │           │   └── Impl/
   │   │   │           │       ├── DisplayUtilsServiceImpl.java
   │   │   │           │       ├── InputUtilsServiceImpl.java
   │   │   │           │       ├── InputValidatorServiceImpl.java
   │   │   │           │       └── ReceiptUtilsServiceImpl.java
   │   │   │           └── Main.java
   │   │   └── resources/
   │   │       └── log4j2.xml
   │── src/
   │   └── test/
   │       └── java/
   │           ├── com/
   │               └── Alminiana/
   │                   ├── CartTest.java
   │                   ├── InputValidatorServiceImplTest.jav   
   │                   └── ReceiptUtilsServiceImplTest.java
   │   
   │ 
   │
   ├── pom.xml
   └── README.md
```

### Usage

**1. Run the Application**

   - Navigate to the project directory.
   - Run the main class `Main.java` from your IDE or use the following Maven command:

   ```sh
   mvn exec:java -Dexec.mainClass="com.Alminiana.Main"
   ```

**2. Interact with the System**

   - Follow the prompts to enter your name, add products to your cart, view your cart, process payment, and generate a receipt.

**3. Receipt Generation**

- After payment, a receipt will be generated and saved in the format `username_receipt.txt`.


### Testing

Unit tests are provided for the core functionalities:

- `CartTest`: Tests for adding products and calculating the total price.
- `InputValidatorServiceImplTest`: Tests for validating user inputs.
- `ReceiptUtilsServiceImplTest`: Tests for generating and saving the receipt.

To run the tests, use the following Maven command:

   ```sh
   mvn test
   ```

### Dependencies

- JUnit 5 for testing
- SLF4J and Log4j2 for logging

Ensure you have Maven installed and configured correctly to manage the dependencies.
