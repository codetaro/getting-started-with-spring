package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.domain.AccountStatement;

import java.util.Date;

public interface AccountStatementService {
    AccountStatement getAccountStatement(Date from, Date to);
}
