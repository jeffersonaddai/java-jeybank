package org.jeybank.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;
    ArrayList<Double> transactions;
    @Before
    public void setUp() throws Exception {
        transactions = new ArrayList<>();
        transactions.add(100.0);
        customer = new Customer("customer1", transactions);

    }

    @Test
    public void getName() {
//        name should be same as customer1
        assertEquals(customer.getName(), "customer1");
//        should return false because name is not "unknown"
        assertNotEquals(customer.getName(), "unknown");
    }

    @Test
    public void getTransactions() {
//        transactions returned must be equal to local variable transactions
        assertEquals(customer.getTransactions(), transactions);
    }

    @Test
    public void addTransaction() {
//        add a transaction
        customer.addTransaction(200.0);
//        check to see if the transactions array increased in size to 2
        assertEquals("Adding 1 more transaction to customer", 2, customer.getTransactions().size());
    }
}