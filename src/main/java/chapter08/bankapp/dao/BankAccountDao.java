package chapter08.bankapp.dao;

import chapter08.bankapp.domain.BankAccountDetails;

public interface BankAccountDao {
    int createBankAccount(BankAccountDetails bankAccountDetails);
    void subtractFromAccount(int bankAccountId, int amount);
}
