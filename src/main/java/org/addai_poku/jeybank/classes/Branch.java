package org.addai_poku.jeybank.classes;

import org.addai_poku.jeybank.interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    @Override
    public boolean newCustomer(String customerName, double initialTransaction) {
//        check if customer does not exist already. Do not allow empty strings to be passed as names
        if(findCustomer(customerName)==null && !customerName.equals("") && initialTransaction >= 0){
//            create new customer object with customer name and the initial transaction
            Customer customer = new Customer(customerName, initialTransaction);
//            add the customer to the customers field
            this.customers.add(customer);
            return true;
        }
        else return false;
    }

    @Override
    public boolean addCustomerTransaction(String customerName, double transaction) {

//        check if the customer exist and the transaction is greater than 0
        if((findCustomer(customerName) != null) && transaction > 0){
//            add transaction to the customer returned by the findCustomer() method
            findCustomer(customerName).addTransaction(transaction);
            return true;
        }
        else return false;
    }

    private Customer findCustomer(String customerName){
//        loop through the customers array list
        for(Customer customer: this.customers){
//            check if the current name is equal to the provided customerName
            if(customer.getName().equalsIgnoreCase(customerName)){
//                return the customer object if the name matches
                return customer;
            }
        }
//        otherwise return null
        return null;
    }
}
