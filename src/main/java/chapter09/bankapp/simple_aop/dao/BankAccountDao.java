package chapter09.bankapp.simple_aop.dao;

import chapter09.bankapp.simple_aop.domain.BankAccountDetails;

public interface BankAccountDao {
    int createBankAccount(BankAccountDetails bankAccountDetails);
    void subtractFromAccount(int bankAccountId, int amount);
}
