package com.saravanjs.java22.console.designpatterns.builder;

/**
 * @author Sarav on 20 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.builder
 * @class BuilderPatternDriver
 */

public class BuilderPatternDriver {
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount
                .BankAccountBuilder("Jon", "22738022275")
                .withEmail("jon@example.com")
                .wantNewsletter(true)
                .build();

        System.out.println("Name: " + newAccount.getName());
        System.out.println("AccountNumber:" + newAccount.getAccountNumber());
        System.out.println("Email: " + newAccount.getEmail());
        System.out.println("Want News letter?: " + newAccount.isNewsletter());
    }
}