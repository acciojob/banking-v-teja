package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount("Viswa",123.4,100);
        String str = account.generateAccountNumber(6,52);
        System.out.println(str);

    }
}