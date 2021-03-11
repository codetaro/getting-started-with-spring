package chapter09.bankapp.aop_proxy.service;

import chapter09.bankapp.aop_proxy.exception.BankAccountAlreadyExistsException;
import chapter09.bankapp.aop_proxy.dao.BankAccountDao;
import chapter09.bankapp.simple_aop.domain.BankAccountDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        log.info("createBankAccount method invoked");

        boolean isDuplicateAccount = ((BankAccountService) AopContext.currentProxy()).isDuplicateAccount(bankAccountDetails);
        if (!isDuplicateAccount) {
            return bankAccountDao.createBankAccount(bankAccountDetails);
        } else {
            throw new BankAccountAlreadyExistsException("Bank account already exists");
        }
    }

    @Override
    public boolean isDuplicateAccount(BankAccountDetails bankAccountDetails) {
        return false;
    }
}
