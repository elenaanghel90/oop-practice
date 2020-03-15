package com.elenaciuca.home.exercises.banking;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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
            MenuItem option = readOptionFromKeyboard(scan);

            switch (option) {
                case CREATE_AN_ACCOUNT:
                    System.out.println("Please provide the account details: ");
                    String desiredAccountHolder = scan.nextLine();
                    accountManager.createNewAccount(desiredAccountHolder);
                    break;
                case SHOW_THE_LIST_OF_ACCOUNTS:
                    System.out.println("The list of accounts: ");
                    accountManager.getAccounts().forEach(System.out::println);
                    break;
                case SHOW_THE_ACCOUNT_OF_THE_IBAN:
                    System.out.println("Please write the iban: ");
                    String ibanDesired = scan.nextLine();
                    Optional<Account> accountOptional = accountManager.findAccountByIban(ibanDesired);
                    String message = accountOptional
                            .map(Object::toString) //it is possible that the account does not exist and with orElse we provide the alternative values/ message
                            .orElse("The account does not exist!");
                    System.out.println(message);
                    break;
                case DELETE_THE_ACCOUNT_WITH_THE_IBAN:
                    System.out.println("Please write the iban: ");
                    String ibanDesiredToDelete = scan.nextLine();
                    Account accountToDelete = accountManager.getExistingAccountByIban(ibanDesiredToDelete);
                    accountManager.deleteTheAccount(accountToDelete);
                    System.out.println("Account deleted successfully!");
                    break;
                case UPDATE_THE_HOLDER_NAME_OF_THE_ACCOUNT_OF_THE_IBAN:
                    System.out.println("Please write the iban of the account to change the holder name: ");
                    String desiredIban = scan.nextLine();
                    //ar fi fost optional, dar pentru ca i-am dat o alternativa sa nu dea null cu OrElseThow, ne returneaza Account
                    Account account = accountManager.getExistingAccountByIban(desiredIban);
                    System.out.println("Please write the new holder name: ");
                    String introducedAccountHolder = scan.nextLine();
                    accountManager.updateTheHolderName(account, introducedAccountHolder);
                    break;
                case SHOW_THE_ACCOUNTS_WITH_THE_NAME:
                    System.out.println("Please write the name of the holder: ");
                    String desiredName = scan.nextLine();
                    accountManager.getAccountsByName(desiredName).forEach(System.out::println);
                    break;
                case TRANSFER_THE_MONEY_BETWEEN_TWO_ACCOUNTS:
                    System.out.println("Please write the sum you wish to transfer: ");
                    BigDecimal sum = scan.nextBigDecimal();
                    scan.nextLine();
                    System.out.println("Please write the iban of the source account: ");
                    String sourceAccount = scan.nextLine();
                    System.out.println("Please write the iban of the destination account: ");
                    String destinationAccount = scan.nextLine();
                    accountManager.sendTheMoney(sum, sourceAccount, destinationAccount);
                    System.out.println("The money were transferred successfully!");
                    break;
                case TOP_UP_THE_ACCOUNT:
                    System.out.println("Please write the sum you wish to transfer: ");
                    BigDecimal sumMoney = scan.nextBigDecimal();
                    scan.nextLine();
                    System.out.println("Please write the iban of the destination account: ");
                    String destinationIban = scan.nextLine();
                    accountManager.topUpAnAccount(sumMoney, destinationIban);
                    accountManager.findAccountByIban(destinationIban).ifPresent(account1 ->
                            System.out.println("The new balance is: " + account1.getBalance())
                    );
                    System.out.println("The account was topped up successfully!");
                    break;
                case QUIT:
                    accountCSVRepository.exportAccountsToCSV();
                    scan.close();
                    return;
                default:
                    System.out.println("Please choose an option from menu! ");
            }
        }
    }

    private static MenuItem readOptionFromKeyboard(Scanner scan) {
        String input;
        do {
            showTheMenu();
            input = scan.nextLine().trim();
        } while (input.equals(""));
        int option = Integer.parseInt(input);
        return MenuItem.fromId(option);
    }

    public static void showTheMenu() {
        MenuItem[] menuItems = MenuItem.values(); //pt ca values ne retunreaza un array
        Arrays.stream(menuItems).forEach(menuItem -> System.out.println(menuItem));
    }
}
