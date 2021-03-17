package org.addai_poku.jeybank.classes;

import org.addai_poku.jeybank.interfaces.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
//        set initial transaction to 0 if the value provided is negative
        initialTransaction = initialTransaction < 0 ? 0 : initialTransaction;

        this.name = name;
//            instantiate the transactions arrayList
        this.transactions = new ArrayList<>();
//            add the initialTransaction to the arrayList
        this.transactions.add(initialTransaction);

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
//        don't allow negative transactions.
        if (transaction >= 0) {
            this.transactions.add(transaction);
        }

    }
}