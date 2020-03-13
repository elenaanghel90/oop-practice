package com.elenaciuca.home.exercises.banking;

import java.util.List;

public class AccountManager {
    private final AccountCSVRepository accountCSVRepository;


    public AccountManager(AccountCSVRepository accountCSVRepository) {
        this.accountCSVRepository = accountCSVRepository;
    }

    public List<Account> getAccounts() {
        return accountCSVRepository.getAccounts();
    }

    public Account createNewAccount(String accountHolder) {
        Account account = new Account(accountHolder);
        System.out.println("The account was created successfully and has the next details: " + account);
        accountCSVRepository.saveAccount(account);

        return account;
    }

    //delete an account from iban
    //get an account by iban
    //update an account by iban
    //search by name (can provide many results according to a name)

}
