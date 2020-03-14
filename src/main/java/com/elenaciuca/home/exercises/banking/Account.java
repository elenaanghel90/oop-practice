package com.elenaciuca.home.exercises.banking;

import java.math.BigDecimal;
import java.util.Random;

public class Account {

    private String iban;
    private BigDecimal balance;
    private String accountHolder;

    //this is used to create a new account
    public Account(String accountHolder) {
        this.iban = generateNewIban();
        this.accountHolder = accountHolder;
        this.balance = BigDecimal.ZERO;
    }

    //this is used to create the account from CSV
    public Account(String accountHolder, String iban, BigDecimal balance) {
        this.accountHolder = accountHolder;
        this.iban = iban;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public Account setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
        return this;
    }

    private String generateNewIban() {
        Random random = new Random();
        String countryCode = "RO";
        String bankCode = "0INGB";
        int accountNumber = Math.abs(random.nextInt());

        return String.format("%s%s%011d", countryCode, bankCode, accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", accountHolder='" + accountHolder + '\'' +
                '}';
    }
}
