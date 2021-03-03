package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.dao.AccountStatementDao;
import chapter06.bankapp.annotations.domain.AccountStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "accountStatementService")
public class AccountStatementServiceImpl implements AccountStatementService {
    @Autowired
    private AccountStatementDao accountStatementDao;

    @Override
    public AccountStatement getAccountStatement(Date from, Date to) {
        return accountStatementDao.getAccountStatement(from, to);
    }
}
