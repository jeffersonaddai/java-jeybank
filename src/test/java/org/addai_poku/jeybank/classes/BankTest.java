package org.addai_poku.jeybank.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;
    @Before
    public void setUp() throws Exception {
        bank = new Bank("TestBank");
        //        add a branch to bank
        bank.addBranch("First Branch");
        //        add customer1 to first branch
        bank.addCustomer("First Branch", "customer1", 100.0);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addBranch() {
//        This method adds a new branch to the Bank object
//        should be able to add and return true since its a new branch
        assertTrue(bank.addBranch("New Branch"));
//        should not be able to add and return false because branch already exist
        assertFalse(bank.addBranch("First Branch"));
    }

    @Test
    public void addCustomer() {
//        try to add a new customer
        assertTrue(bank.addCustomer("First Branch","customer2", 200.0));
//        should be able to add irrespective of the case of the branch name
        assertTrue(bank.addCustomer("FIRST Branch","customer4", 200.0));

//      should not be able to add a customer with empty name
        assertFalse(bank.addCustomer("First Branch","", 200.0));
//        should return false if branch doesn't exist
        assertFalse(bank.addCustomer("Unknown Branch", "customer3", 100.0));
//        should return false if customer already exist in the branch
        assertFalse(bank.addCustomer("First Branch", "customer1", 50.0));

    }

    @Test
    public void addCustomerTransaction() {
        //        should return false if a transaction is negative or zero
        assertFalse(bank.addCustomerTransaction("First Branch", "customer1", -100.0));
//        should be able to add and return true
        assertTrue(bank.addCustomerTransaction("First Branch", "customer1", 100.0));
//        should return false if branch doesn't exist
        assertFalse(bank.addCustomerTransaction("Unknown Branch", "customer1", 100.0));
    }

    @Test
    public void listCustomers() {
//        should be able to list customers and return true
        assertTrue(bank.listCustomers("First Branch", true));
//        should return false if branch doesn't exist
        assertFalse(bank.listCustomers("Unknown Branch", true));
    }
}