package org.addai_poku.jeybank.classes;

import org.addai_poku.jeybank.interfaces.IBank;

import java.util.ArrayList;

public class Bank implements IBank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    @Override
    public boolean addBranch(String branchName) {
        //        check if customer does not exist already
//        don't allow branch without names to be added
        if(findBranch(branchName)==null && !branchName.equals("")){
//            create new branch object with branch name
            Branch branch = new Branch(branchName);

//            add the customer to the customers field and return true
            this.branches.add(branch);
            return true;
        }
//        otherwise return false
        else return false;
    }

    @Override
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
//        check if the branch exists
        if(findBranch(branchName) != null){
//            add the customer to the branch and return true
//            if the customer already exists newCustomer() would return false
            return findBranch(branchName).newCustomer(customerName, initialTransaction);
        }
//        otherwise branch does not exist return false
        else return false;
    }

    @Override
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        //        check if the branch exists
        if(findBranch(branchName) != null){
//            add the transaction to the customer in the branch and return true
//            if customer does not exist or transaction is negative addCustomerTransaction() would return false
            return findBranch(branchName).addCustomerTransaction(customerName, transaction);
        }
//        otherwise branch does not exist return false
        else return false;
    }

    @Override
    public boolean listCustomers(String branchName, boolean printTransactions) {
//        check if branch exists
        if(findBranch(branchName) != null){
//            get the branch
            Branch branch = findBranch(branchName);
            System.out.print("Customer details for branch " + branchName);
            // check if printTransactions is true
            if(printTransactions){
//                List the customers in the branch and print transactions
                for(Customer customer: branch.getCustomers()){
                    System.out.printf("\nCustomer: %s[%d]", customer.getName(), branch.getCustomers().indexOf(customer)+1);
                    System.out.print("\nTransactions");
                    for(int i = 0; i < customer.getTransactions().size(); i++){
                        System.out.printf("\n[%d] Amount %f", i+1, customer.getTransactions().get(i));
                    }
                }
            }
//            otherwise print just the customers
            else for(Customer customer: branch.getCustomers()) {
                System.out.printf("\nCustomer: %s[%d]", customer.getName(), branch.getCustomers().indexOf(customer)+1);
            }
            return true;
        }
//        otherwise branch name does not exist return false;
        return false;
    }


    private Branch findBranch(String branchName) {
        //        loop through the branches array list
        for(Branch branch: this.branches){
//            check if the current name is equal to the provided branchName
            if(branch.getName().equalsIgnoreCase(branchName)){
//                return the branch object if the name matches
                return branch;
            }
        }
//        otherwise return null
        return null;
    }
}
