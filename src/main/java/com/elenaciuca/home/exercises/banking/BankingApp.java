package com.elenaciuca.home.exercises.banking;

import java.util.Optional;
import java.util.Scanner;

/**
 * O banca nou infiintata doreste o aplicatie prin care angajatii sa poata
 * vizualiza soldul conturilor, sa poata crea noi conturi si sa poata face transferuri intre
 * cele doua conturi.
 * <p>
 * Datele create de aplicatie trebuie salvate pe disk pentru a putea fi utilizate si in
 * urma unei reporniri a aplicatiei/sistemului.
 * <p>
 * Pentru versiunea
 */
public class BankingApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountCSVRepository accountCSVRepository = new AccountCSVRepository();
        AccountManager accountManager = new AccountManager(accountCSVRepository);
        accountCSVRepository.loadAccountsFromCSV();

        while (true) {
            Integer option = readOptionFromKeyboard(scan);

            switch (option) {
                case 1:
                    System.out.println("Please provide the account details: ");
                    String desiredAccountHolder = scan.nextLine();
                    accountManager.createNewAccount(desiredAccountHolder);
                    break;
                case 2:
                    System.out.println("The list of accounts: ");
                    accountManager.getAccounts().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Please write the iban: ");
                    String ibanDesired = scan.nextLine();
                    Optional<Account> accountOptional = accountManager.getAccountByIban(ibanDesired);
                    String message = accountOptional
                            .map(Object::toString) //it is possible that the account does not exist and with orElse we provide the alternative values/ message
                            .orElse("The account does not exist!");
                    System.out.println(message);
                    break;
                case 4:
                    System.out.println("Please write the iban: ");
                    String ibanDesiredToDelete = scan.nextLine();
                    Optional<Account> accountToDeleteOptional = accountManager.getAccountByIban(ibanDesiredToDelete);
                    accountToDeleteOptional.ifPresent(account -> {
                        accountManager.deleteTheAccount(account);
                        System.out.println("Account deleted successfully!");
                    });
                    break;
                case 5:
                    System.out.println("Please write the iban of the account to change the holder name: ");
                    String desiredIban = scan.nextLine();
                    //ar fi fost optional, dar pentru ca i-am dat o alternativasa nu dea null cu OrElseThow, ne returneaza Account
                    Account accountByIban = accountManager.getAccountByIban(desiredIban).orElseThrow(() -> new RuntimeException("The account does not exists"));
                    System.out.println("Please write the new holder name: ");
                    String introducedAccountHolder = scan.nextLine();
                    accountManager.updateTheHolderName(accountByIban, introducedAccountHolder);
                    break;
                case 6:
                    System.out.println("Please write the name of the holder: ");
                    String desiredName = scan.nextLine();
                    accountManager.getAccountsByName(desiredName).forEach(System.out::println);
                    break;
                case 0:
                    accountCSVRepository.exportAccountsToCSV();
                    scan.close();
                    return;
                default:
                    System.out.println("Please choose an option from menu! ");
            }
        }
    }

    private static Integer readOptionFromKeyboard(Scanner scan) {
        String input;
        do {
            showTheMenu();
            input = scan.nextLine().trim();
        } while (input.equals(""));

        return Integer.parseInt(input);
    }

    public static void showTheMenu() {
        System.out.println("1. Create an account: ");
        System.out.println("2. Show the list of accounts: ");
        System.out.println("3. Show the account with the iban: ");
        System.out.println("4. Delete the account with the iban: ");
        System.out.println("5. Update the holder name of the account with the iban: ");
        System.out.println("6. Show the accounts with the name: ");
        System.out.println("0. Quit");
    }
}
