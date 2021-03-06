package chapter07.bankapp.tx_jdbc.service;

import chapter07.bankapp.jdbc.dao.BankAccountDao;
import chapter07.bankapp.jdbc.domain.BankAccountDetails;
import chapter07.bankapp.jdbc.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return bankAccountDao.createBankAccount(bankAccountDetails);
    }
}
