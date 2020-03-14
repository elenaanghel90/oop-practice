package com.elenaciuca.home.exercises.banking;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountCSVRepository {
   private  List<Account> accounts = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";
    private static final String SEPARATOR = "\n";

    public List<Account> getAccounts() {

        return accounts;
    }

    public void saveAccount(Account account) {
        accounts.add(account);
    }
    public void deleteAccount(Account account) {
        accounts.remove(account);
    }
    public void loadAccountsFromCSV() {
        Path path = Paths.get("C:\\Users\\elena\\OneDrive\\Desktop\\UsersAccounts.csv");

        try {
            List<String> lines = Files.readAllLines(path);
            accounts = lines.stream()
                    .map(line -> line.split(","))
                    .map(values -> new Account(values[1], values[0], new BigDecimal(values[2])))
                    .collect(Collectors.toList());
//            for (String line : lines) {
//               String[] values = line.split(",");
//               Account account = new Account(values[1], values[0], new BigDecimal(values[2]));
//               accounts.add(account);
//            }
        } catch (IOException e) {
            throw new RuntimeException("Error in reading the CSV file!", e);
        }
//        Path path = Paths.get("C:\\Users\\elena\\OneDrive\\Desktop\\UsersAccounts.csv");
//        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
//
//            String line = br.readLine();
//
//            while (line != null) {
//                String[] attribute = line.split(",");
//                Account account = new Account(attribute[0], attribute[1], new BigDecimal(attribute[2]));
//                accounts.add(account);
//                line = br.readLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Error in reading the CSV file!");
//            e.printStackTrace();
//        }
    }

    public void exportAccountsToCSV() {

        //with Java 8
        Path path = Paths.get("C:\\Users\\elena\\OneDrive\\Desktop\\UsersAccounts.csv");
        List<String> lines = new ArrayList<>();
        lines = accounts.stream()
                .map(account -> account.getIban() + "," + account.getAccountHolder() + "," + account.getBalance())
                .collect(Collectors.toList());
//        for (Account account : accounts) {
//            String line = account.getIban() + "," + account.getAccountHolder() + "," + account.getBalance();
//            lines.add(line);
//        }
        try {
            Files.write(path, lines);
            System.out.println("The accounts were successfully exported!");
        } catch (IOException e) {
            throw new RuntimeException("Error in saving the account!", e);
        }

//        String path = "C:\\Users\\elena\\OneDrive\\Desktop\\UsersAccounts.csv";
//
//        try (FileWriter fileWriter = new FileWriter(path)){
//            for (Account account : accounts) {
//                fileWriter.append(account.getAccountHolder() + COMMA_DELIMITER + account.getIban() + COMMA_DELIMITER + account.getBalance() + SEPARATOR);
//                fileWriter.flush();
//            }
//            System.out.println("The account was successfully created!");
//        } catch (IOException e) {
//            System.out.println("Error in saving the account!");
//            e.printStackTrace();
//        }
    }
}
