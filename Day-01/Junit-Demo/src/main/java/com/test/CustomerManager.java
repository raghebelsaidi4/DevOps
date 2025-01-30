package com.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//class to add customers to the HashMap (act as database)
public class CustomerManager {

    private final Map<String, Customer> customers = new HashMap<String, Customer>();
    private String originzationName = "Software Engineering";

    public String getOriginzationName() {
        return originzationName;
    }

    // add customer data into HashMap
    public Customer addCustomer(String id, String firstName, String lastName, String phoneNumber) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);

        boolean exists = CheckIfCustomerAlreadyExists(customer);
        if (!exists) {
            customers.put(customer.getCustomerId(), customer);
        }
        return customer;
    }

    private boolean CheckIfCustomerAlreadyExists(Customer customer) {
        return customers.containsKey(customer.getCustomerId()); // key is unique
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
