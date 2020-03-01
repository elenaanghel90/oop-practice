package com.elenaciuca.home.exercises.banking;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    List<Account> accounts;

    public AccountManager() {
        this.accounts = new ArrayList<Account>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account createNewAccount(String accountHolder) {
        Account account = new Account(accountHolder);
        System.out.println("The account was created successfully and has the next details: " + account);
        accounts.add(account);

        return account;
    }

}
