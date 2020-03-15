package com.elenaciuca.home.exercises.banking;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Account> getAccountByIban(String iban) {
        List<Account> accounts = accountCSVRepository.getAccounts();
        Optional<Account> foundAccount = accounts.stream()
                .filter(account -> account.getIban().equals(iban))
                .findFirst();
        return foundAccount;
    }

    public Account updateTheHolderName(Account account, String holderName) {
        List<Account> accounts = accountCSVRepository.getAccounts();
        String desiredIban = account.getIban();
        Account foundAccount = accounts.stream()
                .filter(accountA -> accountA.getIban().equals(desiredIban))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The account with iban does not exist"));//lambda supplier, care nu primeste niciun parametru
        foundAccount.setAccountHolder(holderName);
        return foundAccount;
    }


    public List<Account> getAccountsByName(String name) {
        List<Account> accounts = accountCSVRepository.getAccounts();
        List<Account> foundAccounts = accounts.stream()
                .filter(account -> account.getAccountHolder().toLowerCase().contains(name.toLowerCase())) //contains cauta un substring, daca cauti "man" si ai in lista Emanuel, returneaza true.
                .collect(Collectors.toList());
        return foundAccounts;
    }

    public void deleteTheAccount(Account account) {
        accountCSVRepository.deleteAccount(account);
    }

    public void sendTheMoney(BigDecimal sum, String ibanSourceAccount, String ibanDestinationAccount) {
        Account sourceAccount = getAccountByIban(ibanSourceAccount).orElseThrow(() -> new RuntimeException("The introduced iban is not correct!"));
        Account destinationAccount = getAccountByIban(ibanDestinationAccount).orElseThrow(() -> new RuntimeException("The introduced iban is not correct!"));
        sourceAccount.debitAccount(sum);
       try {
           destinationAccount.creditAccount(sum);
       }
       catch(Exception e){
           sourceAccount.creditAccount(sum); //in cazul in care ai o eroare, ca sa nu ramana intr-o stare inconsistenta, adica sa nu ramana contul sursa debitat(fara banii pe care trebuia sa ii transfere)
       }
    }

}
