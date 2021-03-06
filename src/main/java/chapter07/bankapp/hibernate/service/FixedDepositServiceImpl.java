package chapter07.bankapp.hibernate.service;

import chapter07.bankapp.jdbc.dao.BankAccountDao;
import chapter07.bankapp.jdbc.dao.FixedDepositDao;
import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import chapter07.bankapp.jdbc.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    @Transactional
    public int createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        bankAccountDao.subtractFromAccount(fdd.getBankAccountDetails().getAccountId(),
                fdd.getFdAmount());
        return fixedDepositDao.createFixedDeposit(fdd);
    }

    @Override
    @Transactional
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return fixedDepositDao.getFixedDeposit(fixedDepositId);
    }
}
