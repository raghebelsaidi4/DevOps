# JUnit with Mockito

Mockito is a popular **mocking framework** used in Java to create **mock objects** for unit testing. Mock objects are fake objects that simulate the behavior of real objects in a controlled way. They are particularly useful for isolating the unit of work being tested by replacing dependencies with mock objects.

---

## Key Concepts

### 1. **Mock Objects**
Mock objects are fake instances of classes that mimic the behavior of real objects. They are used to:
- Replace real dependencies in unit tests.
- Simulate specific behaviors or responses.
- Verify interactions between objects.

### 2. **Real vs. Mock Objects**
- **Real Object**: An actual instance of a class.
  ```java
  class A {}
  A a = new A(); // Real object of class A
  a.method1();   // Calls the real method1() of class A
  ```
- **Mock Object**: A fake instance of a class created using Mockito.
  ```java
  A a1 = Mockito.mock(A.class); // Mock object of class A
  a1.method1();                 // Does not call the real method1()
  ```

### 3. **Stubbing Methods**
Mockito allows you to define the behavior of mock objects using **stubbing**. For example:
```java
when(a1.method1()).thenReturn("Fake Response");
```
This makes `a1.method1()` return `"Fake Response"` when called.

### 4. **Verifying Interactions**
Mockito can verify if certain methods were called on mock objects:
```java
verify(a1).method1();
```

---

## Example

### Class to Test
```java
public class Calculator {
    private MathService mathService;

    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }

    public int add(int a, int b) {
        return mathService.add(a, b);
    }
}
```

### Dependency Interface
```java
public interface MathService {
    int add(int a, int b);
}
```

### Unit Test with Mockito
```java
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Create a mock object for MathService
        MathService mathService = Mockito.mock(MathService.class);

        // Stub the behavior of the mock object
        when(mathService.add(10, 20)).thenReturn(30);

        // Inject the mock object into the Calculator
        Calculator calculator = new Calculator(mathService);

        // Test the add method
        int result = calculator.add(10, 20);

        // Verify the result
        assertEquals(30, result);

        // Verify that the mock method was called
        verify(mathService).add(10, 20);
    }
}
```

---

## Key Features of Mockito

1. **Mock Creation**:
    - Use `Mockito.mock(Class<T> classToMock)` to create mock objects.

2. **Stubbing**:
    - Use `when(mock.method()).thenReturn(value)` to define the behavior of mock methods.

3. **Verification**:
    - Use `verify(mock).method()` to verify that a method was called.

4. **Argument Matchers**:
    - Use `any()`, `eq()`, etc., to match arguments in stubbing and verification.

5. **Exception Throwing**:
    - Use `when(mock.method()).thenThrow(new Exception())` to simulate exceptions.

6. **Spying**:
    - Use `Mockito.spy()` to create a partial mock that calls real methods unless stubbed.

---

## Advantages of Using Mockito

- **Isolation**: Mockito helps isolate the unit of work by replacing dependencies with mock objects.
- **Flexibility**: You can simulate various scenarios (e.g., success, failure, exceptions) using stubbing.
- **Readability**: Mockito's syntax is clean and easy to understand.
- **Integration**: It integrates seamlessly with JUnit and other testing frameworks.

---