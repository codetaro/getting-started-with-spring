package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.AccountStatement;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository(value = "accountStatementDao")
@Log4j
public class AccountStatementDaoImpl implements AccountStatementDao {
    @Override
    public AccountStatement getAccountStatement(Date from, Date to) {
        log.info("Getting account statement");
        return new AccountStatement();
    }
}
