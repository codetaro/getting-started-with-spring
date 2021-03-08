package chapter08.bankapp.service;

import chapter08.bankapp.domain.BankAccountDetails;

public interface BankAccountService {
    int createBankAccount(BankAccountDetails bankAccountDetails);
}
