package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }


    public BankAccount(String name, double balance, double minBalance) {
        setName(name);
        setBalance(balance);
        setMinBalance(minBalance);
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(9*digits<sum){
            throw new Exception("Account Number can not be generated");
        }
        String accountNumber = "";
        Random rd = new Random();
        for(int i=0;i<digits;i++){
            if(sum>9){
                accountNumber+=9;
                sum-=9;
            }else{
                if(i==digits-1){
                    accountNumber += sum;
                }else{
                    accountNumber+=0;
                }
            }
        }

        return accountNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
        double temp = getBalance()+amount;
        setBalance(temp);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount>getBalance()){
            throw new Exception("Insufficient Balance");
        }

        double temp = getBalance()-amount;
        setBalance(temp);
    }

}