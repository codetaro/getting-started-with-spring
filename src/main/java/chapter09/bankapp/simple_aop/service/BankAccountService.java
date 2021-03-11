package chapter09.bankapp.simple_aop.service;

import chapter09.bankapp.simple_aop.domain.BankAccountDetails;

public interface BankAccountService {
    int createBankAccount(BankAccountDetails bankAccountDetails);
}
