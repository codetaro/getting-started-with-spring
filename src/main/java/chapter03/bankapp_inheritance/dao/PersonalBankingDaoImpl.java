package chapter03.bankapp_inheritance.dao;

import chapter03.bankapp_inheritance.domain.BankStatement;
import chapter03.bankapp_inheritance.utils.DatabaseOperations;

public class PersonalBankingDaoImpl implements PersonalBankingDao {
    private DatabaseOperations databaseOperations;

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public BankStatement getMiniStatement() {
        return databaseOperations.getMiniStatement();
    }
}
