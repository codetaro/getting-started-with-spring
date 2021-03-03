package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.AccountStatement;

import java.util.Date;

public interface AccountStatementDao {
    AccountStatement getAccountStatement(Date from, Date to);
}
