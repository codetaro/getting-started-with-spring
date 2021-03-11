package chapter09.bankapp.aop_proxy.service;

import chapter09.bankapp.simple_aop.domain.BankAccountDetails;

public interface BankAccountService {
    int createBankAccount(BankAccountDetails bankAccountDetails);
    boolean isDuplicateAccount(BankAccountDetails bankAccountDetails);
}
