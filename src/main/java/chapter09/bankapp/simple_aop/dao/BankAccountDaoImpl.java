package chapter09.bankapp.simple_aop.dao;

import chapter09.bankapp.simple_aop.domain.BankAccountDetails;
import org.springframework.stereotype.Repository;

@Repository(value = "bankAccountDao")
public class BankAccountDaoImpl implements BankAccountDao {
    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return 1;
    }

    @Override
    public void subtractFromAccount(int bankAccountId, int amount) {

    }
}
