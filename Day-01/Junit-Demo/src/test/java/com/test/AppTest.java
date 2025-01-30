package com.test;

import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// write unit test code for testing the sum method of App.java
// test class to test main code
class AppTest {

    private static String expectedOrganizationName = "";
    private CustomerManager manager;

    @BeforeAll
    public static void initializeCommonData(){
        System.out.println("Initializing Common Data");
         expectedOrganizationName = "Software Engineering";
    }

    @BeforeEach
    public void initializeDataBeforeTest(){
        //System.out.println("Initializing Data");
        manager = new CustomerManager();
    }


    @Test // this annotation indicates this method is test method and Junit library see this annotation and execute this method
    public void testSum() {
        // Define the input to be passed to the sum method
        int a = 20;
        int b = 30;
        // define expected output from the method
        int exceptedOutput = 50;
        // get actual output  by calling the sum method of App.java by passing required input
        App app = new App();
        //int actualOutput = app.sum(a, b);
        // compare the expected output and actual output
        // assertEquals will compare exceptedOutput, actualOutput
        // and if they equal, this makes test method pass else test method failed
        //assertEquals(exceptedOutput, actualOutput);
    }

    @Test
    public void testProduct() {
        // define input to be passed
        int a = 5;
        int b = 2;

        // define expected output from the method
        int exceptedOutput = 10;

        // get the actual output by calling product method of App.java by passing required input
        App app = new App();
        //int actualOutput = app.product(a, b);

        //compare expected output and actual output
        // assertEquals will compare exceptedOutput, actualOutput
        // and if they equal, this makes test method pass else test method failed
        //assertEquals(exceptedOutput, actualOutput);
    }



    @Test
    public void addCustomerTest(){
        System.out.println("inside addCustomerTest");
        // define input to be passed to addCustomer method
        String CustomerId = "c100";
        String firstName = "Ahmed";
        String lastName = "Bharat";
        String phoneNumber = "+911234567";

        // define expected output
        // the expected output is the customer object whose id is c100
        String expectedCustomerId = "c100";

        // get the actual output
        CustomerManager manager = new CustomerManager();
        Customer actualCustomer = manager.addCustomer(CustomerId, firstName, lastName, phoneNumber);

        // compare expected output with actual output
        assertEquals(expectedCustomerId, actualCustomer.getCustomerId());

        Collection<Customer> list = manager.getAllCustomers();

        // if list.isEmpty is false, then test code case is passed, else failed
        assertFalse(list.isEmpty());
        assertTrue(list.contains(actualCustomer));
        assertTrue(!list.isEmpty());
    }

    @Test
    public void checkForCustomerIsNotNull(){
        System.out.println("inside checkForCustomerIsNotNull");
        String CustomerId = "c100";
        String firstName = "Ahmed";
        String lastName = "Bharat";
        String phoneNumber = "+911234567";

        // actual output
        //CustomerManager manager = new CustomerManager();
        Customer actualCustomer = manager.addCustomer(CustomerId, firstName, lastName, phoneNumber);

        // test for customer object is null or not
        // assertNotNull will expect the object to be not null, if it is null test case is passed else failed
        assertNotNull(actualCustomer);

        assertEquals(expectedOrganizationName,manager.getOriginzationName());
    }

    @AfterEach
    public void clearDataAfterTest(){
        System.out.println("After Each Test Case");
        manager = null;
    }
    @AfterAll
    public static void clearCommonData(){
        System.out.println("After All Test Case");
        expectedOrganizationName = null;
    }
}