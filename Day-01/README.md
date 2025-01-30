# JUnit Testing Project

## Overview
This project demonstrates the use of **JUnit 5** for unit testing in Java. The project includes test cases for basic mathematical operations and customer management functionalities.

## Technologies Used
- **Java**
- **JUnit 5**
- **Maven

## Project Structure
```
com.test
├── App.java                # Main application class containing sum and product methods
├── Customer.java           # Customer entity class
├── CustomerManager.java    # Manages customer data storage and retrieval
├── AppTest.java            # JUnit test cases for App and CustomerManager
```

## Classes & Functionalities
### `App.java`
This class contains two methods:
- `sum(int a, int b)`: Returns the sum of two integers.
- `product(int a, int b)`: Returns the product of two integers.

### `Customer.java`
Defines a customer entity with attributes:
- `customerId`
- `firstName`
- `lastName`
- `phoneNumber`

### `CustomerManager.java`
Manages customer data using a HashMap and provides methods to:
- Add a new customer (`addCustomer` method)
- Retrieve all customers (`getAllCustomers` method)
- Check if a customer already exists (`CheckIfCustomerAlreadyExists` method)

## Unit Tests
### `AppTest.java`
This class contains JUnit test cases to validate the functionality of `App.java` and `CustomerManager.java`.

#### Test Methods:
- `testSum()`: Tests the `sum` method.
- `testProduct()`: Tests the `product` method.
- `addCustomerTest()`: Tests adding a customer to `CustomerManager`.
- `checkForCustomerIsNotNull()`: Ensures a customer is not null after being added.

### Annotations Used:
- `@BeforeAll`: Executes once before all test cases.
- `@BeforeEach`: Executes before each test case.
- `@Test`: Marks a method as a test case.
- `@AfterEach`: Executes after each test case.
- `@AfterAll`: Executes once after all test cases.

## Running the Tests
1. Ensure JUnit 5 is added to the project's dependencies.
2. Run the tests using your IDE (e.g., IntelliJ IDEA, Eclipse) or via terminal:
   ```sh
   mvn test   # If using Maven
   ```

