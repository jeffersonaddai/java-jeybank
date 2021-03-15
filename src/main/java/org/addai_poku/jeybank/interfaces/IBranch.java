package org.addai_poku.jeybank.interfaces;

import org.addai_poku.jeybank.classes.Customer;

import java.util.ArrayList;

public interface IBranch {
    String getName();
    ArrayList<Customer> getCustomers();
    boolean newCustomer(String customerName, double initialTransaction);
    boolean addCustomerTransaction(String customerName, double transaction);

}
