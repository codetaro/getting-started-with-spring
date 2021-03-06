package chapter07.bankapp.jdbc.service;

import chapter07.bankapp.jdbc.domain.BankAccountDetails;

public interface BankAccountService {
    int createBankAccount(BankAccountDetails bankAccountDetails);
}
