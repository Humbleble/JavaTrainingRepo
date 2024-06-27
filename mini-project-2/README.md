# Library Management System

This is a basic Library Management System implemented in Java. The system allows users to add, remove, and search for books. It utilizes basic Object-Oriented Programming (OOP) principles such as encapsulation, inheritance, and polymorphism.

## Features

- **Add Book**: Add a new book to the library.
- **Remove Book**: Remove a book from the library using its ISBN.
- **Search Books**: Search for books by title, author, or ISBN. Partial matches are supported.
- **Display All Books**: Display all books currently in the library in a tabular format.
- **Input Validation**: Validate user inputs to prevent invalid operations.

## Code Structure
# Model Package
- **Book.java**: Represents a book with title, author, and ISBN.
- **Genre.java**: Enum representing book genres.
- **GenreBook.java**: Extends Book to include genre.
- 
# Service Package
- **LibraryService.java**: Interface defining library operations.
- **LibraryServiceImpl.java**: Implementation of LibraryService.
- **InputValidatorService.java**: Interface for input validation.
- **InputValidatorServiceImpl.java**: Implementation of InputValidatorService.
- 
# Main.java
- Contains the main application logic and user interface.
- LibraryServiceImplTest.java
- Unit tests for LibraryServiceImpl.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/Humbleble/JavaTrainingRepo.git
   cd JavaTrainingRepo
   
2. Build the project using Maven:

   ```sh
   mvn clean install

### Running the Application

To run the application, execute the following command:

   ```sh
   mvn exec:java -Dexec.mainClass="org.Alminiana.Main"
   ```

### Running Unit Tests

To run the unit tests, use the following command:

   ```sh
   mvn test
   ```

## Project Structure
```css
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── Alminiana
│   │   │           ├── Model
│   │   │           │   ├── Book.java
│   │   │           │   ├── Genre.java
│   │   │           │   └── GenreBook.java
│   │   │           ├── Service
│   │   │           │   ├── Impl
│   │   │           │   │   ├── InputValidatorServiceImpl.java
│   │   │           │   │   └── LibraryServiceImpl.java
│   │   │           │   ├── InputValidatorService.java
│   │   │           │   └── LibraryService.java
│   │   │           └── Main
│   └── test
│       └── java
│           └── org
│               └── Alminiana
│                   └── LibraryServiceImplTest.java   
├── pom.xml
└── README.md
```
## Usage
### Adding a Book
1. Select the option to add a book. 
2. Enter the title, author, and ISBN of the book. 
3. The system will confirm if the book was added successfully. 
### Removing a Book 
1. Select the option to remove a book. 
2. Enter the ISBN of the book to be removed. 
3. The system will confirm if the book was removed successfully or if no book was found with the provided ISBN. 
### Searching for Books 
1. Select the option to search for books. 
2. Enter a search query (partial or full title, author, or ISBN). 
3. The system will display all books matching the search query. 
### Displaying All Books 
1. Select the option to display all books. 
2. The system will display all books currently in the library in a tabular format. 
### Exiting the System 
1. Select the option to exit. 
2. The system will terminate the application.
