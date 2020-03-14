package com.elenaciuca.home.exercises.banking;

import java.util.List;
import java.util.Optional;

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
    public Optional<Account> getAccountByIban(String iban){
      List<Account> accounts = accountCSVRepository.getAccounts();
      Optional<Account> accountFound= accounts.stream()
              .filter(account -> account.getIban().equals(iban))
              .findFirst();
      return accountFound;
    }

    //delete an account by name
    //get an account by iban
    //update an account by iban
    //search by name (can provide many results according to a name)

}
