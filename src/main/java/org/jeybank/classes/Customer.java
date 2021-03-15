package org.jeybank.classes;

import org.jeybank.interfaces.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
//        check if null object is not passed as argument to the constructor
        if(transactions != null){
            this.transactions = transactions;
        }
//        if null instantiate an ArrayList<Double> object and assign to transactions.
        else this.transactions = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    @Override
    public void addTransaction(Double transaction) {
        this.transactions.add(transaction);
    }
}
