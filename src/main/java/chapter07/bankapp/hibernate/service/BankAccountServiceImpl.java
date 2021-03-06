package chapter07.bankapp.hibernate.service;

import chapter07.bankapp.jdbc.dao.BankAccountDao;
import chapter07.bankapp.jdbc.domain.BankAccountDetails;
import chapter07.bankapp.jdbc.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    @Transactional
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return bankAccountDao.createBankAccount(bankAccountDetails);
    }
}
