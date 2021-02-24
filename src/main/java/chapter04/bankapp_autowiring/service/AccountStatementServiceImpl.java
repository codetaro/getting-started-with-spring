package chapter04.bankapp_autowiring.service;

import chapter04.bankapp_autowiring.dao.AccountStatementDao;
import chapter04.bankapp_autowiring.domain.AccountStatement;
import lombok.Setter;

import java.util.Date;

public class AccountStatementServiceImpl implements AccountStatementService {
    @Setter private AccountStatementDao accountStatementDao;

    @Override
    public AccountStatement getAccountStatement(Date from, Date to) {
        return accountStatementDao.getAccountStatement(from, to);
    }
}
