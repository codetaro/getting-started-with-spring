package chapter08.bankapp.dao;

import chapter08.bankapp.domain.BankAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
    private SimpleJdbcInsert insertBankAccountDetail;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.insertBankAccountDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("bank_account_details")
                .usingGeneratedKeyColumns("bank_account_id");
    }

    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("balance_amount", bankAccountDetails.getBalanceAmount());
        parameters.put("last_transaction_ts", new java.sql.Date(
                bankAccountDetails.getLastTransactionTimestamp().getTime()));
        Number key = insertBankAccountDetail.executeAndReturnKey(parameters);
        return key.intValue();
    }

    @Override
    public void subtractFromAccount(int bankAccountId, int amount) {
        jdbcTemplate.update(
                "update bank_account_details set balance_amount = ? where account_id = ?",
                amount, bankAccountId);
    }
}
