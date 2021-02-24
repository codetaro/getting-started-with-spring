package chapter04.bankapp_autowiring.service;

import chapter04.bankapp_autowiring.domain.AccountStatement;

import java.util.Date;

public interface AccountStatementService {
    AccountStatement getAccountStatement(Date from, Date to);
}
