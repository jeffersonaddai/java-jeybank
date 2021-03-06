package org.addai_poku.jeybank.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    Branch branch;
    @Before
    public void setUp() throws Exception {
        branch = new Branch("First Branch");
//        add first customer
        branch.newCustomer("customer1", 100.0);
    }

    @Test
    public void getName() {
//        check if the name is the same as the one assigned
        assertEquals( "First Branch", branch.getName());
    }

    @Test
    public void getCustomers() {
//        the name of the first customer in the returned customers array list must be "customer1"
        assertEquals("customer1", branch.getCustomers().get(0).getName());
    }

    @Test
    public void newCustomer() {
//        must not be able to add if name already exist; must return false
        assertFalse(branch.newCustomer("customer1", 100.0));
//        should be able to add a new customer and return true
        assertTrue(branch.newCustomer("customer2", 200.0));
//        should not be able to add a new customer with empty string.
        assertFalse(branch.newCustomer("", 200.0));
    }

    @Test
    public void addCustomerTransaction() {
//        must not be able to add if customer name does not exist
        assertFalse(branch.addCustomerTransaction("unknown", 100.0));
//        must not be able to add if transaction is less than or equal to 0
        assertFalse(branch.addCustomerTransaction("customer1", -1));
//        must be able to add
        assertTrue(branch.addCustomerTransaction("customer1", 100.0));
//        must be able to add even for different case of the customerName
        assertTrue(branch.addCustomerTransaction("Customer1", 100.0));
    }
}