package chapter04.bankapp_autowiring.dao;

import chapter04.bankapp_autowiring.domain.AccountStatement;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Log4j
public class AccountStatementDaoImpl implements AccountStatementDao {

    @Override
    public AccountStatement getAccountStatement(Date from, Date to) {
        log.info("Getting account statement");
        return new AccountStatement();
    }
}
