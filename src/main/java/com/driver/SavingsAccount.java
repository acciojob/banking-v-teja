package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) throws Exception {
        // minimum balance is 0 by default
        super(name,balance,0);
        setMaxWithdrawalLimit(maxWithdrawalLimit);
        setRate(rate);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        try{
            if(amount>getMaxWithdrawalLimit()){
                throw new Exception("Maximum Withdraw Limit Exceed");
            }

            if(getBalance()-amount>getMinBalance()){
                throw new Exception("Insufficient Balance");
            }

            double temp  = getBalance()-amount;
            setBalance(temp);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = ( getBalance() * getRate() * years ) / 100;
        return simpleInterest + getBalance();
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double temp = 1+ (getRate()/(times*100));
        double interest = Math.pow(temp,(times*years));
        return getBalance() * interest;
    }

}
