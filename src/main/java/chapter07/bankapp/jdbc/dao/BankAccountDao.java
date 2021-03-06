package chapter07.bankapp.jdbc.dao;

import chapter07.bankapp.jdbc.domain.BankAccountDetails;

public interface BankAccountDao {
    int createBankAccount(BankAccountDetails bankAccountDetails);
    void subtractFromAccount(int bankAccountId, int amount);
}
