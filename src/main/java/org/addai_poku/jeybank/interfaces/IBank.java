package org.addai_poku.jeybank.interfaces;

public interface IBank {
    boolean addBranch(String branchName);
    boolean addCustomer(String branchName, String customerName, double initialTransaction);
    boolean addCustomerTransaction(String branchName, String customerName, double transaction);
    boolean listCustomers(String branchName, boolean printTransactions);
}
