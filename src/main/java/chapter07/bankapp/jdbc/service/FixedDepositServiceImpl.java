package chapter07.bankapp.jdbc.service;

import chapter07.bankapp.jdbc.dao.BankAccountDao;
import chapter07.bankapp.jdbc.dao.FixedDepositDao;
import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
//    @Qualifier(value = "fixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    @Transactional
    public int createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        bankAccountDao.subtractFromAccount(fdd.getBankAccountId(), fdd.getFdAmount());
        return myFixedDepositDao.createFixedDeposit(fdd);
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return myFixedDepositDao.getFixedDeposit(fixedDepositId);
    }
}
