package com.elenaciuca.home.exercises.banking;

import java.util.Arrays;

public enum MenuItem {
    CREATE_AN_ACCOUNT(1, "Create an account "),
    SHOW_THE_LIST_OF_ACCOUNTS(2, "Show the list of accounts"),
    SHOW_THE_ACCOUNT_OF_THE_IBAN(3, "Show the account with the iban"),
    DELETE_THE_ACCOUNT_WITH_THE_IBAN(4, "Delete the account with the iban"),
    UPDATE_THE_HOLDER_NAME_OF_THE_ACCOUNT_OF_THE_IBAN(5, "Update the holder name of the account with the iban"),
    SHOW_THE_ACCOUNTS_WITH_THE_NAME(6, "Show the accounts with the name"),
    TRANSFER_THE_MONEY_BETWEEN_TWO_ACCOUNTS(7, "Transfer money between two accounts"),
    TOP_UP_THE_ACCOUNT(8, "Top up an account"),
    QUIT(0, "QUIT");

    private int id;
    private String description;

    MenuItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static MenuItem fromId(int id) {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> menuItem.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The option " + id + " does not exist!"));
    }

    @Override
    public String toString() {
        return id + ". " + description;
    }
}
