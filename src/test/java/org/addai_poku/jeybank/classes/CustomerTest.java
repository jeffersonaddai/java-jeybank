package org.addai_poku.jeybank.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;
    @Before
    public void setUp() throws Exception {
        customer = new Customer("customer1", 100.0);
    }

    @Test
    public void getName() {
//        this method returns the name of the customer
//        name should be same as customer1
        assertEquals("customer1", customer.getName());
//        should not equal because name is not "unknown"
        assertNotEquals("unknown", customer.getName());
    }

    @Test
    public void getTransactions() {
//        This method returns an arrayList of the transactions of the customer
//        index 0 of the transactions returned must be equal to 100.0
        assertEquals(100.0, (double)customer.getTransactions().get(0), 0.0);
    }

    @Test
    public void addTransaction() {
//        this method adds a transaction to the arrayList of the customer
//        add a transaction
        customer.addTransaction(200.0);
//        check to see if the transactions array increased in size to 2
        assertEquals("Adding 1 more transaction to customer", 2, customer.getTransactions().size());
    }
}