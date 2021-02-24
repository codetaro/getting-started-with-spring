package chapter04.bankapp_autowiring.dao;

import chapter04.bankapp_autowiring.domain.AccountStatement;

import java.util.Date;

public interface AccountStatementDao {
    AccountStatement getAccountStatement(Date from, Date to);
}
