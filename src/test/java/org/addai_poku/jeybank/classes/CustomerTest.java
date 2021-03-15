package org.addai_poku.jeybank.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;
    ArrayList<Double> transactions;
    @Before
    public void setUp() throws Exception {

        customer = new Customer("customer1", 100.0);

    }

    @Test
    public void getName() {
//        name should be same as customer1
        assertEquals("customer1", customer.getName());
//        should not equal because name is not "unknown"
        assertNotEquals("unknown", customer.getName());
    }

    @Test
    public void getTransactions() {
//        transactions returned must be equal to local variable transactions
        assertEquals(transactions, customer.getTransactions());
    }

    @Test
    public void addTransaction() {
//        add a transaction
        customer.addTransaction(200.0);
//        check to see if the transactions array increased in size to 2
        assertEquals("Adding 1 more transaction to customer", 2, customer.getTransactions().size());
    }
}