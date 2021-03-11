package chapter09.bankapp.simple_aop.service;

import chapter09.bankapp.simple_aop.dao.BankAccountDao;
import chapter09.bankapp.simple_aop.domain.BankAccountDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bankAccountService")
@Log4j
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        log.info("createBankAccount method invoked");
        return bankAccountDao.createBankAccount(bankAccountDetails);
    }
}
